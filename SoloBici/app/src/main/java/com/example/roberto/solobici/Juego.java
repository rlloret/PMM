package com.example.roberto.solobici;

/**
 * Created by Roberto on 07/12/2014.
 */
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

public class Juego extends Activity {

    private VistaJuego vistaJuego;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego);
        vistaJuego = (VistaJuego) findViewById(R.id.VistaJuego);
        //Musica de fondo
        MediaPlayer miMediaPlayer = MediaPlayer.create(this, R.raw.audio);
        miMediaPlayer.start();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        Toast.makeText(this,"onResume", Toast.LENGTH_SHORT).show();
        vistaJuego.setPausa(false);
        super.onResume();
    }
    @Override
    protected void onPause() {
        Toast.makeText(this,"onPause", Toast.LENGTH_SHORT).show();
        vistaJuego.setPausa(true);
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        Toast.makeText(this,"onDestroy", Toast.LENGTH_SHORT).show();
        vistaJuego.setCorriendo(false);
        super.onDestroy();
    }
}
