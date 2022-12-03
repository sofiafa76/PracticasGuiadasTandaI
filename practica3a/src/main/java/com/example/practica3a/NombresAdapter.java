package com.example.practica3a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NombresAdapter extends RecyclerView.Adapter<NombresAdapter.Holder> {

    static class Holder extends RecyclerView.ViewHolder {
        final TextView nombre;

        public Holder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(android.R.id.text1);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    Toast.makeText(view.getContext(), nombre.getText(), Toast.LENGTH_LONG).show();
                    return true;
                }
            });
        }
    }

    List<String> nombres;

    public NombresAdapter(List<String> nombres) {
        this.nombres = nombres;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.nombre.setText(nombres.get(position));
    }

    @Override
    public int getItemCount() {
        return nombres.size();
    }
}