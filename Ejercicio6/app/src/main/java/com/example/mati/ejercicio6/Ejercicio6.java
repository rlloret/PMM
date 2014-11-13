package com.example.mati.ejercicio6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;


public class Ejercicio6 extends Activity {


    public static int COD_RESPUESTA=0;
    TextView respuesta;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio6);


       final Button irapantalla2 = (Button) findViewById(R.id.buttonp2);
       final Button irapantalla3 = (Button) findViewById(R.id.buttonp3);
       respuesta= (TextView)findViewById(R.id.miLbl);


        if (savedInstanceState!=null){
            String mensajePasado=savedInstanceState.getString("TEXTO");
            respuesta.setText(mensajePasado);

        }



        irapantalla2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent miIntent= new Intent(Ejercicio6.this, Actividad2.class);
                Bundle miBundle=new Bundle();

                miIntent.putExtras(miBundle);
                startActivityForResult(miIntent, COD_RESPUESTA);

            }
        });



        irapantalla3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent miIntent= new Intent(Ejercicio6.this, Actividad3.class);
                Bundle miBundle=new Bundle();

                miIntent.putExtras(miBundle);
                startActivityForResult(miIntent, COD_RESPUESTA);

            }
        });

    }
    public void onActivityResult(int cod_resp, int cod_result,Intent intent) {
        if (cod_result == RESULT_OK) {
            Bundle otroBundle = intent.getExtras();
            respuesta.setText(otroBundle.getString("DEVUELTO"));
        }


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ejercicio6, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
