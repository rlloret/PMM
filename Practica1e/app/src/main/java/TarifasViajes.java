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
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mati.practica1e.R;

public class TarifasViajes extends Activity {
	Spinner spinner;
	RadioGroup rg;
	RadioButton rb1,rb2;
	CheckBox check1,check2;
	EditText ed_txt;
	Button res;
	
	Viajes viaje;
	Boolean urgente;
	int peso;
	String  regalo;
	
	Viajes[] viajes={
			new Viajes("ZONA A","Asia y Oceania",30),
			new Viajes("ZONA B","America y Africa",20),
			new Viajes("ZONA C","Europa",10)
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tarifas_viaje);
		
		spinner=(Spinner)findViewById(R.id.spinner1);
		rg=(RadioGroup)findViewById(R.id.radioGroup1);
		rb1=(RadioButton)findViewById(R.id.radio0);
		rb2=(RadioButton)findViewById(R.id.radio1);
		check1=(CheckBox)findViewById(R.id.checkBox1);
		check2=(CheckBox)findViewById(R.id.checkBox2);
		ed_txt=(EditText)findViewById(R.id.editText1);
		res=(Button)findViewById(R.id.buttonCambio);
		
		ed_txt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ed_txt.setText("");
			}
		});
		
		//creamos el adaptador y rellenamos el spinner
		AdaptadorViajes adaptador =new AdaptadorViajes(this);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adaptador);
		
		//creamos el listener del spinner
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				viaje=viajes[arg2];
				
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		//LISTENER DE LOS RADIOBUTTONS
		
		rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				
				switch(checkedId){
					case R.id.radio0: urgente=false;
						break;
					case R.id.radio1 :urgente = true;
						break;
					default:
				
				}
				
			}
		});
		//llamada al listerner de los check
		regalo = regalo();
		
		//boton resultado
		res.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				try{
					peso= Integer.parseInt(ed_txt.getText().toString());
				}catch(Exception e){
					peso=0;
				}if(peso ==0 || peso/peso != 1){
					Toast.makeText(TarifasViajes.this, "Debes introducir un peso. ", Toast.LENGTH_SHORT).show();
				}else{
					Intent i = new Intent(TarifasViajes.this,Resultado.class);
					i.putExtra("DESTINO", viaje);
					i.putExtra("URGENTE", urgente);
					i.putExtra("PESO", peso);
					i.putExtra("REGALO",regalo());
					startActivity(i);
				}
				
			}
		});
		
		
		
	}
	
	public String regalo(){
		String reg="";
		if(check1.isChecked()){
			reg +="Con caja de regalo. ";
		}else if(check2.isChecked()){
			reg+= "Con dedicatoria.";
		}else if(check1.isChecked() && check2.isChecked()){
			reg += "Con caja de regalo y dedicatoria";
		}
		return reg;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	

	
	class AdaptadorViajes extends ArrayAdapter{
		Activity context;
		//clase intwena para crear el adaptador personalizado para nuestro spinner
		public AdaptadorViajes(Activity context){
			super(context,R.layout.spinner_compuesto,viajes);
			this.context=context;
		}
		
		public View getDropDownView(int posicion ,View convertView,ViewGroup parent){
			return getView(posicion,convertView,parent);
		}
		
		public View getView(int posicion ,View convertView,ViewGroup parent){
			LayoutInflater inflater = context.getLayoutInflater();
			View item =inflater.inflate(R.layout.spinner_compuesto, null);
			
			TextView res_zona= (TextView) item.findViewById(R.id.textView_zona);
			res_zona.setText(viajes[posicion].getZona());
			
			TextView res_continente= (TextView) item.findViewById(R.id.textView_destino);
			res_continente.setText(viajes[posicion].getContinente());
			
			TextView res_precio= (TextView) item.findViewById(R.id.textView_precio);
			res_precio.setText(""+viajes[posicion].getPrecio());
			
			setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			
			return(item);
		}
		
	}
}


