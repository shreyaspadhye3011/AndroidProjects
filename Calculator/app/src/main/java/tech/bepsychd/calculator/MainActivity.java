package tech.bepsychd.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String s1 = "564";
        String s2 = "53";
        BigDecimal dividend = new BigDecimal(s1);
        BigDecimal divisor = new BigDecimal(s2);
        try {
            BigDecimal res = dividend.divide(divisor);
        } catch (Exception e) {
            e.printStackTrace();
            //git git
            BigInteger intDividend = new BigInteger(s1);
            BigInteger intDivisor = new BigInteger(s2);
//            BigInteger quotient = intDividend.divide(intDivisor);
            BigInteger remainder = intDividend.mod(intDivisor);
            //get 10 decimal precision via while loop on remainder / quotient. Add to quotient and display
        }

        System.out.println("#### New ");
    }
}
