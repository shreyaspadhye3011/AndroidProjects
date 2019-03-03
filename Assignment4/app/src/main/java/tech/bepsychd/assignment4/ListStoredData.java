package tech.bepsychd.assignment4;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListStoredData extends AppCompatActivity {
    DatabaseHelper dbHelper;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        mListView = findViewById(R.id.listview);
        dbHelper = new DatabaseHelper(this);
        populateData();
    }

    private void populateData() {
        Cursor data = dbHelper.getData();
        System.out.println("//////COUNT!!"+data.getColumnCount());
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()) {
            listData.add("ID: " + data.getInt(0) +"\nName: "+ data.getString(1) +"\nEmail: "+data.getString(2) +"\nFavorite Tv Show: " + data.getString(3));
        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);

    }

}
