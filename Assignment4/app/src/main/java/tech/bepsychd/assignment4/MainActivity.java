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
    Button updateBtn;
    Button deleteBtn;
    private EditText nameEdit;
    private EditText emailEdit;
    private EditText showEdit;
    private EditText idEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DatabaseHelper(this);

        //ADD DATA
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
                //TODO: See if blank entry check needs to be added?
                Toast.makeText(MainActivity.this, "Record Added.", Toast.LENGTH_LONG).show();
            }
        });

        //VIEW DATA
        viewBtn = (Button) findViewById(R.id.seeall);
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListStoredData.class);
                startActivity(intent);
            }
        });

        //UPDATE DATA
        updateBtn = findViewById(R.id.update);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idEdit = findViewById(R.id.id);
                String id = idEdit.getText().toString();
                if (id != null && !id.isEmpty()) {
                    //Note: As integral id used, '003' considered as '3' (default working of valueOf)
                    Integer idVal = Integer.valueOf(id);
                    if(findElement(idVal)) {
                        String name = nameEdit.getText().toString();
                        String email = emailEdit.getText().toString();
                        String show = showEdit.getText().toString();
                        dbHelper.updateData(idVal, name, email, show);
                        Toast.makeText(MainActivity.this, "Record Updated.", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(MainActivity.this, "Record for ID: "+idVal+" not found.", Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(MainActivity.this, "Please enter ID", Toast.LENGTH_SHORT).show();
            }
        });

        //DELETE DATA
        deleteBtn = findViewById(R.id.delete);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idEdit = findViewById(R.id.id);
                String id = idEdit.getText().toString();
                if (id != null && !id.isEmpty()) {
                    //Note: As integral id used, '003' considered as '3' (default working of valueOf)
                    Integer idVal = Integer.valueOf(id);
                    if(findElement(idVal)) {
                        String name = nameEdit.getText().toString();
                        String email = emailEdit.getText().toString();
                        String show = showEdit.getText().toString();
                        dbHelper.deleteData(idVal);
                        Toast.makeText(MainActivity.this, "Record Deleted.", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(MainActivity.this, "Record for ID: "+idVal+" not found.", Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(MainActivity.this, "Please enter ID", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private boolean findElement(Integer idVal) {
        Cursor data = dbHelper.getItemRef(idVal);
        if (data.moveToNext())
            return true;
        return false;
    }

}
