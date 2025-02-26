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

public class Chapter4Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chapter4, container, false);

        ImageView imageChapter = view.findViewById(R.id.imageChapter);
        TextView textChapter = view.findViewById(R.id.textChapter);

        imageChapter.setImageResource(R.drawable.chapter4);
        textChapter.setText("Capitolul 4: Intoarcerea acasa\n\n"
                + "Cu Piatra Timpului in mana, Eric trebuie sa gaseasca Poarta Dimensionala pentru a se intoarce acasa.\n"
                + "In timp ce alearga spre poarta, Taramul Fermecat incepe sa se destrame, semn ca misiunea lui s-a incheiat.\n"
                + "Ajuns la Poarta, trebuie sa-si ia ramas bun de la Nara si Lir, care i-au fost alaturi in calatoria sa.\n"
                + "Intr-o clipa de lumina puternica, Eric este transportat inapoi in podul casei sale, cu cartea in mana.\n"
                + "Se intreaba daca totul a fost un vis, dar observa ca in buzunarul sau se afla talismanul Narei...\n"
                + "A fost real sau nu?\n\n"
                + "Sfarsit... sau poate nu?");

        return view;
    }
}
