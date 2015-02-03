package com.example.mati.examen;

/**
 * Created by mati on 29/01/15.
 */
public class Zona {

    protected String zona;
    protected String region;
    protected int precio;

    public Zona(String zon,String reg,int pre) {

        zona = zon;
        region = reg;
        precio = pre;
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

    public String toString(){

        String cad="";
        cad+=zona+" "+region+ " "+ precio+"\n";
        return(cad);
    }
}

