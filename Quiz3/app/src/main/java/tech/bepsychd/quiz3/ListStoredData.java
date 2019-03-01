package tech.bepsychd.quiz3;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

        Button delBtn = (Button) findViewById(R.id.button);
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              dbHelper.deleteData();
            }
        });
    }

    private void populateData() {
        Cursor data = dbHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()) {
            listData.add("Mobile: " + data.getString(1) +" | Model: "+ data.getString(2));
        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);

    }

}
