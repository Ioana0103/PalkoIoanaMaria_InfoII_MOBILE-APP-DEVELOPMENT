package com.example.bookapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Chapter1Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chapter1, container, false);

        ImageView imageChapter = view.findViewById(R.id.imageChapter);
        TextView textChapter = view.findViewById(R.id.textChapter);

        imageChapter.setImageResource(R.drawable.chapter1);
        textChapter.setText("Capitolul 1: Padurea Vorbitoare\n\n"
                + "Eric se trezeste intr-o padure misterioasa, unde copacii soptesc si rad.\n"
                + "Intalneste un spiridus jucaus pe nume Lir, care ii explica ca se afla in Taramul Fermecat.\n"
                + "Spiridusul ii spune ca pentru a se intoarce acasa, trebuie sa gaseasca Piatra Timpului, ascunsa in Castelul Umbrelor.\n"
                + "Pentru a ajunge acolo, trebuie sa traverseze patru locuri magice.\n"
                + "Eric accepta provocarea si pleaca mai departe, dar inainte de a parasi padurea, copacii il avertizeaza despre un pericol iminent...");

        return view;
    }
}
