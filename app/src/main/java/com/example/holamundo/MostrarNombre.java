package com.example.holamundo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myapp.R;

public class MostrarNombre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_saludo);

        //Ponemos la cadena en pantalla
        String nombre = getIntent().getStringExtra("NOMBRE");
        TextView mostrarNombre = (TextView) findViewById(R.id.editTextTextPersonName2);
        mostrarNombre.setText(nombre);

        //Pulsar el botón para volver a la pantalla principal (MainActivity)
        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent principal = new Intent(v.getContext(),MainActivity.class);
                startActivity(principal);
            }
        });
    }
}
