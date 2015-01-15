package com.example.mati.ejemplobasedatosini;

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


public class EjemploBaseDatosIni extends Activity {

    private Button botonModificar, botonEliminar, botonNuevo, botonListar, botonGuardar;
    private SQLiteDatabase bd;
    private EditText campoNombre, campoTelefono;
    private String eleccion;

    private ListView lview;
    private String resultado[]= new String[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_base_datos_ini);

        lview = (ListView) findViewById(R.id.listView);
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
        ClientesSQLiteHelper cliBDh = new ClientesSQLiteHelper(this, "DBClientes", null, 1);

        //Obtenemos referencia a la base de datos para poder modificarla.
         bd = cliBDh.getWritableDatabase();

        //En caso de abrir de forma correcta la base de datos
        if (bd!=null) {
            //Introducimos 3 clientes de ejemplo
            for (int cont=1; cont<=3; cont++) {
                //Creamos los datos
                int codigo = cont;
                String nombre = "Cliente" + cont;
                String telefono = cont + "XXXXXXX";

                //Introducimos los datos en la tabla Clientes
                bd.execSQL("INSERT INTO Clientes (codigo, nombre, telefono) " +
                        "VALUES (" + codigo + ", '" + nombre + "', '" + telefono + "')");
            }
/*
        		//Insertar un registro
        		bd.execSQL("INSERT INTO Clientes (nombre, telefono) VALUES ('cli1','11111') ");
        		//Actualizar un registro
        		bd.execSQL("UPDATE Clientes SET telefono='00000' WHERE nombre='cli1' ");
        		//Eliminar un registro
        		bd.execSQL("DELETE FROM Clientes WHERE nombre='cli1' ");

        		//Ejemplo de utilización del método insert()
        		//Creamos el registro que queremos insertar utilizando un objeto ContentValues
        		ContentValues nuevoRegistro = new ContentValues();
        		nuevoRegistro.put("nombre","cli10");
        		nuevoRegistro.put("telefono", "101010");
        		//Insertamos el registro en la base de datos
        		//El primer parámetro es el nombre de la tabla donde insertaremos.
        		//El segundo parámetro solo sirve en caso de introducir un registro vacio
        		//El tercer paráemtro es el objeto ContentValues que contiene el registro a insertar
        		bd.insert("Clientes", null, nuevoRegistro);

        		//Ejemplo de utilización del método update()
        		//Establecemos los campos-valores que vamos a actualizar
        		ContentValues valores = new ContentValues();
        		valores.put("telefono", "101010XX");
        		//Actualizamos el registro en la base de datos
        		//El tercer argumento es la condición del UPDATE tal como lo haríamos en la cláusula
        		//WHERE en una sentencia SQL normal.
        		//El cuarto argumento son partes variables de la sentencia SQL que aportamos en un
        		//vector de valores aparte
        		String[] args = new String[]{"cli1", "cli2"};
        		bd.update("Clientes", valores, "nombre=? OR nombre=?", args);

        		//Ejemplo de utilización del método delete()
        		//Eliminamos el registro del cliente 'cli2'
        		String[] args2 = new String[]{"cli2"};
        		bd.delete("Clientes", "nombre=?", args2);*/

        		//Ejemplo Select
        		//String[] args3 = new String[]{"cli1"};
        		Cursor c = bd.rawQuery("SELECT nombre,telefono FROM Clientes ", null);
               // String resultado[]= new String[c.getCount()];

                 int contador=0;

        	/*	//Ejemplo Select2
        		String[] campos = new String[] {"nombre", "telefono"};
        		String[] args4 = new String[] {"cli1"};
        		Cursor c = bd.query("Clientes", campos, "nombre=?", args4, null, null, null);
        		//Nos aseguramos de que exista al menos un registro*/
        		if (c.moveToFirst()) {
        			//Recorremos el cursor hasta que no haya más registros
        			do {
        				String nombreCli = c.getString(0);
        				String telefonoCli = c.getString(1);
                        resultado[contador]=  "nombre: "+nombreCli+"\nTelefono: "+telefonoCli;
                        contador++;
        			} while (c.moveToNext());
        		}

            // Cargo la lista con el select
            lview = (ListView) findViewById(R.id.listView);
            ArrayAdapter<String> miAdaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resultado);
            lview.setAdapter(miAdaptador);
            lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView arg0, View arg1, int position, long id) {

                    botonEliminar.setVisibility(View.VISIBLE);
                    botonModificar.setVisibility(View.VISIBLE);

                    eleccion = resultado[position];
                    showToast(eleccion);

                }
            });

            //Evento boton modificar
            botonModificar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    botonGuardar.setVisibility(View.VISIBLE);
                    campoNombre.setVisibility(View.VISIBLE);
                    campoTelefono.setVisibility(View.VISIBLE);

                   // bd.execSQL("UPDATE Clientes SET nombre='"+campoNombre.getText()+" , telefono='"+campoTelefono.getText()+"' WHERE nombre='Cliente1' ");
                }
            });

            //Evento del boton guardar
            botonGuardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nombre= campoNombre.getText().toString();
                    String telefono= campoTelefono.getText().toString();

                }
            });


            //Cerramos la base de datos
            bd.close();
        } //del if
    }
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
