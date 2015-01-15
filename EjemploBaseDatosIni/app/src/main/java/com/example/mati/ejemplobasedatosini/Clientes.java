package com.example.mati.ejemplobasedatosini;

/**
 * Created by mati on 13/01/15.
 */
public class Clientes {

    private int codigo;
    private String nombre;
    private int telefono;


    public Clientes(int codigo, String nombre, int telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
