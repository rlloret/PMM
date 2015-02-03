package com.example.mati.examen;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by mati on 29/01/15.
 */
public class PantallaDos extends Activity {

    private TextView textViewZonarecibida,textViewTarifaRecibida, textViewPesoRecibido, textViewDecoracionRecibida, textViewPrecioTotal;
    private SQLitehelper cliBDh = new SQLitehelper(this, "DBDatosEnvio", null, 1);
    SQLiteDatabase bd;
    String zona, tarifa,peso,decoracion,costeFinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_dos);

        textViewZonarecibida = (TextView)findViewById(R.id.textViewZonarecibida);
        textViewTarifaRecibida = (TextView)findViewById(R.id.textViewDecoracionRecibida);
        textViewPesoRecibido = (TextView)findViewById(R.id.textViewPesoRecibido);
        textViewDecoracionRecibida =(TextView)findViewById(R.id.textViewDecoracionRecibida);
        textViewPrecioTotal = (TextView)findViewById(R.id.textViewPrecioTotal);



        Bundle miBundleRecoger = getIntent().getExtras();

        zona=miBundleRecoger.getString("situacion");
        textViewZonarecibida.setText("Zona: "+zona);

        tarifa=miBundleRecoger.getString("tarifa");
        textViewTarifaRecibida.setText("Tarifa: "+tarifa);

        peso = miBundleRecoger.getString("pesoPaquete");
        textViewPesoRecibido.setText("Peso: "+peso);

        decoracion=miBundleRecoger.getString("decoracion");
        textViewDecoracionRecibida.setText("Decoracion: "+decoracion);

        costeFinal=miBundleRecoger.getString("precioTotal");
        textViewPrecioTotal.setText("Coste Final: "+costeFinal);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        getMenuInflater().inflate(R.menu.examen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_bd)
        {
            bd = cliBDh.getWritableDatabase();

            if (bd!=null) {
                bd.execSQL("INSERT INTO DatosEnvio (zona, tarifa, peso, decoracion, coste) " +
                        "VALUES ('"+zona+"','"+tarifa+"','"+peso+"','"+decoracion+"'+'"+costeFinal+"')");
            }
            bd.close();

            return true;
        }
        if(id == R.id.action_aza)
        {

            String azafata="azafata";

            Intent miIntent = new Intent(PantallaDos.this, PantallaTres.class);
            Bundle miBundle = new Bundle();
            miBundle.putString("dibujar", azafata);
            miIntent.putExtras(miBundle);
            startActivity(miIntent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
