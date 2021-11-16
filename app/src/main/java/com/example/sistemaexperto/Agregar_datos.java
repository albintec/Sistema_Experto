package com.example.sistemaexperto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Agregar_datos extends AppCompatActivity {

     //declaracion de boton y campos de texto
     Button btn_volver;
     EditText campPais, campCapital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_datos);

        //Enlace de boton, texto y campo con xml
        campPais = findViewById(R.id.camp_pais);
        campCapital = findViewById(R.id.camp_capital);
        btn_volver = findViewById(R.id.btn_volver);

        //acción del boton para volver al menu principal
        btn_volver.setOnClickListener(view -> {
            Intent intent = new Intent (Agregar_datos.this, MainActivity.class);
            startActivity(intent);
        });
    }
    //metodo para registrar en la BD los datos obtenidos en los campos de texto
    public void Registrar (View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

        String pais = campPais.getText().toString();
        String capital = campCapital.getText().toString();

        //Condicionales para enviar mensaje emergente en caso de que se cumpla o no se cumpla la inserción
        if (!pais.isEmpty() && !capital.isEmpty()) {
            ContentValues registro = new ContentValues();
            registro.put("pais", pais);
            registro.put("capital", capital);

            BaseDeDatos.insert("paises", null, registro);

            BaseDeDatos.close();
            campPais.setText("");
            campCapital.setText("");

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }

    }

}