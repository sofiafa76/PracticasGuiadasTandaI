package com.example.practica3b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        List<Centro> l = Arrays.asList(
                new Centro("IES Doctor Fleming", "Doctor Fleming, 7 - Oviedo", R.drawable.fleming2),
                new Centro("IES Monte Naranco", "Pedro Caravia, 9 - Oviedo", R.drawable.montenaranco2),
                new Centro("CIFP Avilés", "Maqués S/N.  Avilés", R.drawable.aviles2)
        );

        rv.setAdapter(new CentrosAdapter(l));
    }
}