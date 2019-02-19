package tech.bepsychd.assignment3;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

public class MusicPlayer extends Service {
    private static MediaPlayer player;
    private Notification notification;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        super.onCreate();

        String ID = "scu.shreyas.assignment3";
        String channelName = "Background Music";
        NotificationChannel notifyChannel = new NotificationChannel(ID, channelName, NotificationManager.IMPORTANCE_NONE);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.createNotificationChannel(notifyChannel);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, ID);
        notification = notificationBuilder.setOngoing(true)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Music running in background")
                .setCategory(Notification.CATEGORY_SERVICE)
                .build();

        if (player == null || true) {
            player = MediaPlayer.create(this, R.raw.loyal);
        }

    }

    public int onStartCommand(Intent intent, int flags, int startId) {

        System.out.println(intent.getExtras().getString("command"));
        if(intent.getExtras().getString("command").matches("start")) {

            System.out.println("$$ START ME!!");

            player.setLooping(true);
            player.start();

            startForeground(1, notification);

        }else if(intent.getExtras().getString("command").matches("stop")) {
            System.out.println("$$ STOP ME!!");
//            player.pause();
            player.stop();
            player.reset();
            player.release();
            stopForeground(true);
            stopSelf();
        }
        return START_STICKY;
    }


    public void onPause() {

    }
    @Override
    public void onDestroy() {
    }

    @Override
    public void onLowMemory() {
    }
}
