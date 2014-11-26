package com.maria.spinnersimple;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


public class SpinnerSimple extends Activity {

    Spinner miSpinner;
    final static String semana[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
    final static Integer numeracion []={1,2,3,4,5,6,7};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_simple);

        String mensaje;
        miSpinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<Integer> miAdaptador = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, numeracion);
       miAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        miSpinner.setAdapter(miAdaptador);
        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "";
                mensaje = "Item clicked => " + numeracion[position];
                showToast(mensaje);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
