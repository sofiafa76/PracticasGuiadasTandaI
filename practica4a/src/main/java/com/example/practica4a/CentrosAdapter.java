package com.example.practica4a;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CentrosAdapter extends ArrayAdapter<Centro> {

    List<Centro> centros;

    public CentrosAdapter(@NonNull Context context, int resource, @NonNull List<Centro> objects) {
        super(context, resource, objects);
        centros = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Centro c = getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.item, parent, false);
        ((ImageView) convertView.findViewById(R.id.imageView)).setImageResource(c.getImagen());
        ((TextView) convertView.findViewById(R.id.nombreTextView)).setText(c.getNombre());
        ((TextView) convertView.findViewById(R.id.dirTextView)).setText(c.getDireccion());
        return convertView;
    }

    public void elimininar(int posicion) {
        centros.remove(posicion);
        notifyDataSetChanged();
    }
}