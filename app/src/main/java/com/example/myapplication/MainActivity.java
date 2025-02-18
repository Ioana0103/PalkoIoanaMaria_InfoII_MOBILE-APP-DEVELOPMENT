package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
        String litereMici = "";
        String litereMari = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                litereMici += c;
            } else if (Character.isUpperCase(c)) {
                litereMari += c;
            }
        }

        litereMici = sortStringWithoutBuilder(litereMici);
        litereMari = sortStringWithoutBuilder(litereMari);

        return litereMici + litereMari;
    }

    private String sortStringWithoutBuilder(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] > chars[j]) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        return new String(chars);
    }
}
