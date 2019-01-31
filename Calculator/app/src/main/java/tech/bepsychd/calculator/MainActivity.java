package tech.bepsychd.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private TextView resultView;
    private EditText val1;
    private EditText val2;
    private String currentOperation = "None";
    private String resultVal = "";
    private BigDecimal numFirst = new BigDecimal("0");
    private BigDecimal numSecond = new BigDecimal("0");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("$$$ Flow!!!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        val1 = (EditText)findViewById(R.id.input1);
        val2 = (EditText)findViewById(R.id.input2);
        resultView = (TextView) findViewById(R.id.result);
    }


    public void handleClick(View view) {
        resultView.setText("On Click");
        System.out.print("@ On Click!!");
        Button clicked = (Button) view;
        String value = clicked.getText().toString();



        String val1s = val1.getText().toString().trim();

//        System.out.println("#### " + val1s.length());
//        System.out.println(val1.getText().toString().length() != 0);
//        System.out.println(val2.getText().toString().length() != 0);

//        if (val1.getText().toString().length() != 0 && val2.getText().toString().length() != 0) {
            numFirst = new BigDecimal(val1.getText().toString()).setScale(3);
            numSecond = new BigDecimal(val2.getText().toString()).setScale(3);
        if(true) {
            System.out.print("Yesss!")
;            try {
                if (value == "+") {
                    resultVal = String.valueOf(numFirst.add(numSecond));
                } else if (value == "-") {
                    resultVal = String.valueOf(numFirst.subtract(numSecond));
                } else if (value == "*") {
                    resultVal = String.valueOf(numFirst.multiply(numSecond));
                } else if (value == "/") {
                    if (numSecond.equals(new BigDecimal("0"))) {
                        resultView.setText("Cannot divide by zero");
                    } else {
                        resultVal = String.valueOf(numFirst.divide(numSecond));
                    }
                }
                System.out.print("$$$$$ccc v "+ resultVal);
                resultView.setText(resultVal);
            } catch (Exception e) {
                resultView.setText("Invalid expression");
            }
        }
    }
}
