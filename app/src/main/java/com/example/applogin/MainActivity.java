package com.example.applogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText cajaName , cajaPassword;
    String user , pass;
    Button borrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cajaName = findViewById(R.id.cajaName);
        cajaPassword = findViewById(R.id.cajaPassword);

        borrar = (Button)findViewById(R.id.borrar);
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             cajaName.setText("");
             cajaPassword.setText("");
            }
        });
    }

    public void Login (View view){
        user = cajaName.getText().toString();
        pass = cajaPassword.getText().toString();

        if (user.isEmpty() || pass.isEmpty() ){
            Toast.makeText(this, "Favor de introducir una (Credenciales)", Toast.LENGTH_SHORT).show();

        }
        else {

        if (user.equals("admin") && pass.equals("12345"))


        {
            Intent ventana = new Intent(this, Prueba.class);
            startActivity(ventana);


        }


        else {Toast.makeText(this, "Usuario o Contraseña Erronea", Toast.LENGTH_SHORT).show();}

        }
    }
}
