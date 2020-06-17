package com.example.applogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView info;
    TextView nom;
    ImageView fot;
    String informacion;
    String nombre;
    int foto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       informacion = getIntent().getStringExtra("Informacion");
        nombre= getIntent().getStringExtra("Nombre");
        foto = getIntent().getIntExtra("foto" , 0);
        info =  findViewById(R.id.textView3);
        nom = findViewById(R.id.textView2);
        fot = findViewById(R.id.imageView3);
        fot.setImageResource(foto);
        info.setText(informacion);
        nom.setText(nombre);




    }

    public void back (View view){

        Intent prueba2 = new Intent(this, Prueba.class);
        startActivity(prueba2);

    }
    public void map (View view){

        Intent map= new Intent(this, Maps.class);
        map.putExtra("Informacion" , informacion);
        startActivity(map);


    }





}
