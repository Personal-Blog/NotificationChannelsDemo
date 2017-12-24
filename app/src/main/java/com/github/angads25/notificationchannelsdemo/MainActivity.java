package com.github.angads25.notificationchannelsdemo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    private AppCompatButton channel1;
    private AppCompatButton channel2;
    private AppCompatButton channel3;
    private AppCompatButton channel4;

    private AppCompatButton settings;
    private RadioGroup settingsGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        channel1 = findViewById(R.id.channel_1);
        channel2 = findViewById(R.id.channel_2);
        channel3 = findViewById(R.id.channel_3);
        channel4 = findViewById(R.id.channel_4);
        settings = findViewById(R.id.channel_settings);

        channel1.setOnClickListener(this);
        channel2.setOnClickListener(this);
        channel3.setOnClickListener(this);
        channel4.setOnClickListener(this);
        settings.setOnClickListener(this);

        settingsGroup = findViewById(R.id.channel_settings_group);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.channel_1: {
                NotificationChannel channel_1 = new NotificationChannel("sports","Sports", NotificationManager.IMPORTANCE_DEFAULT);
                channel_1.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                channel_1.setShowBadge(true);
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.createNotificationChannel(channel_1);
                Notification.Builder builder1 = new Notification.Builder(getApplicationContext(), "sports")
                        .setContentTitle("Sports")
                        .setContentText("India V/s New Zealand match postponed due to rain")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setChannelId("sports")
                        .setAutoCancel(true);
                manager.notify(1001, builder1.build());
                break;
            }
            case R.id.channel_2: {
                NotificationChannel channel_2 = new NotificationChannel("entertainment","Entertainment", NotificationManager.IMPORTANCE_DEFAULT);
                channel_2.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                channel_2.setShowBadge(true);
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.createNotificationChannel(channel_2);
                Notification.Builder builder2 = new Notification.Builder(getApplicationContext(), "entertainment")
                        .setContentTitle("Entertainment")
                        .setContentText("Highlights on Star Wars - Zombie Apocalypse")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setChannelId("entertainment")
                        .setAutoCancel(true);
                manager.notify(1002, builder2.build());
                break;
            }
            case R.id.channel_3: {
                NotificationChannel channel_3 = new NotificationChannel("technology","Technology", NotificationManager.IMPORTANCE_DEFAULT);
                channel_3.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                channel_3.setShowBadge(true);
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.createNotificationChannel(channel_3);
                Notification.Builder builder3 = new Notification.Builder(getApplicationContext(), "technology")
                        .setContentTitle("Technology")
                        .setContentText("Drones will be used to pick garbage from streets now")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setChannelId("technology")
                        .setAutoCancel(true);
                manager.notify(1003, builder3.build());
                break;
            }
            case R.id.channel_4: {
                NotificationChannel channel_4 = new NotificationChannel("fashion","Fashion", NotificationManager.IMPORTANCE_DEFAULT);
                channel_4.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                channel_4.setShowBadge(true);
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.createNotificationChannel(channel_4);
                Notification.Builder builder4 = new Notification.Builder(getApplicationContext(), "fashion")
                        .setContentTitle("Fashion")
                        .setContentText("Click here to see what's trending this week")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setChannelId("fashion")
                        .setAutoCancel(true);
                manager.notify(1004, builder4.build());
                break;
            }
            case R.id.channel_settings: {
                Intent i = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
                i.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
                int id = settingsGroup.getCheckedRadioButtonId();
                switch (id) {
                    default:
                    case R.id.channel1: {
                        i.putExtra(Settings.EXTRA_CHANNEL_ID, "sports");
                        break;
                    }
                    case R.id.channel2: {
                        i.putExtra(Settings.EXTRA_CHANNEL_ID, "entertainment");
                        break;
                    }
                    case R.id.channel3: {
                        i.putExtra(Settings.EXTRA_CHANNEL_ID, "technology");
                        break;
                    }
                    case R.id.channel4: {
                        i.putExtra(Settings.EXTRA_CHANNEL_ID, "fashion");
                        break;
                    }
                }
                startActivity(i);
                break;
            }
        }
    }
}
