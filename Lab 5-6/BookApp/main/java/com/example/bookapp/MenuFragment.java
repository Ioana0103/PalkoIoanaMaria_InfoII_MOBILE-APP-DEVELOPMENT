package com.example.bookapp;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragment extends Fragment {
    private OnChapterSelectedListener listener;

    public interface OnChapterSelectedListener {
        void onChapterSelected(Fragment chapterFragment);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnChapterSelectedListener) {
            listener = (OnChapterSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnChapterSelectedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        Button btnChapter1 = view.findViewById(R.id.btnChapter1);
        Button btnChapter2 = view.findViewById(R.id.btnChapter2);
        Button btnChapter3 = view.findViewById(R.id.btnChapter3);
        Button btnChapter4 = view.findViewById(R.id.btnChapter4);

        btnChapter1.setOnClickListener(v -> listener.onChapterSelected(new Chapter1Fragment()));
        btnChapter2.setOnClickListener(v -> listener.onChapterSelected(new Chapter2Fragment()));
        btnChapter3.setOnClickListener(v -> listener.onChapterSelected(new Chapter3Fragment()));
        btnChapter4.setOnClickListener(v -> listener.onChapterSelected(new Chapter4Fragment()));

        return view;
    }
}
