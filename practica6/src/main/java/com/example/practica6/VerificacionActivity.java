package com.example.practica6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VerificacionActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificacion);
        ((Button) findViewById(R.id.buttonAceptar)).setOnClickListener(this);
        ((Button) findViewById(R.id.buttonRechazar)).setOnClickListener(this);
        ((TextView) findViewById(R.id.textView)).setText(getIntent().getStringExtra("pregunta"));
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.buttonAceptar:
                intent.putExtra("resultado", "SI");
                break;
            case R.id.buttonRechazar:
                intent.putExtra("resultado", "NO");
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}