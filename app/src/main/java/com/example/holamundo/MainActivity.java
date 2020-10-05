package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapp.R;

public class MainActivity extends AppCompatActivity {
    private final static String etiqueta = "ejemplo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Ponemos en la aplicación el layout principal para que se visualice al abrir la aplicación
        setContentView(R.layout.activity_main);

        //Botón
        Button btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                /*
                    Mediante el gestor de recursos R podemos acceder a los elementos del layout.
                    Por ejemplo, accederemos al editText mediante su identificador.
                    Para acceder a la vista, utilizamos la función findViewById.
                    Y convertimos esa vista desde la clase base a la clase hijo. Es decir, polimorfismo.
                    Esto es mediante un casting explícito.
                */
                EditText textoIntroducido = (EditText) findViewById(R.id.editTextTextPersonName);
                //Lo que hacemos es obtener la cadena introducida en la vista.
                String texto = textoIntroducido.getText().toString();
                Log.i(etiqueta,texto);
                TextView textoMostrar = (TextView) findViewById(R.id.textView2);
                textoMostrar.setText(texto);
                //Log.d();

                //Intents: coordina diferentes actividades
                Intent comunicacion = new Intent(v.getContext(),MostrarNombre.class);
                //¿Qué le vamos a comunicar? El nombre que ha insertado
                comunicacion.putExtra("NOMBRE",texto);
                //Vamos a iniciar la actividad mostrar_saludo
                startActivity(comunicacion);
            }
        });
    }
}