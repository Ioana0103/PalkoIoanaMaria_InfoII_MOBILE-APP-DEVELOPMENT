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

public class Chapter2Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chapter2, container, false);

        ImageView imageChapter = view.findViewById(R.id.imageChapter);
        TextView textChapter = view.findViewById(R.id.textChapter);

        imageChapter.setImageResource(R.drawable.chapter2);
        textChapter.setText("Capitolul 2: Desertul Furtunilor\n\n"
                + "Dupa ce paraseste padurea, Eric ajunge intr-un desert imens unde nisipul pare sa se miste ca si cum ar avea viata.\n"
                + "O furtuna de nisip magica il impiedica sa mearga mai departe.\n"
                + "Intalneste o fata misterioasa pe nume Nara, care ii ofera un talisman protejat de o vraja.\n"
                + "Impreuna descopera ca un sarpe urias de aur pazeste o comoara ascunsa sub dune.\n"
                + "Eric trebuie sa aleaga sa lupte cu sarpele sau sa incerce sa-l pacaleasca.\n"
                + "In cele din urma, reuseste sa obtina un fragment al Pietrei Timpului si isi continua calatoria.");

        return view;
    }
}
