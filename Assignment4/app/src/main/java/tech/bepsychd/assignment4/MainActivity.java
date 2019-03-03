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
    private EditText idEdit;

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
                //TODO: Add created id's info in Toast
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

        Button updateBtn = findViewById(R.id.update);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idEdit = findViewById(R.id.id);
                //TODO: Add only spaces check
                //TODO: Test 0000 case - wjether it rasies issues in the int datatype
                String id = idEdit.getText().toString();
                if (id != null) {

                }
            }
        });
    }

//    private boolean getItemReference(String id) {
//        Cursor data = dbHelper.getData();
//        Integer idStr = (Integer) id;
//        Boolean found = false;
//        while (data.moveToNext()) {
//            storedMobile = data.getString(1);
//            storedModel = data.getString(2);
//            if (storedMobile == mobile && storedModel == model) {
//                System.out.println("MObile: "+mobile+" Model: "+model+"SMo: ");
//                found = true;
//            }
//        }
//
//        if(found)
//            return true;
//        else
//            return false;
//    }
}
