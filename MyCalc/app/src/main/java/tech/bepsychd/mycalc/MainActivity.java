package tech.bepsychd.mycalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    private String resultVal;
    private BigDecimal numFirst;
    private BigDecimal numSecond;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultView = (TextView) findViewById(R.id.result);

        try {
            final EditText val1 = (EditText) findViewById(R.id.input1);
            final EditText val2 = (EditText) findViewById(R.id.input2);

            Button addBtn = (Button) findViewById(R.id.addbtn);
            addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (val1.getText().toString().length() != 0 && val2.getText().toString().length() != 0) {
                        numFirst = new BigDecimal(val1.getText().toString());
                        numSecond = new BigDecimal(val2.getText().toString());
                        resultVal = String.valueOf(numFirst.add(numSecond));
                        resultView.setText(resultVal);
                    } else {
                        resultView.setText("Please input both numbers");
                    }
                }
            });

            Button subBtn = (Button) findViewById(R.id.subbtn);
            subBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (val1.getText().toString().length() != 0 && val2.getText().toString().length() != 0) {
                        numFirst = new BigDecimal(val1.getText().toString());
                        numSecond = new BigDecimal(val2.getText().toString());
                        resultVal = String.valueOf(numFirst.subtract(numSecond));
                        resultView.setText(resultVal);
                    } else {
                        resultView.setText("Please input both numbers");
                    }
                }
            });

            Button mulBtn = (Button) findViewById(R.id.mulbtn);
            mulBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (val1.getText().toString().length() != 0 && val2.getText().toString().length() != 0) {
                        numFirst = new BigDecimal(val1.getText().toString()).setScale(1);
                        numSecond = new BigDecimal(val2.getText().toString()).setScale(1);
                        resultVal = String.valueOf(numFirst.multiply(numSecond));
                        resultView.setText(resultVal);
                    } else {
                        resultView.setText("Please input both numbers");
                    }
                }
            });

            Button divideBtn = (Button) findViewById(R.id.dividebtn);
            divideBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (val1.getText().toString().length() != 0 && val2.getText().toString().length() != 0) {
                        numFirst = new BigDecimal(val1.getText().toString()).setScale(3);
                        numSecond = new BigDecimal(val2.getText().toString()).setScale(3);
                        try {
                            if (String.valueOf(numSecond) != "0.000") {
                                resultVal = String.valueOf(numFirst.divide(numSecond));
                                resultView.setText(resultVal);
                            } else {
                                resultView.setText("Cannot divide by zero");
                            }
                        } catch (ArithmeticException e) {
                            resultVal = String.valueOf(numFirst.divide(numSecond, 3));
                            resultView.setText(resultVal);
//                            resultView.setText("Cannot divide by zero");
                        }
                    } else {
                        resultView.setText("Please input both numbers");
                    }
                }
            });
        } catch (Exception e) {
            resultView.setText("Oops! Something went wrong. Please try again.");
        }
    }
}
