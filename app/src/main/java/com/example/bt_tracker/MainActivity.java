package com.example.bt_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.security.cert.Extension;
import java.time.ZoneOffset;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();

        TextView mainButton1 = findViewById(R.id.MainButton1);
        // Add "an ear" to MainButton1
        mainButton1.setOnClickListener(this);

        TextView mainButton2 = findViewById(R.id.MainButton2);
        // Add "an ear" to mainButton2
        mainButton2.setOnClickListener(this);

        TextView mainButton3 = findViewById(R.id.MainButton3);
        // Add "an ear" to mainButton3
        mainButton3.setOnClickListener(this);

        TextView mainButton4 = findViewById(R.id.MainButton4);
        // Add "an ear" to mainButton4
        mainButton4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.MainButton1:
                // IF MainButton1 is clicked, do something
                Intent toLog = new Intent(this, LogActivity.class);
                startActivity(toLog);
                break;
            case R.id.MainButton2:
                // IF MainButton2 is clicked, do something
                Intent toNormal = new Intent(this, NormalActivity.class);
                startActivity(toNormal);
                break;
            case R.id.MainButton3:
                // IF MainButton3 is clicked, do something
                Intent toMechanism = new Intent(this, MechanismActivity.class);
                startActivity(toMechanism);
                break;
            case R.id.MainButton4:
                // IF MainButton4 is Clicked, do something
                Intent toLink1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.healthline.com/health/how-to-break-a-fever"));
                // Verify that the intent open toLink1 will resolve properly
                if (toLink1.resolveActivity(getPackageManager()) != null) {
                    startActivity(toLink1);
                }
            case R.id.SetReminder:
                // When user clicks "SET REMINDER" button, a toast message will pop up to let user know that are reminder is set
                Toast.makeText(this, "Reminder set!", Toast.LENGTH_SHORT).show();
                // Create an intent object to start the ReminderBroadcastReceiver Class
                Intent intent = new Intent(this, ReminderBroadcastReceiver.class);
                // Create a pending intent so that the intent object above will only fire when alarm triggers
                PendingIntent pd = PendingIntent.getBroadcast(this,0,intent, 0);
                // create an AlarmManager
                AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
                // Repeating interval for the alarmManager is set to 6 second for demonstration purpose
                // In real world application, users may want to get daily reminder
                // In that case, set the interval to 1000 * 60 * 60 * 24
                long interval = 1000*6;
                // set up a repeating alarm so that the notification reminder gets fired at the set interval
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                        System.currentTimeMillis(), interval,pd);

                break;
        }
    }



    private void createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
            String channelID = "BT_Tracker_Channel";
            String channelName = "BTTrackerReminderChannel";
            String channelDescription = "Channel for BT Tracker reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelID,channelName, importance);
            channel.setDescription(channelDescription);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}


