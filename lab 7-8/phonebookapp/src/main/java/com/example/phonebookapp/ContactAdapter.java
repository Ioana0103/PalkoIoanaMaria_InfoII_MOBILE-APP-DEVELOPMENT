package com.example.phonebookapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private ArrayList<Contact> contactList;
    private Context context;

    public ContactAdapter(ArrayList<Contact> contactList, Context context) {
        this.contactList = contactList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.name.setText(contact.getName() + " " + contact.getSurname());
        holder.phone.setText(contact.getPhone());
       // holder.image.setImageResource(contact.getImageResource());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ContactDetailActivity.class);
            intent.putExtra("contact", contact);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, phone;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.contactName);
            phone = itemView.findViewById(R.id.contactPhone);
            image = itemView.findViewById(R.id.contactImage);
        }
    }
}
