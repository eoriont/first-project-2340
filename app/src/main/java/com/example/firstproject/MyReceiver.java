package com.example.firstproject;

import static androidx.core.content.ContextCompat.getSystemService;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class MyReceiver extends BroadcastReceiver {

    public static AtomicInteger notificationId = new AtomicInteger(0);
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        String title = intent.getStringExtra("title");
        String contextText = intent.getStringExtra("context");
        Log.d("INFO", "title:"+title+" contexttext:"+contextText);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "college_scheduler")
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setContentTitle(title)
                .setContentText(contextText)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        int id = notificationId.incrementAndGet();
        notificationManager.notify(id, builder.build());
    }

    @SuppressLint("ScheduleExactAlarm")
    public static void scheduleNotification(Context context, String title, String contextText, Date date) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, MyReceiver.class);

        long millis = date.getTime();
        intent.putExtra("title", title);
        intent.putExtra("context", contextText);
        Log.d("sxtuff", ""+title+contextText);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_MUTABLE);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, millis, pendingIntent);
    }
}
