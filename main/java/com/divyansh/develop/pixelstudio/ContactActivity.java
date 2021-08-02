package com.divyansh.develop.pixelstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.divyansh.develop.pixelstudio.databinding.ActivityContactBinding;

public class ContactActivity extends AppCompatActivity {

    ActivityContactBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}
