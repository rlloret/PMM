package com.example.mati.examen;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by mati on 29/01/15.
 */
public class PantallaDos extends Activity {

    private TextView textViewZonarecibida,textViewTarifaRecibida, textViewPesoRecibido, textViewDecoracionRecibida, textViewPrecioTotal;
    private SQLitehelper cliBDh = new SQLitehelper(this, "DBDatosEnvio", null, 1);
    SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_dos);



     /*   botonVolver.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent vueltaIntent= new Intent();
                setResult(RESULT_OK, vueltaIntent);
                finish();
            }
        });*/

        Bundle miBundleRecoger = getIntent().getExtras();
        textViewZonarecibida.setText("Zona: "+miBundleRecoger.getString("situacion"));
        textViewTarifaRecibida.setText("Tarifa: "+miBundleRecoger.getString("tarifa"));
        textViewPesoRecibido.setText("Peso: "+miBundleRecoger.getString("pesoPaquete"));
        textViewDecoracionRecibida.setText("Decoracion: "+miBundleRecoger.getString("decoracion"));
        textViewPrecioTotal.setText("Coste Final: "+miBundleRecoger.getString("precioTotal"));


      /*  botonGrabar.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){

                bd = cliBDh.getWritableDatabase();

                if (bd!=null) {
                    bd.execSQL("INSERT INTO Multiplicar (num1,num2,total,calculo) " +
                            "VALUES ("+numeroUnoRecibidoInt+","+numeroDosRecibidoInt+","+resultadoRecibidoInt+",'"+calculo+"')");
                }
                bd.close();

            }

        });*/


    }
}
