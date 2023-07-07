package com.example.basededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.basededatos.db.DbContactos;
import com.example.basededatos.db.DbHelper;

public class AgregarActivity extends AppCompatActivity {

    Button btnGrabar;
    EditText Nombre, Telefono, Correo;

    Long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_activity);

        btnGrabar = findViewById(R.id.btnGrabar);
        Nombre = findViewById(R.id.txtNombre);
        Telefono = findViewById(R.id.txtTelefono);
        Correo = findViewById(R.id.txtCorreo);

        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbContactos dbContactos = new DbContactos(AgregarActivity.this);
                dbContactos.insertarContacto(Nombre.getText().toString(), Telefono.getText().toString(), Correo.getText().toString());
                id = dbContactos.insertarContacto(Nombre.getText().toString(), Telefono.getText().toString(), Correo.getText().toString());

                if (id != 0){
                    Toast.makeText(getApplicationContext(),"Contacto creado", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(),"Error al crear Contacto", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}