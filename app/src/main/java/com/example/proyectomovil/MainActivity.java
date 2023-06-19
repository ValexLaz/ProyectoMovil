package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import com.example.proyectomovil.adaptadores.ListaMateriasAdapter;
import com.example.proyectomovil.db.DbHelper;
import com.example.proyectomovil.db.DbMaterias;
import com.example.proyectomovil.entidades.Materias;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnCrear;
    RecyclerView listaMaterias;
    ArrayList<Materias> listaArrayMaterias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCrear= findViewById(R.id.btnCrear);
        listaMaterias = findViewById(R.id.listaMaterias);
        listaMaterias.setLayoutManager(new LinearLayoutManager(this));

        DbMaterias dbMaterias= new DbMaterias(MainActivity.this);

        listaArrayMaterias = new ArrayList<>();

        ListaMateriasAdapter adapter = new ListaMateriasAdapter(dbMaterias.mostrarMaterias());
        listaMaterias.setAdapter(adapter);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if(db != null){
                    Toast.makeText(MainActivity.this,"BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(MainActivity.this,"ERROR AL CREAR LA BASE", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_nuevo:
                nuevoRegistro();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void nuevoRegistro(){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }



}