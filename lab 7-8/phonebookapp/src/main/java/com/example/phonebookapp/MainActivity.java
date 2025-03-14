package com.example.phonebookapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ContactAdapter adapter;
    private ArrayList<Contact> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        contactList = new ArrayList<>();
        contactList.add(new Contact("John", "Doe", "123456789", "New York", "john@example.com", "linkedin.com/johndoe"));
        contactList.add(new Contact("Jane", "Smith", "987654321", "Los Angeles", "jane@example.com", "linkedin.com/janesmith"));

        adapter = new ContactAdapter(contactList, this);
        recyclerView.setAdapter(adapter);
    }
}
