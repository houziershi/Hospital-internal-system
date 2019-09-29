package com.baoan.hospital.system.UI.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.baoan.hospital.system.R;
import com.baoan.hospital.system.UI.data.XH;

import java.util.List;

/**
 * Discription:
 * Created by guokun on 2019/9/29.
 */
public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private List<XH> mContacts;

    // Pass in the contact array into the constructor
    public ContactsAdapter(List<XH> contacts) {
        mContacts = contacts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_contact, parent, false);

        // Return a new holder instance
        return new ViewHolder(context, contactView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        XH contact = mContacts.get(position);

        // Set item views based on your views and data model
        viewHolder.tvName.setText(contact.getTitle());
        viewHolder.tvHometown.setText(contact.getDescription());
    }

    @Override
    public int getItemCount() {
        return mContacts != null ? mContacts.size() : 0;
    }

    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvName;
        public TextView tvHometown;
        private Context context;

        public ViewHolder(Context context, View itemView) {
            super(itemView);
            this.tvName = (TextView) itemView.findViewById(R.id.contact_name);
            this.tvHometown = (TextView) itemView.findViewById(R.id.message_button);
            // Store the context
            this.context = context;
            // Attach a click listener to the entire row view
            itemView.setOnClickListener(this);
        }

        // Handles the row being being clicked
        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                // We can access the data within the views
                Toast.makeText(context, tvName.getText(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
