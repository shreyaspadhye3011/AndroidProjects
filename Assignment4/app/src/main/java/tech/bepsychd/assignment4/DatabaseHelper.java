package tech.bepsychd.assignment4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "tv_show";
    private static final String COL1 = "ID";
    private static final String COL2 = "name";
    private static final String COL3 = "email";
    private static final String COL4 = "show";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " TEXT, "+ COL3 + " TEXT, "+COL4 +" TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
    }

    public boolean addData(String name, String email, String show) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name);
        contentValues.put(COL3, email);
        contentValues.put(COL4, show);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getItemRef(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME + " WHERE "+ COL1 +" ="+id;
        System.out.println("*************");
        System.out.println(query);
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void updateData(Integer id, String name, String email, String show) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name);
        contentValues.put(COL3, email);
        contentValues.put(COL4, show);
        db.update(TABLE_NAME, contentValues, "ID="+id, null);
    }

    public void deleteData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM "+TABLE_NAME;
        System.out.println(query);
        db.delete(TABLE_NAME, null, null);
    }
}
