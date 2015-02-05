package com.example.mati.examen;

/**
 * Created by mati on 29/01/15.
 */
public class Zona {

    protected String zona;
    protected String region;
    protected int precio;
    private int imagen;

    public Zona(String zon,String reg,int pre, int i) {

        zona = zon;
        region = reg;
        precio = pre;
        imagen = i;
    }
    public String getZona() {
        return zona;
    }
    public String getRegion() {
        return region;
    }
    public int getPrecio() {
        return precio;
    }
    public int getImagen() {
        return imagen;
    }

    public String toString(){

        String cad="";
        cad+=zona+"\n"+region+ "\n"+ precio+"E";
        return(cad);
    }
}

