package com.example.applogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;

public class Prueba extends AppCompatActivity {
    ArrayList<EstudiantesVO>listaEstudiantes;
    RecyclerView recyclerEstudiantes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);

        listaEstudiantes = new ArrayList<>();
        recyclerEstudiantes = findViewById(R.id.recyclerId);
        recyclerEstudiantes.setLayoutManager(new LinearLayoutManager(this));

        llenarEstudiantes ();
        AdaptadorEstudiantes adapter = new AdaptadorEstudiantes(listaEstudiantes);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast.makeText(getApplicationContext(), "Seleccion: " +
                        listaEstudiantes.get(recyclerEstudiantes.getChildAdapterPosition(view)).
                                getFoto(),Toast.LENGTH_SHORT).show();*/

                info( listaEstudiantes.get(recyclerEstudiantes.getChildAdapterPosition(view)).
                        getInfo() , listaEstudiantes.get(recyclerEstudiantes.getChildAdapterPosition(view)).
                        getNombre() , listaEstudiantes.get(recyclerEstudiantes.getChildAdapterPosition(view)).getFoto());


            }
        });
        recyclerEstudiantes.setAdapter(adapter);

    }

    private void llenarEstudiantes() {
        listaEstudiantes.add(new EstudiantesVO("Hanvan Sham" , " Ocupacion:  Estudiante TIC UNIBE \n Estado: 6to cuatrimestre \n Direccion:  Santo Domingo \n Latitud = 18.50967012955735  \n Longitud = -70.00893091061302 " ,R.drawable.sham));
        listaEstudiantes.add(new EstudiantesVO("Starling Javier" , " Ocupacion: Estudiante TIC UNIBE \n Estado: 6to cuatrimestre \n Direccion: Bonao \n Latitud = 18.9322998  \n Longitud = -70.3989936  " ,R.drawable.starling));




    }

    public void back (View view)
    {
        Intent ventana2 = new Intent(this, MainActivity.class);
        startActivity(ventana2);

    }

    public void info (String inf ,  String nom , int fot) {

        Intent prueba = new Intent(this, Main2Activity.class);
        prueba.putExtra("Nombre" , nom);
        prueba.putExtra("Informacion" , inf);
        prueba.putExtra("foto",  fot);
        startActivity(prueba);

    }







}
