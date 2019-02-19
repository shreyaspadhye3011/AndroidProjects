package tech.bepsychd.quiz2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private String id = "";
    private Button btn;
    private EditText edit;
    private static ArrayList<String> registeredArray = new ArrayList<String>();
    private String errorTxt = "Student ALREADY registered!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit = (EditText) findViewById(R.id.editText);
                id = String.valueOf(edit.getText());
                if(registeredArray.contains(id)) {
                    Toast.makeText(MainActivity.this, errorTxt, Toast.LENGTH_SHORT).show();
                } else {
                    registeredArray.add(id);
                    String msgText = "Student " + id + " registered successfully";
                    Toast.makeText(MainActivity.this, msgText, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
