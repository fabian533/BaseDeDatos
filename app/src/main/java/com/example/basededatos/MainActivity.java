package com.example.basededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.basededatos.db.DbHelper;

public class MainActivity extends AppCompatActivity {

    Button btnCrear, btnAgregar, btnConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCrear = findViewById(R.id.btnCrear);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnConsultar = findViewById(R.id.btnConsultar);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db!=null){
                    Toast.makeText(getApplicationContext(),"Base de Datos creada", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(),"Error al crear la Base de Datos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent objIntent = new Intent(MainActivity.this, AgregarActivity.class);
                startActivity(objIntent);
            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent objIntent = new Intent(MainActivity.this, ConsultarActivity.class);
                startActivity(objIntent);
            }
        });
    }
}