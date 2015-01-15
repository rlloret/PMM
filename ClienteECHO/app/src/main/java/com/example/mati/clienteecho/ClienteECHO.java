package com.example.mati.clienteecho;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ClienteECHO extends Activity {
    private TextView salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_echo);
        salida=(TextView) findViewById(R.id.TextView01);
        peticionCliente();
    }

    private void peticionCliente(){
        String ip ="192.0.0.1";
        int puerto = 5000;

        try{
            Socket socket = new Socket(ip,puerto);

            //Para leer el socket
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            BufferedReader entrada2 = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            //PAra escribir en el socket
            PrintWriter salida = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            //Enviar al socket
            log("Enviamos una cadena al servidor de echo ....");
            salida.println("Holaaaaaaaaaaaaaaa");
            //Mostramos en lo que estamos recibiendo
            log("Recibimos del servidor la cadena. " + entrada2.readLine());
            socket.close();
        }catch(Exception e){
            log("Error: " + e.toString());
        }
    }


    private void log(String cadena){
        salida.append(cadena + "\n");
    }

}
