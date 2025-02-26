package com.example.simplecalc;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements InputFragment.OnCalculationListener {
    private ResultFragment resultFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultFragment = new ResultFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragmentContainer1, new InputFragment());
        fragmentTransaction.replace(R.id.fragmentContainer2, resultFragment);

        fragmentTransaction.commit();
    }

    @Override
    public void onCalculate(String result) {
        resultFragment.updateResult(result);
    }
}
