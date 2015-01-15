package com.example.mati.listintelefonico;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class ListinTelefonico extends Activity {

    private ListView lview;
    private Button botonModificar, botonEliminar, botonNuevo, botonListar, botonGuardar;
    SQLiteDatabase bd;
    EditText campoNombre, campoTelefono;
    String resultado[]= new String[100];
    String eleccion;
    private int numeracionCodigo=0;

    ArrayAdapter<String> miAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listin_telefonico);

        lview = (ListView) findViewById(R.id.listView);
        botonListar= (Button)findViewById(R.id.botonListar);
        botonModificar= (Button)findViewById(R.id.botonModificar);
        botonEliminar= (Button)findViewById(R.id.botonEliminar);
        botonNuevo= (Button)findViewById(R.id.botonAnyadir);
        botonGuardar= (Button)findViewById(R.id.buttonGuardar);
        campoNombre= (EditText)findViewById(R.id.nombre);
        campoTelefono= (EditText)findViewById(R.id.telefono);

        botonEliminar.setVisibility(View.INVISIBLE);
        botonModificar.setVisibility(View.INVISIBLE);
        botonGuardar.setVisibility(View.INVISIBLE);
        campoNombre.setVisibility(View.INVISIBLE);
        campoTelefono.setVisibility(View.INVISIBLE);

        //Abrimos la base de datos en modo escritura
        ContactosSQLiteHelper cliBDh = new ContactosSQLiteHelper(this, "DBContactos", null, 1);

        //Obtenemos referencia a la base de datos para poder modificarla.
        bd = cliBDh.getWritableDatabase();

        //En caso de abrir de forma correcta la base de datos
        if (bd!=null) {

           /* for (int cont=1; cont<=3; cont++) {
                //Creamos los datos
                int codigo = cont;
                String nombre = "Contacto" + cont;
                String telefono = cont + "XXXXXXX";

                bd.execSQL("INSERT INTO Contactos (codigo, nombre, telefono) " +
                        "VALUES (" + codigo + ", '" + nombre + "', '" + telefono + "')");
            }*/

            Cursor c = bd.rawQuery("SELECT codigo,nombre,telefono FROM Contactos",null);

            int contador=0;
            // String resultado[]=new String[c.getCount()];

            if (c.moveToFirst()) {

                //Recorremos el cursor hasta que no haya mÃ¡s registros
                do {
                    int codCli = c.getInt(0);
                    String nombreCli = c.getString(1);
                    String telefonoCli = c.getString(2);
                    resultado[contador]= "Codigo: "+codCli+"\nNombre: "+nombreCli+"\nTelefono: "+telefonoCli;
                    contador++;
                } while (c.moveToNext());
            }


            // Cargo la lista con el select
            lview = (ListView) findViewById(R.id.listView);
            miAdaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resultado);
            lview.setAdapter(miAdaptador);

            lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView arg0, View arg1, int position, long id) {

                    botonEliminar.setVisibility(View.VISIBLE);
                    botonModificar.setVisibility(View.VISIBLE);

                    eleccion = resultado[position];
                    showToast(eleccion);

                }
            });



            //Evento boton nuevo
            botonNuevo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    botonGuardar.setVisibility(View.VISIBLE);
                    campoNombre.setVisibility(View.VISIBLE);
                    campoTelefono.setVisibility(View.VISIBLE);
                }
            });

            //Evento boton modificar
            botonModificar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    botonGuardar.setVisibility(View.VISIBLE);
                    campoNombre.setVisibility(View.VISIBLE);
                    campoTelefono.setVisibility(View.VISIBLE);
                }
            });

            //Evento del boton guardar
            botonGuardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String nombrecon= campoNombre.getText().toString();
                    String telefonocon= campoTelefono.getText().toString();
                   //bd.execSQL("UPDATE Contactos SET nombre="+nombre+", telefono="+telefono+" WHERE nombre='Contacto1' ");
                   //bd.execSQL("DELETE FROM Clientes WHERE nombre='cli1' ");
                   //bd.execSQL("INSERT INTO Contactos (codigo, nombre, telefono) VALUES (" + numeracionCodigo + ", '" + nombrecon + "', '" + telefonocon + "')");

                    miAdaptador.notifyDataSetChanged();

                    numeracionCodigo++;
                }
            });


            //Evento del boton listar
            botonListar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });


            //Cerramos la base de datos
            bd.close();

        } //del if (bd!=null)

    }//onCreaate

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }


}//Class