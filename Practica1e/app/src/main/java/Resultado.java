import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mati.practica1e.R;

public class Resultado extends Activity {
	
	Bundle miBundle;
	TextView tZona, tTarifa, tPrecio, tPeso, tRegalo;
	
	ImageView img;
	
	String reg,urg;
	Boolean urgente;
	double precio; 
	int peso;
	Button botonCambio;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultado);
		
		tZona=(TextView)findViewById(R.id.textViewRes2);
		tTarifa=(TextView)findViewById(R.id.textViewRes3);
		tPrecio=(TextView)findViewById(R.id.textViewRes4);
		tPeso=(TextView)findViewById(R.id.textViewRes5);
		tRegalo=(TextView)findViewById(R.id.textViewRes6);
		img=(ImageView)findViewById(R.id.imageView1);
		botonCambio=(Button)findViewById(R.id.buttonCambio);
		
		miBundle=getIntent().getExtras();
		Viajes viajes = (Viajes) miBundle.getSerializable("DESTINO");
		peso = miBundle.getInt("PESO");
		urgente =miBundle.getBoolean("URGENTE");
		reg=miBundle.getString("REGALO");
		precio=viajes.getPrecio();
		
		//calcular el peso del paquete y sumarle la cantidad correspondiente

		if (peso <= 5){
			precio = precio+peso;
		}
		if (peso > 5 && peso <= 10){
			precio = precio+peso*1.5;
		}
		if (peso >10) {
			precio = precio+peso*2;
		}
		
		//calcular si el pedido es urgente y sumarle la cantidad correspondiente
				if (urgente) {
					urg = "urgente";
					precio = 	precio + precio*0.30;
				}else {
					urg = "normal";
					precio = precio;
				}		
	
	tZona.setText(viajes.getZona()+"   "+viajes.getContinente());
	tTarifa.setText("Tarifa: "+urg);
	
	tPeso.setText("Peso: "+peso+"kg");
	tRegalo.setText("Obsequio: "+reg);
	tPrecio.setText("Precio: "+precio+"�");
	
	
	if (viajes.getZona().equalsIgnoreCase("ZONA A")){
		
		img.setImageResource(R.drawable.mundo2);
	}else {
		if (viajes.getZona().equalsIgnoreCase("ZONA B")){
			img.setImageResource(R.drawable.mundo2);
		}else {
			if (viajes.getZona().equalsIgnoreCase("ZONA C")) img.setImageResource(R.drawable.mundo2); 
		}

	
	
	}
	botonCambio.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(Resultado.this,CambioDinero.class);
			i.putExtra("PRECIO", precio);
			startActivity(i);
			finish();
		}
	});
	}
}
	
