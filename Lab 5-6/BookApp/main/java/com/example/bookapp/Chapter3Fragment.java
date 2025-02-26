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

public class Chapter3Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chapter3, container, false);

        ImageView imageChapter = view.findViewById(R.id.imageChapter);
        TextView textChapter = view.findViewById(R.id.textChapter);

        imageChapter.setImageResource(R.drawable.chapter3);
        textChapter.setText("Capitolul 3: Castelul Umbrelor\n\n"
                + "Eric ajunge in fata unui castel sumbru invaluit in ceata.\n"
                + "Portile castelului sunt pazite de garzile invizibile, dar Eric foloseste talismanul oferit de Nara pentru a trece de ele.\n"
                + "In interior, il intalneste pe Stapanul Umbrelor, un vrajitor care controleaza acest taram.\n"
                + "Vrajitorul ii spune ca nu poate lua Piatra Timpului decat daca rezolva o enigma straveche.\n"
                + "Dupa o lupta de inteligenta cu vrajitorul, Eric reuseste sa completeze Piatra Timpului si descopera adevaratul secret al castelului.");

        return view;
    }
}
