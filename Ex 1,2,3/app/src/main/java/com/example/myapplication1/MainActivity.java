package com.example.myapplication1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sortare litere
        EditText inputText = findViewById(R.id.inputText);
        Button sortButton = findViewById(R.id.sortButton);
        TextView outputText = findViewById(R.id.outputText);

        sortButton.setOnClickListener(v -> {
            String input = inputText.getText().toString();
            String sortedString = sortString(input);
            outputText.setText(sortedString);
        });

        //Friendly numbers
        EditText num1EditText = findViewById(R.id.num1EditText);
        EditText num2EditText = findViewById(R.id.num2EditText);
        Button checkButton = findViewById(R.id.checkButton);
        TextView friendlyResultTextView = findViewById(R.id.friendlyResultTextView);

        checkButton.setOnClickListener(v -> {
            String num1Text = num1EditText.getText().toString();
            String num2Text = num2EditText.getText().toString();

            if (num1Text.isEmpty() || num2Text.isEmpty()) {
                Toast.makeText(MainActivity.this, "Te rog introdu ambele numere", Toast.LENGTH_SHORT).show();
                return;
            }

            int num1 = Integer.parseInt(num1Text);
            int num2 = Integer.parseInt(num2Text);

            boolean areFriendly = areFriendlyNumbers(num1, num2);
            friendlyResultTextView.setText("Numerele " + num1 + " si " + num2 + " sunt prietenoase? " + areFriendly);
        });

        //Hexa -> decimal
        EditText hexEditText = findViewById(R.id.hexEditText);
        Button convertButton = findViewById(R.id.convertButton);
        TextView hexResultTextView = findViewById(R.id.hexResultTextView);

        convertButton.setOnClickListener(v -> {
            String hexString = hexEditText.getText().toString().trim();

            if (hexString.isEmpty()) {
                Toast.makeText(MainActivity.this, "Te rog introdu un numar hexazecimal", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int decimal = hexToDecimal(hexString);
                hexResultTextView.setText("Hexadecimalul " + hexString + " este " + decimal + " în zecimal.");
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Numar hexadecimal invalid", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //sortarea literelor
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

    //verificare friendly numbers
    public static boolean areFriendlyNumbers(int num1, int num2) {
        return sumOfDivisors(num1) == num2 && sumOfDivisors(num2) == num1;
    }

    public static int sumOfDivisors(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    //conversie Hexadecimal -> Decimal
    public static int hexToDecimal(String hex) {
        return Integer.parseInt(hex, 16);
    }
}
