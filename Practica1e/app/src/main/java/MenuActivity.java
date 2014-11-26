import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mati.practica1e.R;

public class MenuActivity extends Activity {
	
	Intent i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	switch (item.getItemId()) {
    
    		case R.id.tarifas_viaje:
    			i = new Intent(MenuActivity.this, TarifasViajes.class);
    			startActivity(i);
    		return true;
    		
    		case R.id.dibujar:
    			i = new Intent(MenuActivity.this, PersonaActivity.class);
    			startActivity(i);
    		return true;
    		
    	case R.id.acerca_de:
    			i = new Intent(MenuActivity.this, AcercaDe.class);
    			startActivity(i);
    		return true;
    		
    
    		
    	default:
            return super.onOptionsItemSelected(item);
    	}
    	
    }
   

}
