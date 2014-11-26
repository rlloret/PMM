import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mati.practica1e.R;

public class CambioDinero extends Activity {
	Bundle bundle;
	int b500,b200,b100,b50,b20,b10,b5,m1,m2;
	String cambioFinal="";
	double dinero;
	int toIntDinero;


	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.cambio_dinero);
	bundle= getIntent().getExtras();
	
	dinero= bundle.getDouble("PRECIO");
	toIntDinero =(int)dinero;
	TextView tCambio;
	
	tCambio=(TextView)findViewById(R.id.textV_cambio);
	
	calculoCambio(toIntDinero);
	tCambio.setText(cambioFinal);
	
	
}
public void calculoCambio(int dinero){
	if(dinero>=500){
		b500 = dinero/500;
		dinero %= 500;
		cambioFinal += "Billetes de 500 -->"+b500;
	}
	if(dinero>=200){
		b200 = dinero/200;
		dinero %= 200;
		cambioFinal += "\nBilletes de 200 -->"+b200;
	}
	if(dinero>=100){
		b100 = dinero/100;
		dinero %= 100;
		cambioFinal += "\nBilletes de 100 -->"+b100;
	}
	if(dinero>=50){
		b50 = dinero/50;
		dinero %= 50;
		cambioFinal += "\nBilletes de 50 -->"+b50;
	}
	if(dinero>=20){
		b20 = dinero/20;
		dinero %= 20;
		cambioFinal += "\nBilletes de 20 -->"+b20;
	}
	if(dinero>=10){
		b10 = dinero/10;
		dinero %= 10;
		cambioFinal += "\nBilletes de 10 -->"+b10;
	}
	if(dinero>=5){
		b5 = dinero/5;
		dinero %= 5;
		cambioFinal += "\nBilletes de 5 -->"+b5;
	}
	if(dinero>=2){
		m2 = dinero/2;
		dinero %= 2;
		cambioFinal += "\nMonedas de 2 -->"+m2;
	}
	if(dinero>=1){
		m1 = dinero/1;
		dinero %= 1;
		cambioFinal += "\nMonedas de 1 -->"+m1;
	}
}
}
