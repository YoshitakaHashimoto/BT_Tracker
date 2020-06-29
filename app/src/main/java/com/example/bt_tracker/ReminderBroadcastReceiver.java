package com.example.bt_tracker;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.util.Log;

public class ReminderBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String TAG ="onReceive";
        Intent notificationIntent = new Intent(context,LogActivity.class);
        //create an PendingIntent with the newly created Intent
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,notificationIntent, 0);

        Log.d(TAG, "start building notification");
        NotificationCompat.Builder builder= new
    NotificationCompat.Builder(context,"BT_Tracker_Channel")
                  .setSmallIcon(R.mipmap.ic_launcher_round)
                  .setContentTitle("Notification from BT Tracker")
                  .setContentText("Please log your body temperature now")
                  .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                Log.d(TAG,"finish building notification");
                  builder.setContentIntent(contentIntent);
               NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
               Log.d(TAG,"start firing notification");
               notificationManager.notify(200, builder.build());
               Log.d(TAG,"notification fired");
    }

    }

