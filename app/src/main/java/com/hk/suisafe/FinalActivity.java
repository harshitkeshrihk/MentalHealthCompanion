package com.hk.suisafe;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.widget.Toast;

import com.hk.suisafe.databinding.ActivityFinalBinding;

import java.util.Calendar;

public class FinalActivity extends AppCompatActivity {
    private ActivityFinalBinding binding;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFinalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mediaPlayer = new MediaPlayer();
        binding.backBtn.setOnClickListener(view -> {
            mediaPlayer.stop();
            mediaPlayer = null;
            startActivity(new Intent(this, MainActivity.class));
        });
        binding.snoozeTv.setOnClickListener(view -> {
            Toast.makeText(this, "Alarm snoozed for 5 minutes", Toast.LENGTH_SHORT).show();
            snoozeAlarm();
        });
        binding.stopTv.setOnClickListener(view -> {
            mediaPlayer.stop();
            mediaPlayer = null;
            Toast.makeText(this, "Alarm Stopped", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
        });
    }

    private void snoozeAlarm() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,
                Calendar.getInstance().getTimeInMillis() + 5 * 60000,
                pendingIntent);
        finish();
    }
}