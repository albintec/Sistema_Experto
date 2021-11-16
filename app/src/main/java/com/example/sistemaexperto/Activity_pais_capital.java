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

public class Activity_pais_capital extends AppCompatActivity {
    //declaracion de boton, texto y campo de texto
    Button btn_volver3;
    EditText edt_pais;
    TextView capital_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pais_capital);

        //Enlace de boton, texto y campo con xml
        btn_volver3 = (Button) findViewById(R.id.btn_volver3);
        edt_pais = (EditText) findViewById(R.id.txtPais_);
        capital_result = (TextView) findViewById(R.id.txtCapital_result);

        //acción del boton para volver al menu principal
        btn_volver3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Activity_pais_capital.this, MainActivity.class);
                startActivity(intent);
            }

        });

        }
        //Metodo que hace una consulta SQL para conseguir la capital de determinado pais
        public void Buscar(View view) {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null,1);
            SQLiteDatabase BaseDeDatabase = admin.getReadableDatabase();

            String pais = edt_pais.getText().toString();
            //capital_result.setText(pais);

            if(!pais.isEmpty()) {
                Cursor fila = BaseDeDatabase.rawQuery("select capital from paises where pais ='" + pais + "'",null);
                if(fila.moveToFirst()){
                    capital_result.setText(fila.getString(0));
                    BaseDeDatabase.close();
                }else {
                    Toast.makeText(this,"No se ha registrado", Toast.LENGTH_SHORT).show();
                    BaseDeDatabase.close();
                }
            }else {
                Toast.makeText(this,"Debes ingresar el pais", Toast.LENGTH_SHORT).show();
            }
        }

}