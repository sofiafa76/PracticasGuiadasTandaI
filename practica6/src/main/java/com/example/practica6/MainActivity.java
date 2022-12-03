package com.example.practica6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ActivityResultCallback<ActivityResult> {

    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button) findViewById(R.id.buttonVerificar)).setOnClickListener(this);
        ((Button) findViewById(R.id.buttonDemo)).setOnClickListener(this);
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonVerificar:
                Intent intent = new Intent(this, VerificacionActivity.class);
                String nombre = ((EditText) findViewById(R.id.editNombre)).getText().toString();
                String pregunta = String.format(getResources().getString(R.string.pregunta), nombre);
                intent.putExtra("pregunta", pregunta);
                launcher.launch(intent);
                break;
            case R.id.buttonDemo:
                startActivity(new Intent(this, DemoActivity.class));
        }
    }

    @Override
    public void onActivityResult(ActivityResult result) {
        if (result.getResultCode() == Activity.RESULT_OK) {
            Intent datos = result.getData();
            ((TextView) findViewById(R.id.textRespuesta)).setText(datos.getStringExtra("resultado"));
        }
    }
}