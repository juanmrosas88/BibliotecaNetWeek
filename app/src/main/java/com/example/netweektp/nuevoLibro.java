package com.example.netweektp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class nuevoLibro extends AppCompatActivity {

    /*
    BASE DE DATOS
    Categoria
        Id PK int
        Nombre varchar(50)
        Habilitada bit
    Libros
        Id PK int
        Nombre varchar(50)
        FechaEdicion datetime
        EnStock bit
        Edicion varchar(50)
        Id_Categoria FK int

     */

    Spinner spCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_libro);
        spCategoria = findViewById(R.id.spCategorias);
        cargarSpinner();
    }

    private void cargarSpinner() {

        ArrayAdapter<CharSequence> adapterCateg = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.Categorias_array, android.R.layout.simple_spinner_item);
        adapterCateg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategoria.setAdapter(adapterCateg);

    }

    public void click_btn_volver(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
