package com.example.roberto.linearlayout;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


public class LinearLayout extends Activity {

    private RadioButton botonverde;
    private RadioButton botonrojo;
    private RadioButton botonazul;
    private Button borrar;
    private Button ponerColor;
    private TextView campo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);


        botonverde = (RadioButton)findViewById(R.id.radioButtonVerde);
        botonrojo = (RadioButton)findViewById(R.id.radioButtonRojo);
        botonazul = (RadioButton)findViewById(R.id.radioButtonAzul);
        borrar = (Button)findViewById(R.id.buttonBorrar);
        ponerColor = (Button)findViewById(R.id.buttonPonerColor);
        campo = (TextView)findViewById(R.id.fondoblanco);

        ponerColor.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                if(botonverde.isChecked())
                    campo.setBackgroundColor(Color.parseColor("green"));

                if(botonrojo.isChecked())
                    campo.setBackgroundColor(Color.parseColor("red"));

                if(botonazul.isChecked())
                    campo.setBackgroundColor(Color.parseColor("blue"));

            }
        });


        borrar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0)
            {
                campo.setBackgroundColor(Color.parseColor("white"));
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_linear_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
