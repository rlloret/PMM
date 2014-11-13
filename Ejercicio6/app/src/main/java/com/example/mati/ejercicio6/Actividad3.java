package com.example.mati.ejercicio6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by mati on 4/11/14.
 */
public class Actividad3 extends Activity {

    private Button buttonVuelta3;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        buttonVuelta3= (Button)findViewById(R.id.buttonVuelta3);
        Bundle  miBundleRecoger = getIntent().getExtras();

        buttonVuelta3.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent vueltaIntent= new Intent();
                Bundle vueltaBundle=new Bundle();

                String mensajeDevuelto= "Vengo de pantalla 3";
                vueltaBundle.putString("DEVUELTO", mensajeDevuelto);
                vueltaIntent.putExtras(vueltaBundle);
                setResult(RESULT_OK, vueltaIntent);
                finish();

            }

        });


    }


}
