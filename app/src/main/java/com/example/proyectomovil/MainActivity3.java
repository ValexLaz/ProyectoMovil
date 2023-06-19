package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectomovil.db.DbHelper;
import com.example.proyectomovil.db.DbMaterias;

public class MainActivity3 extends AppCompatActivity {

    EditText txtNombre;
    EditText txtPeriodo;
    EditText txtDias;
    EditText txtHoraInicio;
    EditText txtHoraFin;
    Button btnGuardarMat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        txtNombre = findViewById(R.id.txtNombre);
        txtPeriodo = findViewById(R.id.txtPeriodo);
        txtDias = findViewById(R.id.txtDias);
        txtHoraInicio = findViewById(R.id.txtHoraInicio);
        txtHoraFin = findViewById(R.id.txtHoraFin);
        btnGuardarMat=findViewById(R.id.btnGuardarMat);

        btnGuardarMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbMaterias dbMaterias = new DbMaterias(MainActivity3.this);
                long id=  dbMaterias.insertaMateria(txtNombre.getText().toString(),txtPeriodo.getText().toString(),
                        txtDias.getText().toString(), txtHoraInicio.getText().toString(),txtHoraFin.getText().toString());

                if(id>0){
                    Toast.makeText(MainActivity3.this, "Registro guardado", Toast.LENGTH_LONG).show();
                    limpiar();

                }else{
                    Toast.makeText(MainActivity3.this, "Error al guardar registro", Toast.LENGTH_LONG).show();

                }

            }
        });

    }

    private void limpiar(){
        txtNombre.setText("");
        txtPeriodo.setText("");
        txtDias.setText("");
        txtHoraInicio.setText("");
        txtHoraFin.setText("");
    }
}