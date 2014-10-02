package clases;

import java.util.ArrayList;

public class MapaDeRuta {
	
	private int numSucOrigen;
	private int numSucDestino;
	private float duracionHs;
	private float costo;
	private float distancia;
	private ArrayList<String> recorridoEnCoord;
	public MapaDeRuta(int numSucOrigen, int numSucDestino, float duracionHs,
			float costo, float distancia) {
		super();
		this.numSucOrigen = numSucOrigen;
		this.numSucDestino = numSucDestino;
		this.duracionHs = duracionHs;
		this.costo = costo;
		this.distancia = distancia;
		this.recorridoEnCoord = new ArrayList<String>();
	}
	public int getNumSucOrigen() {
		return numSucOrigen;
	}
	public int getNumSucDestino() {
		return numSucDestino;
	}
	public float getDuracionHs() {
		return duracionHs;
	}
	public float getCosto() {
		return costo;
	}
	public float getDistancia() {
		return distancia;
	}
	public ArrayList<String> getRecorridoEnCoord() {
		return recorridoEnCoord;
	}
	public void setNumSucOrigen(int numSucOrigen) {
		this.numSucOrigen = numSucOrigen;
	}
	public void setNumSucDestino(int numSucDestino) {
		this.numSucDestino = numSucDestino;
	}
	public void setDuracionHs(float duracionHs) {
		this.duracionHs = duracionHs;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}
	public void addCoord(String coord) {
		this.recorridoEnCoord.add(coord);
	}
	
	

}
