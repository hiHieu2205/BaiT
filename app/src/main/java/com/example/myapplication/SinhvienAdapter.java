package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SinhvienAdapter extends ArrayAdapter<Sinhvien> {
    public SinhvienAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public SinhvienAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if(v == null){
            LayoutInflater vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.item_list, null);
        }
        Sinhvien sv= getItem(position);

        if(sv!=null){
            TextView textViewHoten = (TextView) v.findViewById(R.id.textViewHoten);
            TextView textViewNamsinh = (TextView) v.findViewById(R.id.textViewNamsinh);
            textViewHoten.setText(sv.Hoten);
            textViewNamsinh.setText(String.valueOf(sv.Namsinh));
        }
        return v;
    }

}
