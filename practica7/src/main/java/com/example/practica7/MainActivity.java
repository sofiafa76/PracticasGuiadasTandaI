package com.example.practica7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CharSequence[]centros={"Cantabria","Ataulfo","Argenta","Alisal","Santa Clara"};
        AlertDialog.Builder constructor=new AlertDialog.Builder(this);
        constructor.setMessage("Dialog de prueba")
                .setTitle("Titulo del dialog")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("PRIMER BOTON", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("SEGUNDO BOTON", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNeutralButton("TERCER BOTON", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setItems(centros, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialogo=constructor.create();
        dialogo.show();
        final Calendar calendario=Calendar.getInstance();
       int año=calendario.get(Calendar.YEAR);
       int mes=calendario.get(Calendar.MONTH);
       int dia=calendario.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog fecha=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int año, int mes, int dia) {

            }
        },año,mes,dia);
        fecha.show();
        int hora=calendario.get(Calendar.HOUR);
        int minuto=calendario.get(Calendar.MINUTE);
        int segundo=calendario.get(Calendar.SECOND);

        TimePickerDialog horario=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hora, int minuto) {

            }
        },hora,minuto,false);
        horario.show();
    }
}