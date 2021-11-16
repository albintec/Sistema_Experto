package com.example.sistemaexperto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_capital_pais extends AppCompatActivity {
    //declaracion de boton, texto y campo de texto
     Button btn_volver2;
     EditText edt_capital;
     TextView pais_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital_pais);

        //Enlace de boton, texto y campo con xml
        btn_volver2 = (Button) findViewById(R.id.btn_volver2);
        edt_capital = (EditText) findViewById(R.id.campCapital);
        pais_result = (TextView) findViewById(R.id.txtPais_result);

        //acción del boton para volver al menu principal
        btn_volver2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Activity_capital_pais.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    //Metodo que hace una consulta SQL para conseguir el pais de determinada capital
    public void Buscar2(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatabase = admin.getReadableDatabase();

        String capital = edt_capital.getText().toString();
        pais_result.setText(capital);

        if (!capital.isEmpty()) {
            Cursor fila = BaseDeDatabase.rawQuery("select pais from paises where capital ='" + capital + "'", null);
            if (fila.moveToFirst()) {
                pais_result.setText(fila.getString(0));
                BaseDeDatabase.close();
            } else {
                Toast.makeText(this, "No se ha registrado", Toast.LENGTH_SHORT).show();
                BaseDeDatabase.close();
            }
        } else {
            Toast.makeText(this, "Debes ingresar la capital", Toast.LENGTH_SHORT).show();
        }
    }
}