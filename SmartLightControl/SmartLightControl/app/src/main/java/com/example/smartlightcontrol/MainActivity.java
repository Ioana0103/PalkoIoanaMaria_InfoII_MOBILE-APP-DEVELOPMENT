package com.example.smartlightcontrol;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;
    private Button btnToggleLight, btnAutoMode, btnCustomMode;
    private boolean isLightOn = false;
    private boolean isAutoMode = false;
    private SharedPreferences preferences;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        btnToggleLight = findViewById(R.id.btn_toggle_light);
        btnAutoMode = findViewById(R.id.btn_auto_mode);
        btnCustomMode = findViewById(R.id.btn_custom_mode);

        preferences = getSharedPreferences("SmartLightPrefs", MODE_PRIVATE);
        isLightOn = preferences.getBoolean("light_state", false);
        isAutoMode = preferences.getBoolean("auto_mode", false);

        btnAutoMode.setText(isAutoMode ? "Disable Auto Mode" : "Enable Auto Mode");

        updateLightUI();
        checkNotificationPermission();

        btnToggleLight.setOnClickListener(v -> toggleLight());
        btnAutoMode.setOnClickListener(v -> enableAutoMode());
        btnCustomMode.setOnClickListener(v -> changeLightColor());

        if (isAutoMode) {
            startAutoMode();
        }
    }

    private void toggleLight() {
        isLightOn = !isLightOn;
        updateLightUI();
        preferences.edit().putBoolean("light_state", isLightOn).apply();
    }

    private void enableAutoMode() {
        isAutoMode = !isAutoMode;
        preferences.edit().putBoolean("auto_mode", isAutoMode).apply();

        if (isAutoMode) {
            btnAutoMode.setText("Disable Auto Mode");
            startAutoMode();
        } else {
            btnAutoMode.setText("Enable Auto Mode");
            handler.removeCallbacksAndMessages(null);
        }
    }

    private void changeLightColor() {
        int[] colorValues = {Color.WHITE, Color.BLUE, Color.RED, Color.GREEN, };
        int currentIndex = preferences.getInt("color_index", 0);
        int nextIndex = (currentIndex + 1) % colorValues.length;

        layout.setBackgroundColor(colorValues[nextIndex]);
        preferences.edit().putInt("color_index", nextIndex).apply();
    }

    private void startAutoMode() {
        handler.postDelayed(() -> {
            int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            Log.d("AutoMode","Lumina alba activata"+hour);

            if (hour >= 7 && hour < 18) {
                layout.setBackgroundColor(Color.WHITE);
            } else if (hour >= 18 && hour < 22) {
                layout.setBackgroundColor(Color.parseColor("#FFA500")); // Portocaliu

            } else {
                layout.setBackgroundColor(Color.DKGRAY);
                sendNotification("Noapte buna!", "Lumina s-a stins automat.");
            }

            if (hour >= 7 && hour < 12 && isLightOn) {
                sendNotification("Buna dimineata!", "Ai nevoie de mai multa lumina?");
            }

            if (isAutoMode) {
                startAutoMode();
            }
        }, 6000);
    }

    private void updateLightUI() {
        if (isLightOn) {
            layout.setBackgroundColor(Color.YELLOW);
        } else {
            layout.setBackgroundColor(Color.DKGRAY);
        }
    }

    private void sendNotification(String title, String message) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("light_channel", "Light Notifications", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "light_channel")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true);

        notificationManager.notify(1, builder.build());
    }

    private void checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 1);
            }
        }
    }
}
