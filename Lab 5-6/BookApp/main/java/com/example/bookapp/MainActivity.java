package com.example.bookapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements MenuFragment.OnChapterSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer1, new IntroFragment())
                    .replace(R.id.fragmentContainer2, new MenuFragment())
                    .commit();
        }
    }

    @Override
    public void onChapterSelected(Fragment chapterFragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer1, chapterFragment)
                .addToBackStack(null)
                .commit();
    }
}
