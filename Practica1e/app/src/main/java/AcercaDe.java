import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mati.practica1e.R;

public class AcercaDe extends Activity{
	Button botonA;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acerca_de);
		final TextView textView1 = (TextView)findViewById(R.id.textViewAcercade);
		botonA=(Button)findViewById(R.id.botonAtras);
		textView1.setTextSize(0x00000001, 20);
		
		botonA.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
				
			}
		});
		
	}

}
