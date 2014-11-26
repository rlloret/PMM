import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path.FillType;
import android.graphics.Path;
import android.view.Menu;
import android.view.View;

import com.example.mati.practica1e.R;

public class PersonaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new DibujoPersonaView(this));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	@SuppressLint("DrawAllocation")
	public class DibujoPersonaView extends View{

		public DibujoPersonaView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}
		
		Canvas canvas;
		Paint pincel;
		

		protected void onDraw(Canvas canvas) {
			
			//cabeza
			final Paint pincel1 = new Paint();
			pincel1.setColor(Color.BLACK);
			pincel1.setStrokeWidth(5);
			pincel1.setStyle(Style.FILL);
			canvas.drawCircle(155, 120, 35, pincel1);
			
			//gorro
			pincel1.setColor(Color.RED);
			pincel1.setAntiAlias(true);
			Path path=new Path();
			path.setFillType(FillType.EVEN_ODD);
			path.moveTo(205, 120);
			path.lineTo(155, 20);
			path.lineTo(105, 120);
			
			path.close();
			canvas.drawPath(path, pincel1);
			
			//cuerpo
			
			pincel1.setColor(Color.RED);
			pincel1.setAntiAlias(true);
			Path path3=new Path();
			path.setFillType(FillType.EVEN_ODD);
			path.moveTo(100, 220);
			path.lineTo(155, 143);
			path.lineTo(210, 220);
			
			path.close();
			canvas.drawPath(path, pincel1);
			
			//barba
			final Paint pincel2 = new Paint();
			
			pincel2.setColor(Color.WHITE);
			pincel2.setAntiAlias(true);
			Path path2 = new Path();
			path2.setFillType(FillType.EVEN_ODD);
			path2.moveTo(180, 140);
			path2.lineTo(155, 180);
			path2.lineTo(130, 140);
			
			path2.close();
			canvas.drawPath(path2, pincel2);
			
			//pantalon
			Paint pincel3 = new Paint();
			pincel3.setColor(Color.BLUE);
			pincel3.setStrokeWidth(10);
			pincel3.setStyle(Style.FILL);

			//drawRect(esquina izquierda,esquina superior,esquina derecha, esquina inferior, pincel
			canvas.drawRect(110,220,200,250, pincel3);

			
			//extremidades
			Paint pincel4 = new Paint();
			pincel1.setColor(Color.RED);
			pincel1.setStrokeWidth(3);
			pincel1.setStyle(Style.STROKE);
			pincel2.setColor(Color.RED);
			pincel2.setStrokeWidth(3);
			pincel2.setStyle(Style.STROKE);
			pincel3.setColor(Color.BLACK);
			pincel3.setStrokeWidth(1);
			pincel3.setStyle(Style.STROKE);
;

			
			canvas.drawLine(167, 162, 210, 200,pincel1);
			canvas.drawLine(143, 160, 100, 200,pincel2);
			//linea pantalon
			canvas.drawLine(155, 220, 155, 250,pincel3);
			
			//PIES
			pincel1.setColor(Color.BLACK);
			pincel1.setStrokeWidth(5);
			pincel1.setStyle(Style.FILL);
			canvas.drawCircle(140, 250, 5, pincel1);
			canvas.drawCircle(175, 250, 5, pincel1);
			
			

		}
	
		
	}
	
	

}
