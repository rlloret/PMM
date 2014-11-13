package com.example.roberto.calculadora;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.math.BigDecimal;


public class MainActivity extends Activity {


    private Button calcular;
    private EditText texto1, texto2;
    private TextView resultado;
    private RadioButton sumar, restar, multiplicar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        calcular= (Button)findViewById(R.id.buttonCalcular);
        texto1= (EditText)findViewById(R.id.campo1);
        texto2= (EditText)findViewById(R.id.campo2);
        resultado= (TextView)findViewById(R.id.resultado);
        sumar = (RadioButton)findViewById(R.id.radiosumar);
        restar = (RadioButton)findViewById(R.id.radiorestar);
        multiplicar = (RadioButton)findViewById(R.id.radiomultiplicar);



        calcular.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                if(sumar.isChecked()){
                    final int a = Integer.valueOf(texto1.getText().toString());
                    final int b = Integer.valueOf(texto2.getText().toString());
                    int respuesta= a+b;
                    resultado.setText(""+respuesta);


                }

                if(restar.isChecked()){
                    final int a = Integer.valueOf(texto1.getText().toString());
                    final int b = Integer.valueOf(texto2.getText().toString());
                    int respuesta= a-b;
                    resultado.setText(""+respuesta);

                }

                if(multiplicar.isChecked()){
                    final int a = Integer.valueOf(texto1.getText().toString());
                    final int b = Integer.valueOf(texto2.getText().toString());
                    int respuesta= a*b;
                    resultado.setText(""+respuesta);

                }

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
