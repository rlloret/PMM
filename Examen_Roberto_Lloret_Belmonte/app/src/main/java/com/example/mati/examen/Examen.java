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
                    new Zona("Seleccione..."),
                    new Zona("Zona A: Asia y Oceanía:30 E"),
                    new Zona("Zona B: América y África:20 E"),
                    new Zona("Zona C: Europa: 10 E")
            };

    private String tipoZona;
    private float precioPeso, precioTotal;
    private int pesoPaquete,precioFijo;
    private String situacion, tarifa, decoracion;



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

                        break;
                    case 1:
                        precioFijo = 30;

                        //precioTotal =  CalculaPrecio(precioFijo);

                        String pesopa=String.valueOf(campoPeso);
                        pesoPaquete=Integer.parseInt(pesopa);

                        if(pesoPaquete<=5)
                            precioPeso=1*pesoPaquete;
                        if(pesoPaquete>6 && pesoPaquete<10)
                            precioPeso= (float) (1.5*pesoPaquete);
                        if(pesoPaquete>10)
                            precioPeso=2*pesoPaquete;

                        precioTotal = precioFijo + precioPeso;

                        calcular.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                if(radioUrgente.isChecked()){

                                    precioTotal += precioTotal*0.3;
                                    tarifa="Urgente";
                                }

                                if(checkCaja.isChecked()){
                                    decoracion+="Con caja regalo";
                                }
                                if(checkRegalo.isChecked()){

                                    decoracion+="Con dedicatoria";
                                }

                            situacion = "A(Asia y Oceanía)";
                            String strprecio=String.valueOf(precioTotal);
                            String strpesopaquete=String.valueOf(pesoPaquete);
                            pasoPantalla(situacion, tarifa, strpesopaquete, decoracion, strprecio);

                            }
                        });
                        break;

                    case 2:
                        precioFijo = 20;

                       // precioTotal =  CalculaPrecio(precioFijo);

                        String pesopa2=String.valueOf(campoPeso);
                        pesoPaquete=Integer.parseInt(pesopa2);

                        if(pesoPaquete<=5)
                            precioPeso=1*pesoPaquete;
                        if(pesoPaquete>6 && pesoPaquete<10)
                            precioPeso= (float) (1.5*pesoPaquete);
                        if(pesoPaquete>10)
                            precioPeso=2*pesoPaquete;

                        precioTotal = precioFijo + precioPeso;

                        calcular.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {

                                if(radioUrgente.isChecked()){

                                    precioTotal += precioTotal*0.3;
                                }
                                if(checkCaja.isChecked()){
                                    decoracion+="Con caja regalo";
                                }
                                if(checkRegalo.isChecked()){

                                    decoracion+="Con dedicatoria";
                                }

                                situacion = "B(América y África)";
                                String strprecio=String.valueOf(precioTotal);
                                String strpesopaquete=String.valueOf(pesoPaquete);
                                pasoPantalla(situacion, tarifa, strpesopaquete, decoracion, strprecio);


                            }
                        });
                        break;
                    case 3:
                        precioFijo = 10;

                       //precioTotal =  CalculaPrecio(precioFijo);


                        String pesopa3=String.valueOf(campoPeso);
                        pesoPaquete=Integer.parseInt(pesopa3);

                        if(pesoPaquete<=5)
                            precioPeso=1*pesoPaquete;
                        if(pesoPaquete>6 && pesoPaquete<10)
                            precioPeso= (float) (1.5*pesoPaquete);
                        if(pesoPaquete>10)
                            precioPeso=2*pesoPaquete;

                        precioTotal = precioFijo + precioPeso;

                        calcular.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {

                                if(radioUrgente.isChecked()){

                                    precioTotal += precioTotal*0.3;
                                }

                                if(checkCaja.isChecked()){
                                    decoracion+="Con caja regalo";
                                }
                                if(checkRegalo.isChecked()){

                                    decoracion+="Con dedicatoria";
                                }

                                situacion = "C(Europa)";
                                String strprecio=String.valueOf(precioTotal);

                                String strpesopaquete=String.valueOf(pesoPaquete);

                                pasoPantalla(situacion, tarifa, strpesopaquete, decoracion, strprecio);

                            }
                        });
                        break;

                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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


  /*  public float CalculaPrecio(int precioFijo){
        float resultado=0;

        String pesopa=String.valueOf(campoPeso);
        pesoPaquete=Integer.parseInt(pesopa);

        if(pesoPaquete<=5)
            precioPeso=1*pesoPaquete;
        if(pesoPaquete>6 && pesoPaquete<10)
            precioPeso= (float) (1.5*pesoPaquete);
        if(pesoPaquete>10)
            precioPeso=2*pesoPaquete;

        resultado = precioFijo + precioPeso;

        return resultado;
    }*/
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
