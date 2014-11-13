package com.example.maria.holamundo1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Hola1 extends Activity {



    private TextView milabel;
    private Button miboton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hola1);

        milabel = (TextView) findViewById(R.id.milabel);
        miboton = (Button) findViewById(R.id.miboton);

        miboton.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {
                milabel.setText("Boton pulsado");

            }
        });

    }
} // la Actividad
