package com.example.devworkshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class StartupArrayAdapter extends ArrayAdapter<Startup> {
    private Context context;
    private int resource;


    public StartupArrayAdapter(@NonNull Context context, int resource, ArrayList<Startup> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(this.context).inflate(this.resource, parent, false);
        }
        // Code goes here
        Startup startup = getItem(position);
        if(startup!=null){
            TextView name = convertView.findViewById(R.id.name);
            name.setText(startup.getName());
            TextView status = convertView.findViewById(R.id.status);
            status.setText(startup.getStatusQuo());
        }
        return convertView;

    }
}

