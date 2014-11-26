import java.io.Serializable;

public class Viajes implements Serializable{
	
	private String zona;
	private String continente;
	private int precio;
	
	public Viajes(String zona , String continente , int precio){
		this.zona=zona;
		this.continente=continente;
		this.precio=precio;
		
	}
	
	public String getZona(){
		return zona;
	}
	
	public String getContinente(){
		return continente;
	}
	
	public int getPrecio(){
		return precio;
	}
	/*
	public void setZona(String n_zona){
		zona=n_zona;
	}
	public void setCont(String n_cont){
		continente=n_cont;
	}
	public void setPrecio(int n_precio){
		precio=n_precio;
	}*/
	
	

}
