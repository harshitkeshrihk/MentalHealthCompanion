package com.hk.suisafe;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.hk.suisafe.databinding.ActivityAlarmBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AlarmActivity extends AppCompatActivity {
    private ActivityAlarmBinding binding;
    private Calendar calendar;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAlarmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        createNotificationChannel();

        binding.selectedTimeTv.setText(new SimpleDateFormat("HH:mm", Locale.US).format(new Date()));

//        binding.setAlarmBtn.setEnabled(false);
        binding.cancelAlarmBtn.setEnabled(false);

//        binding.selectTimeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showTimePicker();
//            }
//        });

        binding.setAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker();
                setAlarm();
            }
        });

        binding.cancelAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });
    }

    private void cancelAlarm() {
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        alarmManager.cancel(pendingIntent);
        Toast.makeText(this, "Alarm Cancelled", Toast.LENGTH_SHORT).show();
    }

    private void setAlarm() {
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
        Toast.makeText(this, "Alarm set Successfully", Toast.LENGTH_SHORT).show();
        binding.cancelAlarmBtn.setEnabled(true);
    }

    private void showTimePicker() {
//        picker = new MaterialTimePicker.Builder()
//                .setTimeFormat(TimeFormat.CLOCK_12H)
//                .setHour(12)
//                .setMinute(0)
//                .setTitleText("Select Alarm Time")
//                .build();

//        picker.show(getSupportFragmentManager(), "Alarm app");

//        picker.addOnPositiveButtonClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {

        if(binding.hours.getText().toString().equals("")){
            return;
        }else if(binding.minutes.getText().toString().equals("")){
            return;
        }else{
//            if (Integer.parseInt(binding.hours.getText().toString()) > 12) {
//                binding.selectedTimeTv.setText(String.format("%02d", Integer.parseInt(binding.hours.getText().toString()) - 12) + " : " + String.format("%02d", Integer.parseInt(binding.minutes.getText().toString()) + "PM"));
//            } else {
//                binding.selectedTimeTv.setText(String.format("%02d", Integer.parseInt(binding.hours.getText().toString())) + " : " + String.format("%02d", Integer.parseInt(binding.minutes.getText().toString()) + "AM"));
//            }
            calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(binding.hours.getText().toString()));
            calendar.set(Calendar.MINUTE, Integer.parseInt(binding.minutes.getText().toString()));
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

//            temp = binding.selectedTimeTv.getText().toString();
            binding.setAlarmBtn.setEnabled(true);
        }
//            }
//        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            CharSequence name = "AlarmAppChannel";
            String description = "Channel For Alarm Manager";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("AlarmApp", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}

