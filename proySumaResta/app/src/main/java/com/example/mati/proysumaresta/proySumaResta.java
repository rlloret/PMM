package com.example.mati.proysumaresta;

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


public class proySumaResta extends Activity {


    public static int COD_RESPUESTA;

    private Button calcular;
    private EditText texto1, texto2;
    private TextView resultado;
    private RadioButton sumar, restar;
    private CheckBox chek;
    private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proy_suma_resta);



        calcular= (Button)findViewById(R.id.buttonCalcular);
        texto1= (EditText)findViewById(R.id.campo1);
        texto2= (EditText)findViewById(R.id.campo2);
        resultado= (TextView)findViewById(R.id.resultado);
        sumar = (RadioButton)findViewById(R.id.radiosumar);
        restar = (RadioButton)findViewById(R.id.radiorestar);
        chek = (CheckBox)findViewById(R.id.checkBox);
        imagen = (ImageView)findViewById(R.id.imagenandroid);



        calcular.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                if(sumar.isChecked()){
                    final int a = Integer.parseInt(texto1.getText().toString());
                    final int b = Integer.parseInt(texto2.getText().toString());
                    int respuesta= a+b;
                    resultado.setText(""+respuesta);


                    Intent miIntent= new Intent(proySumaResta.this, Pantalla2.class);
                    Bundle miBundle=new Bundle();

                    String mensajePaso= "EL resultado es: "+resultado.getText();
                    miBundle.putString("TEXTO", mensajePaso);
                    miIntent.putExtras(miBundle);
                    startActivityForResult(miIntent, COD_RESPUESTA);


                }

                if(restar.isChecked()){
                    final int a = Integer.parseInt(texto1.getText().toString());
                    final int b = Integer.parseInt(texto2.getText().toString());
                    int respuesta= a-b;
                    resultado.setText(""+respuesta);


                    Intent miIntent= new Intent(proySumaResta.this, Pantalla2.class);
                    Bundle miBundle=new Bundle();

                    String mensajePaso= "EL resultado es: "+resultado.getText();
                    miBundle.putString("TEXTO", mensajePaso);
                    miIntent.putExtras(miBundle);
                    startActivityForResult(miIntent, COD_RESPUESTA);


                }


            }
        });




        chek.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                if (chek.isChecked()) {
                    imagen.setVisibility(View.VISIBLE);

                } else {

                    imagen.setVisibility(View.INVISIBLE);
                }


            }
        });




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.proy_suma_resta, menu);
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
