package com.example.practica5;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private TextView texto;
    private static final String msg = "Has seleccionado ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = findViewById(R.id.t2);
        ListView list = findViewById(R.id.listView);
        list.setAdapter(new CentrosAdapter(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList(Arrays.asList("IES Doctor Fleming", "IES Monte Naránco", "CIFP Avilés"))));
        registerForContextMenu(list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        texto.setText(String.format("%s%s", msg, item.getTitle()));
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.listView) {
            int item = ((AdapterView.AdapterContextMenuInfo) menuInfo).position;
            menu.setHeaderTitle(((ListView) v).getAdapter().getItem(item).toString());
            getMenuInflater().inflate(R.menu.menu2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.editar:
            case R.id.eliminar:
                listViewItemAction(item);
                return true;
        }
        return super.onContextItemSelected(item);
    }

    private void listViewItemAction(MenuItem item) {
        ListView l = findViewById(R.id.listView);
        CentrosAdapter a = (CentrosAdapter) l.getAdapter();
        int position = ((AdapterView.AdapterContextMenuInfo) item.getMenuInfo()).position;
        switch (item.getItemId()) {
            case R.id.editar:
                a.editar(position);
                break;
            case R.id.eliminar:
                a.remove(position);
        }
    }
}