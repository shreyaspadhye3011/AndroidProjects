package tech.kwikly.mobilelab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);

        LinearLayout toyotaView = (LinearLayout)findViewById(R.id.toyota);
        toyotaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Opening Toyota Wiki", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), WebViewClass.class);
                intent.putExtra("URL", "https://en.wikipedia.org/wiki/Toyota");
                startActivity(intent);
            }
        });

        LinearLayout gmView = (LinearLayout)findViewById(R.id.gm);
        gmView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Opening GM Wiki", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), WebViewClass.class);
                intent.putExtra("URL", "https://en.wikipedia.org/wiki/General_Motors");
                startActivity(intent);
            }
        });

        LinearLayout volsView = (LinearLayout)findViewById(R.id.volks);
        volsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Opening Volkswagen Wiki", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), WebViewClass.class);
                intent.putExtra("URL", "https://en.wikipedia.org/wiki/Volkswagen");
                startActivity(intent);
            }
        });

        LinearLayout nisView = (LinearLayout)findViewById(R.id.nissan);
        nisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Opening Nissan Wiki", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), WebViewClass.class);
                intent.putExtra("URL", "https://en.wikipedia.org/wiki/Nissan");
                startActivity(intent);
            }
        });

        LinearLayout hyundai = (LinearLayout)findViewById(R.id.hyundai);
        hyundai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Opening Hyundai Wiki", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), WebViewClass.class);
                intent.putExtra("URL", "https://en.wikipedia.org/wiki/Hyundai_Motor_Company");
                startActivity(intent);
            }
        });

        LinearLayout fordView = (LinearLayout)findViewById(R.id.ford);
        fordView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Opening Ford Wiki", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), WebViewClass.class);
                intent.putExtra("URL", "https://en.wikipedia.org/wiki/Ford_Motor_Company");
                startActivity(intent);
            }
        });

        LinearLayout hondaView = (LinearLayout)findViewById(R.id.honda);
        hondaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Opening Honda Wiki", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), WebViewClass.class);
                intent.putExtra("URL", "https://en.wikipedia.org/wiki/Honda");
                startActivity(intent);
            }
        });
    }
}
