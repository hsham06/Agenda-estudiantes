package com.example.applogin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.DatePicker;
import java.util.Calendar;


public class Main2Activity extends AppCompatActivity {

    EditText t1;
    private int mYearIni, mMonthIni, mDayIni, sYearIni, sMonthIni, sDayIni;
    static final int DATE_ID = 0;
    Calendar C = Calendar.getInstance();

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

        sMonthIni = C.get(Calendar.MONTH);
        sDayIni = C.get(Calendar.DAY_OF_MONTH);
        sYearIni = C.get(Calendar.YEAR);
        t1 = (EditText) findViewById(R.id.editText);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(DATE_ID);
            }
        });


    }


    private void colocar_fecha() {
        t1.setText((mMonthIni + 1) + "-" + mDayIni + "-" + mYearIni+" ");}

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    mYearIni = year;
                    mMonthIni = monthOfYear;
                    mDayIni = dayOfMonth;
                    colocar_fecha();

                }

            };
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this, mDateSetListener, sYearIni, sMonthIni, sDayIni);}  return null;}








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
