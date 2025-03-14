package com.example.intentsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnExplicit = findViewById(R.id.btnExplicit);
        Button btnBrowser = findViewById(R.id.btnBrowser);
        Button btnCall = findViewById(R.id.btnCall);

        // Intent Explicit - Navigare către SecondActivity
        btnExplicit.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

        // Intent Implicit - Deschidere browser
        btnBrowser.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            startActivity(intent);
        });

        // Intent Implicit - Deschidere aplicația de apelare
        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789"));
            startActivity(intent);
        });
    }
}
