package com.example.mati.examen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;


public class Examen extends Activity {

    public Spinner spinner;
    private RadioButton radioNormal, radioUrgente;
    public CheckBox checkCaja, checkRegalo;
    private Button peso,calcular;
    private EditText campoPeso;
    public Zona[] zonas =
            new Zona[]{
                    new Zona("Zona A","Asia y Oceania",30),
                    new Zona("Zona B","America y Africa", 20),
                    new Zona("Zona C","Europa",10)
            };

    private String tipoZona;
    private float precioPeso, precioTotal;
    private int pesoPaquete,precioFijo;
    private String situacion, tarifa;
    private String decoracion="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen);

        radioNormal = (RadioButton)findViewById(R.id.radioNormal);
        radioUrgente = (RadioButton)findViewById(R.id.radioUrgente);
        spinner = (Spinner) findViewById(R.id.spinner);
        calcular = (Button)findViewById(R.id.buttonHacerCalculos);
        checkCaja = (CheckBox)findViewById(R.id.checkBox2);
        checkRegalo = (CheckBox)findViewById(R.id.checkBox);
        campoPeso = (EditText)findViewById(R.id.editTextIntroducePeso);

        Adaptador miAdaptador = new Adaptador(this);
        spinner.setAdapter(miAdaptador);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {

                tipoZona=zonas[position].getZona();

                switch(position){
                    case 0:
                        precioFijo = 30;
                        situacion = "A(Asia y Oceanía)";
                        break;
                    case 1:
                        precioFijo = 20;
                        situacion = "B(América y África)";

                        break;

                    case 2:
                        precioFijo = 10;
                        situacion = "C(Europa)";
                        break;

                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });

                    //Realizo los calculos para obtener datos y llamo a pasopantalla
                         calcular.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                if(radioUrgente.isChecked()){

                                    precioTotal += precioTotal*0.3;
                                    tarifa="Urgente";
                                }

                                if(checkCaja.isChecked()){
                                    decoracion += " con caja regalo";
                                }
                                if(checkRegalo.isChecked()){

                                    decoracion += " con dedicatoria";
                                }


                                pesoPaquete=Integer.parseInt(campoPeso.getText().toString());

                                precioTotal =  CalculaPrecio(precioFijo);

                                precioTotal = precioFijo + precioPeso;


                            String strprecio=String.valueOf(precioTotal);

                            String strpesopaquete=String.valueOf(pesoPaquete);

                            pasoPantalla(situacion, tarifa, strpesopaquete, decoracion, strprecio);

                            }
                        });
    }




    class Adaptador extends ArrayAdapter<Zona> {
        public Activity miActividad;

        public Adaptador(Activity laActividad){
            super(laActividad, R.layout.activity_contenido_spinner,zonas);
            this.miActividad=laActividad;
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vistaDesplegada=getView(position, convertView, parent);
            return vistaDesplegada;
        }

        public View getView(int position, View convertView, ViewGroup parent){
            View item=convertView;
            ViewHolder holder;

            if(item==null) {

                LayoutInflater inflater = miActividad.getLayoutInflater();
                item = inflater.inflate(R.layout.activity_contenido_spinner, null);

                holder = new ViewHolder();

                holder.operador = (TextView) item.findViewById(R.id.campoTipo);


                item.setTag(holder);
            }else{
                holder=(ViewHolder)item.getTag();
            }

            holder.operador.setText(zonas[position].getZona());

            return item;
        }
    }


    public float CalculaPrecio(int precioFijo){
        float resultado=0;

        if(pesoPaquete<=5)
            precioPeso=precioPeso+pesoPaquete;
        if(pesoPaquete>5 && pesoPaquete<=10)
            precioPeso= (float) (precioPeso+(pesoPaquete*1.5));
        if(pesoPaquete>10) {
            precioPeso = precioPeso + (2 * pesoPaquete);
        }

        resultado = precioFijo + precioPeso;

        return resultado;
    }
    public void pasoPantalla(String situacion, String tarifa, String strpesopaquete, String decoracion, String strprecio){

        Intent miIntent = new Intent(Examen.this, PantallaDos.class);
        Bundle miBundle = new Bundle();

        miBundle.putString("situacion", situacion);
        miBundle.putString("tarifa", tarifa);
        miBundle.putString("pesoPaquete", strpesopaquete);
        miBundle.putString("decoracion", decoracion);
        miBundle.putString("precioTotal", strprecio);

        miIntent.putExtras(miBundle);

        startActivity(miIntent);
    }

}
