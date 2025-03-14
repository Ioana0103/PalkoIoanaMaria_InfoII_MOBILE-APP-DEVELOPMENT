package com.example.phonebookapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddEditContactActivity extends AppCompatActivity {
    private EditText nameInput, surnameInput, phoneInput, addressInput, emailInput, linkedinInput;
    private Button saveButton;
    private Contact contact;
    private boolean isEditing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_contact);

        nameInput = findViewById(R.id.nameInput);
        surnameInput = findViewById(R.id.surnameInput);
        phoneInput = findViewById(R.id.phoneInput);
        addressInput = findViewById(R.id.addressInput);
        emailInput = findViewById(R.id.emailInput);
        linkedinInput = findViewById(R.id.linkedinInput);
        saveButton = findViewById(R.id.saveButton);

        if (getIntent().hasExtra("contact")) {
            contact = (Contact) getIntent().getSerializableExtra("contact");
            isEditing = true;
            nameInput.setText(contact.getName());
            surnameInput.setText(contact.getSurname());
            phoneInput.setText(contact.getPhone());
            addressInput.setText(contact.getAddress());
            emailInput.setText(contact.getEmail());
            linkedinInput.setText(contact.getLinkedin());
        }

        saveButton.setOnClickListener(v -> saveContact());
    }

    private void saveContact() {
        String name = nameInput.getText().toString();
        String surname = surnameInput.getText().toString();
        String phone = phoneInput.getText().toString();
        String address = addressInput.getText().toString();
        String email = emailInput.getText().toString();
        String linkedin = linkedinInput.getText().toString();

        Contact newContact = new Contact(name, surname, phone, address, email, linkedin);
        Intent intent = new Intent();
        intent.putExtra("new_contact", newContact);
        setResult(RESULT_OK, intent);
        finish();
    }
}
