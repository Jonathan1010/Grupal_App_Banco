package com.example.banco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MenuPrincipal extends AppCompatActivity implements View.OnClickListener {
    private ImageButton calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);
        //fijar parametros
        calcular = (ImageButton) findViewById(R.id.prestamo);
        calcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
    if(view == calcular){
        Intent siguiente = new Intent(this,MainActivity.class);
        startActivity(siguiente);
    }
    }
}