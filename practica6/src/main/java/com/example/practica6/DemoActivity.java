package com.example.practica6;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
    }

    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.buttonWeb:
                intent.setDataAndType(Uri.parse("https://www.educastur.es"), Intent.ACTION_VIEW);
                break;
            case R.id.buttonLlamada:
                intent.setDataAndType(Uri.parse("tel:985105500"), Intent.ACTION_DIAL);
                break;
            case R.id.buttonCamara:
                intent.setType(MediaStore.ACTION_IMAGE_CAPTURE);
                break;
            case R.id.buttonCorreo:
                intent.setType(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "asunto");
                intent.putExtra(Intent.EXTRA_TEXT, "texto del correo");
                intent.putExtra(Intent.EXTRA_EMAIL, "micorreo@correo.com");
                break;
            case R.id.buttonMapa:
                intent.setDataAndType(Uri.parse("geo:43.359792,-5.85579"), Intent.ACTION_VIEW);
                break;
        }
        startActivity(intent);
    }
}