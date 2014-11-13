package com.example.mati.primerproyecto;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by mati on 16/10/14.
 */
public class ClaseGrid extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
}


    public void onCerrarClick (View v){

    finish();

    }
}