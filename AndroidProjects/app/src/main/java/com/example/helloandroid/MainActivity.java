package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
        stateChangedTo("created");
    }

    @Override
    protected void onPause(){
        super.onPause();
        setContentView(R.layout.activity_main);
        createNotificationChannel();
        stateChangedTo("paused");
    }



    private static final String CHANNEL_ID = "MY_CHANNEL";

    private void stateChangedTo(String state) {
        String currentTimeString = getCurrentTimeString();

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.presence_busy)
                .setContentTitle(state)
                .setContentText(currentTimeString)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify((int) System.currentTimeMillis(), mBuilder.build());
        Log.d(getString(R.string.app_name), state + " at " + currentTimeString);
    }

    private String getCurrentTimeString() {
        return new java.text.SimpleDateFormat("HH:mm:ss.SSS").format(new java.util.Date());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.app_name);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription("Just for debugging");

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}
