package com.example.sistemaexperto;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //Declaracion de botones
    Button btn_pais;
    Button btn_capital;
    Button btn_datos;
    Button btn_salir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlace de botones con el XML
        btn_datos = findViewById(R.id.btn_datos);
        btn_pais = findViewById(R.id.btn_pais);
        btn_capital = findViewById(R.id.btn_capital);
        btn_salir = findViewById(R.id.btn_salir);

        //Acción de cambio de vista al presionar cada boton
        btn_datos.setOnClickListener(view -> {
            Intent intent = new Intent (MainActivity.this, Agregar_datos.class);
            startActivity(intent);
        });
        btn_pais.setOnClickListener(view -> {
            Intent intent = new Intent (MainActivity.this, Activity_pais_capital.class);
            startActivity(intent);
        });
        btn_capital.setOnClickListener(view -> {
            Intent intent = new Intent (MainActivity.this, Activity_capital_pais.class);
            startActivity(intent);
        });
        btn_salir.setOnClickListener(view -> {
            //finish();
            //System.exit(0);
            Intent intent = new Intent (Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });
    }
}