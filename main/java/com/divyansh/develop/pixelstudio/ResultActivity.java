package com.divyansh.develop.pixelstudio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.divyansh.develop.pixelstudio.databinding.ActivityResultBinding;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class ResultActivity extends AppCompatActivity {

    ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AdRequest adRequest = new AdRequest.Builder().build();
        binding.adView.loadAd(adRequest);

        binding.adView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();
                // logics
                Toast.makeText(ResultActivity.this, "Ads by google (Google Admob)", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                binding.adView.loadAd(adRequest);
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                // logics
                Toast.makeText(ResultActivity.this,"Ad closed by Google.(Google Admob)",Toast.LENGTH_SHORT).show();
            }
        });

        binding.resultimg.setImageURI(getIntent().getData());
        Toast.makeText(ResultActivity.this, "Your Image has been saved", Toast.LENGTH_LONG).show();

        binding.homeimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        binding.backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        binding.facebookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.facebook.com"));
                if (intent.resolveActivity(getPackageManager()) !=null)
                startActivity(intent);
            }
        });

        binding.instagrambtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.instagram.com"));
                if (intent.resolveActivity(getPackageManager()) !=null)
                startActivity(intent);
            }
        });

        binding.twitterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://twitter.com"));
                if (intent.resolveActivity(getPackageManager()) !=null)
                startActivity(intent);
            }
        });

    }
}