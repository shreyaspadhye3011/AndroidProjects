package tech.bepsychd.assignment4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "mobile_model";
    private static final String COL1 = "mobile";
    private static final String COL2 = "model";
    private static final String COL3 = "concatString";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(mobile TEXT, " + COL2 + " TEXT, "+ COL3 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
    }

    public boolean addData(String mobile, String model) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String concatString = mobile + model;
        contentValues.put(COL1, mobile);
        contentValues.put(COL2, model);
        contentValues.put(COL3, concatString);

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

    public Cursor getItemRef(String concatString) {
        SQLiteDatabase db = this.getWritableDatabase();
        concatString = "'"+ concatString +"'";
        String query = "SELECT * FROM "+ TABLE_NAME + " WHERE "+ COL3 +" ="+concatString;
        System.out.println(query);
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void deleteData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM "+TABLE_NAME;
        System.out.println(query);
        db.delete(TABLE_NAME, null, null);
    }
}
