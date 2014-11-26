package com.example.mati.dibujoinical;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class DibujoInical extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));
    }

    class MiDibujo extends View {
        public MiDibujo(Context c){

            super(c);
        }

        protected void onDraw(Canvas lienzo){

            lienzo.drawColor(Color.GRAY);

            int maxwidth=lienzo.getWidth();
            int maxheigth=lienzo.getHeight();
            int maxheigth2=maxheigth/2;

            Paint miPincelRojo= new Paint();
            Paint miPincelAmarillo= new Paint();
            Paint miPincelAzul= new Paint();
            Paint miPincelVerde= new Paint();

            Paint pincelCirculo= new Paint();
            pincelCirculo.setColor(Color.parseColor("#F6CEF5"));
            pincelCirculo.setStrokeWidth(10);

            miPincelRojo.setColor(Color.RED);
            miPincelAzul.setColor(Color.BLUE);
            miPincelVerde.setColor(Color.GREEN);
            miPincelAmarillo.setColor(Color.YELLOW);

            miPincelRojo.setStyle(Paint.Style.STROKE);
            miPincelAzul.setStyle(Paint.Style.STROKE);
            miPincelVerde.setStyle(Paint.Style.STROKE);
            miPincelAmarillo.setStyle(Paint.Style.STROKE);
            pincelCirculo.setStyle(Paint.Style.STROKE);


            lienzo.drawCircle(maxwidth/2,maxheigth2/2,100,pincelCirculo);

            lienzo.drawRect(0,0,20,20,miPincelAzul);
            lienzo.drawRect(maxwidth-20,0,maxwidth-1,20, miPincelVerde);

            lienzo.drawRect(0,maxheigth2-20,20,maxheigth2, miPincelRojo);
            lienzo.drawRect(maxwidth-20,maxheigth2-20,maxwidth-1,maxheigth2, miPincelAmarillo);




            //miPincelVerde.setTextSize(100);
          //  lienzo.drawText("MI CIRCULO",50,50,miPincel);


            //for(int i=0;i<50;i++){

              //  lienzo.drawCircle(100+(i*1),100+(i*2),30+(i*3),miPincel);

           // }

        }



    }

}
