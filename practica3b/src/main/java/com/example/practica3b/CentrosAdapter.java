package com.example.practica3b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
//Un adapter es la clase que comunica el layout que tiene el diseño con el layout que los recibe
public class CentrosAdapter  extends RecyclerView.Adapter<CentrosAdapter.ViewHolder> {
    //contenedor de datos
    List<Centro> centro;
    public  CentrosAdapter(List<Centro> modeList){

        centro=modeList;
    }

    @NonNull
    @Override
/*
Usamos este metodo para crear una ViewHolder nueva.Este método crea el ViewHolder y su View asociada y los inicializa
pero no compleata el contenido de la vista.
 */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    /*Asocia una ViewHolder con los datos, para ello recupera los datos correspondientes y los usa
    para completar el diseño del cotenedor de vistas.
     */
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(centro.get(position));

    }

    @Override
    //Con este método obtenemos el tamaño del conjunto de datos
    public int getItemCount() {
        return centro.size();
    }
    //Creamos la clase ViewHolder
    static class ViewHolder extends RecyclerView.ViewHolder{
        private  final TextView nombre;
        private  final TextView direccion;
        private  final ImageView imagen;

        //Creamos un constructor donde identificamos cada elemento a traves de la id
        public ViewHolder(View v){
            super(v);
            nombre= v.findViewById(R.id.nombrestextView);
            direccion= v.findViewById(R.id.direcciontextView);
            imagen=v.findViewById(R.id.imageView);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(v.getContext(),nombre.getText(),Toast.LENGTH_SHORT).show();
                }
            });


        }
        //Utilizamos este método para asignarle el valor a cada variable.
        void bind (Centro centro){
            nombre.setText(centro.getNombre());
            direccion.setText(centro.getDireccion());
            imagen.setImageResource(centro.getImagen());
        }


    }
}

