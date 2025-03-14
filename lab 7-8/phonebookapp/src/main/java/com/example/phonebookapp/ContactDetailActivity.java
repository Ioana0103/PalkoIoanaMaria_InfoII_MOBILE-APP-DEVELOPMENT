package com.example.phonebookapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ContactDetailActivity extends AppCompatActivity {
    private TextView name, phone, address, email, linkedin;
    private Button callButton, emailButton, editButton;
    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        name = findViewById(R.id.contactDetailName);
        phone = findViewById(R.id.contactDetailPhone);
        address = findViewById(R.id.contactDetailAddress);
        email = findViewById(R.id.contactDetailEmail);
        linkedin = findViewById(R.id.contactDetailLinkedin);
        callButton = findViewById(R.id.callButton);
        emailButton = findViewById(R.id.emailButton);
        editButton = findViewById(R.id.editButton);

        if (getIntent().hasExtra("contact")) {
            contact = (Contact) getIntent().getSerializableExtra("contact");

            if (contact != null) {
                name.setText(contact.getName() + " " + contact.getSurname());
                phone.setText(contact.getPhone());
                address.setText(contact.getAddress());
                email.setText(contact.getEmail());
                linkedin.setText(contact.getLinkedin());
            }
        }

        callButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + contact.getPhone()));
            startActivity(intent);
        });

        emailButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + contact.getEmail()));
            startActivity(intent);
        });

        editButton.setOnClickListener(v -> {
            Intent intent = new Intent(ContactDetailActivity.this, AddEditContactActivity.class);
            intent.putExtra("contact", contact);
            startActivity(intent);
        });
    }
}
