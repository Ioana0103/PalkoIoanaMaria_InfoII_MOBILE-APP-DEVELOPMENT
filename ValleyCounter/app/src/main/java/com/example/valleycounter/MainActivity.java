package com.example.valleycounter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText pathEditText = findViewById(R.id.pathEditText);
        Button calculateButton = findViewById(R.id.calculateButton);
        TextView resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(v -> {
            String path = pathEditText.getText().toString().trim();

            if (path.isEmpty()) {
                resultTextView.setText("Te rog sa introduci un traseu!");
                return;
            }

            int valleyCount = countValleys(path);

            if (valleyCount == -1) {
                resultTextView.setText("Traseul e invalid");
            } else {
                resultTextView.setText("Numarul de vai: " + valleyCount);
            }
        });
    }

    public int countValleys(String path) {
        if (path.charAt(0) == 'D' || path.charAt(path.length() - 1) == 'D') {
            return -1;
        }

        int valleys = -1;
        int level = 0;
        boolean inValley = false;

        for (int i = 0; i < path.length(); i++) {
            char step = path.charAt(i);

            if (step == 'U') {
                level--;
                if (level < 0 && !inValley) {
                    inValley = true;
                }
            } else if (step == 'D') {
                level++;
                if (level == 0 && inValley) {
                    valleys++;
                    inValley = false;
                }
            }
        }

        return valleys;
    }
}
