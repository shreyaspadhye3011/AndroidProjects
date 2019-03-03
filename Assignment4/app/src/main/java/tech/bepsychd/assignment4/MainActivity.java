package tech.bepsychd.assignment4;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    private Button addBtn;
    private Button viewBtn;
    private EditText nameEdit;
    private EditText emailEdit;
    private EditText showEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DatabaseHelper(this);

        addBtn = (Button) findViewById(R.id.add);
        nameEdit = (EditText) findViewById(R.id.name);
        emailEdit = (EditText) findViewById(R.id.email);
        showEdit = (EditText) findViewById(R.id.tvshow);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEdit.getText().toString();
                String email = emailEdit.getText().toString();
                String show = showEdit.getText().toString();
                dbHelper.addData(name, email, show);
                Toast.makeText(MainActivity.this, "Record Added.", Toast.LENGTH_LONG).show();
            }
        });

        viewBtn = (Button) findViewById(R.id.seeall);
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListStoredData.class);
                startActivity(intent);
            }
        });
    }



    private boolean getItemReference(String mobile, String model) {
        String concatString = mobile + model;
        Cursor data = dbHelper.getItemRef(concatString);
        if (data.moveToNext()) {
            return true;
        } else
            return false;
    }

    private boolean getUpdatedItemReference(String mobile, String model) {
        Cursor data = dbHelper.getData();
        String storedMobile;
        String storedModel;
        Boolean found = false;
        while (data.moveToNext()) {
            storedMobile = data.getString(1);
            storedModel = data.getString(2);
            if (storedMobile == mobile && storedModel == model) {
                System.out.println("MObile: "+mobile+" Model: "+model+"SMo: ");
                found = true;
            }
        }

        if(found)
            return true;
        else
            return false;
    }

//    private void populateListView() {
//        Cursor data = mDatabaseHelper.getData();
//        ArrayList<String> listData = new ArrayList<>();
//        while (data.moveToNext()) {
//            // get all names and put in list
//            listData.add(data.getString(1));
//        }
//
//        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
//        mListView.setAdapter(adapter);
//
//    }
}
