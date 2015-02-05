package com.example.mati.examen;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


/**
 * Created by mati on 3/02/15.
 */
public class PantallaTres extends Activity{

    private  String variable;
    private int intAncho, intAlto, intRadio;
    public double area, area2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_tres);

        variable = getIntent().getStringExtra("dibujar");


        if (variable.equals("azafata")) {
            setContentView(new DibujoAzafata(this));

        }



    }


    class DibujoAzafata extends View {
        public DibujoAzafata(Context c) {
            super(c);
        }
        protected void onDraw(Canvas lienzo) {

            Paint miPincel = new Paint();
            Paint miPincel2 = new Paint();
            miPincel.setStyle(Paint.Style.FILL);

            miPincel.setColor(Color.rgb(235,191,70));
            lienzo.drawCircle(300,200,100,miPincel);//Cabeza

            miPincel2.setStyle(Paint.Style.STROKE);
            lienzo.drawCircle(255,170,10,miPincel2);//Ojos
            lienzo.drawCircle(335,170,10,miPincel2);
            lienzo.drawCircle(255,170,5,miPincel2);
            lienzo.drawCircle(335,170,5,miPincel2);


            lienzo.drawLine(290,300,150,600,miPincel);//Cuerpo
            lienzo.drawLine(310,300,550,600,miPincel);

            lienzo.drawLine(150,600,320,600,miPincel);
            lienzo.drawLine(380,600,550,600,miPincel);
            lienzo.drawLine(320,600,350,550,miPincel);
            lienzo.drawLine(380,600,350,550,miPincel);

            lienzo.drawCircle(320,470,8,miPincel2);//Ombligo

            lienzo.drawLine(400,600,500,730,miPincel);//Piernas
            lienzo.drawLine(300,600,200,730,miPincel);

            RectF rectPI = new RectF(120, 720, 220, 780);//Pies
            lienzo.drawOval(rectPI, miPincel);
            RectF rectPD = new RectF(490, 720, 590, 780);
            lienzo.drawOval(rectPD, miPincel);

            lienzo.drawLine(235,400,100,300,miPincel);//Brazos
            lienzo.drawLine(375,370,500,300,miPincel);

            lienzo.drawLine(190,500,475,500,miPincel2);//Pantalon

            RectF rectF2 = new RectF(250, 200, 350, 260);//Boca
            lienzo.drawArc(rectF2, 0, 180, false, miPincel2);

            RectF pelo = new RectF(250, 70, 350, 120);//Pelo
            lienzo.drawArc(pelo, 90, 180, false, miPincel2);

            lienzo.drawCircle(85,285,20,miPincel);//Manos
            lienzo.drawCircle(585,285,20,miPincel);



        }
    }


    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}

