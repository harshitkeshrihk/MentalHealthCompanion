package com.hk.suisafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.hk.suisafe.databinding.ActivityFirstBinding;

public class FirstActivity extends AppCompatActivity {
    private ActivityFirstBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirstBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toast.makeText(this,"Click on add button to set alarm!!",Toast.LENGTH_SHORT).show();

        binding.addFab.setOnClickListener(view -> {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        });
    }
}