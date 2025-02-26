package com.example.simplecalc;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class InputFragment extends Fragment {
    private EditText etNumber1, etNumber2;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    private OnCalculationListener calculationListener;

    public interface OnCalculationListener {
        void onCalculate(String result);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnCalculationListener) {
            calculationListener = (OnCalculationListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnCalculationListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);

        etNumber1 = view.findViewById(R.id.etNumber1);
        etNumber2 = view.findViewById(R.id.etNumber2);
        btnAdd = view.findViewById(R.id.btnAdd);
        btnSubtract = view.findViewById(R.id.btnSubtract);
        btnMultiply = view.findViewById(R.id.btnMultiply);
        btnDivide = view.findViewById(R.id.btnDivide);

        View.OnClickListener listener = v -> {
            String num1Str = etNumber1.getText().toString();
            String num2Str = etNumber2.getText().toString();

            if (num1Str.isEmpty() || num2Str.isEmpty()) return;

            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double result = 0;

            if (v == btnAdd) {
                result = num1 + num2;
            } else if (v == btnSubtract) {
                result = num1 - num2;
            } else if (v == btnMultiply) {
                result = num1 * num2;
            } else if (v == btnDivide) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    calculationListener.onCalculate("Cannot divide by zero");
                    return;
                }
            }

            calculationListener.onCalculate(String.valueOf(result));
        };

        btnAdd.setOnClickListener(listener);
        btnSubtract.setOnClickListener(listener);
        btnMultiply.setOnClickListener(listener);
        btnDivide.setOnClickListener(listener);

        return view;
    }
}
