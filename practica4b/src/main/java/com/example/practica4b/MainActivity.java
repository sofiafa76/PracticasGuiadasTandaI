package com.example.practica4b;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    CentrosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Centro> centros = new ArrayList<>(Arrays.asList(
                new Centro ("IES Doctor Fleming", "Doctor Fleming, 7. Oviedo", R.drawable.fleming2),
                new Centro ("IES Monte Naranco", "Pedro Caravia, 9. Oviedo", R.drawable.montenaranco2),
                new Centro ("CIFP Avilés", "Marqués S/N. Avilés", R.drawable.aviles2)
        ));
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter = new CentrosAdapter(this, R.layout.item, centros));
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.eliminar:
                eliminar(((AdapterView.AdapterContextMenuInfo) item.getMenuInfo()).position);
        }
        return true;
    }

    public void eliminar (int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Esta a punto de eliminar un elemento de la lista, ¿desea continuar?")
                .setTitle("Centros")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        adapter.elimininar(position);
                    }
                })
                .setNegativeButton("No", null);
        builder.create().show();
    }

}