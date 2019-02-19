package tech.bepsychd.assignment3;

import android.content.Intent;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button start;
    private Button stop;
    Intent musicService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AudioManager manager = (AudioManager) getSystemService(AUDIO_SERVICE);
//
        musicService = new Intent(getApplicationContext(), MusicPlayer.class);

        start = (Button)findViewById(R.id.button);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!manager.isMusicActive()) {
                    musicService.putExtra("command", "start");
                    startService(musicService);
                } else {
                    Toast.makeText(MainActivity.this, "Music already playing", Toast.LENGTH_SHORT).show();
                }
            }
        });

        stop = (Button)findViewById(R.id.button2);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(musicService != null) {
                    musicService.putExtra("command", "stop");
                    startService(musicService);
                } else {
//                    Toast.makeText(MainActivity.this, "Music service not yet running", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
