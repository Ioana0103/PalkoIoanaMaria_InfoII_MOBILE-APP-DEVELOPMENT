package com.example.counterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int clickCount = 0;
    private TextView textViewCounter;
    private TextView textViewMessage; // Noua etichetă pentru afișarea mesajului

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCounter = findViewById(R.id.textViewCounter);
        textViewMessage = findViewById(R.id.textViewMessage); // Inițializare TextView
        Button buttonToast = findViewById(R.id.buttonToast);
        Button buttonCounter = findViewById(R.id.buttonCounter);

        // Butonul de Toast - în loc să afișeze un Toast, va schimba textul în eticheta de jos
        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewMessage.setText("Hello from Counter App!");
            }
        });

        // Buton pentru incrementarea contorului
        buttonCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;
                textViewCounter.setText("Clicks: " + clickCount);
            }
        });
    }
}
