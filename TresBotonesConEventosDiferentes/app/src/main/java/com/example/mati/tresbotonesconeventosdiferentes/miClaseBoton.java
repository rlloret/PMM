package com.example.mati.tresbotonesconeventosdiferentes;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


private Button botonUno;



public class miClaseBoton extends Button implements View.OnClickListener {
    Context ctx=null;
    public botonUno(Context context) {
        super(context);
        ctx=context;
        this.setOnClickListener(this); //recoger evento
    }
    //cuando se cree desde un recurso XML
    public botonUno(Context context, AttributeSet attr){
        super(context,attr);
        ctx=context;
        this.setOnClickListener(this);
    }
    //cuando se cree desde un recurso XML
    public botonUno(Context context, AttributeSet attr, int defaultStyles){
        super(context, attr, defaultStyles);
        ctx=context;
        this.setOnClickListener(this);
    }
}
    @Override
    public void onClick(View v){
        Toast.makeText(ctx, "Pulsado boton con clase", Toast.LENGTH_SHORT).show();
    }