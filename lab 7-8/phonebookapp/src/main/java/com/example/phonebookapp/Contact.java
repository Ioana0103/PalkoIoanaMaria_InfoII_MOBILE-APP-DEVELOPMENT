package com.example.phonebookapp;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String surname;
    private String phone;
    private String address;
    private String email;
    private String linkedin;

    public Contact(String name, String surname, String phone, String address, String email, String linkedin) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.linkedin = linkedin;
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getEmail() { return email; }
    public String getLinkedin() { return linkedin; }
}
