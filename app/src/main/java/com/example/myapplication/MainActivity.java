package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputText = findViewById(R.id.inputText);
        Button sortButton = findViewById(R.id.sortButton);
        TextView outputText = findViewById(R.id.outputText);

        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputText.getText().toString();
                String sortedString = sortString(input);
                outputText.setText(sortedString);
            }
        });
    }

    private String sortString(String s) {
        StringBuilder litereMici = new StringBuilder();
        StringBuilder litereMari = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                litereMici.append(c);
            } else if (Character.isUpperCase(c)) {
                litereMari.append(c);
            }
        }

        char[] mici = litereMici.toString().toCharArray();
        char[] mari = litereMari.toString().toCharArray();

        Arrays.sort(mici);
        Arrays.sort(mari);

        return new String(mici) + new String(mari);
    }
}
