package clases;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import org.w3c.dom.Document;

public class MapaDeRuta implements Observer{
	
	private int numSucOrigen;
	private int numSucDestino;
	private float duracionHs;
	private float costo;
	private float distancia;
	private ArrayList<String> recorridoEnCoord;
	private ArrayList<Document> mensajesDeControl;
	public MapaDeRuta(int numSucOrigen, int numSucDestino, float duracionHs,
			float costo, float distancia) {
		super();
		this.numSucOrigen = numSucOrigen;
		this.numSucDestino = numSucDestino;
		this.duracionHs = duracionHs;
		this.costo = costo;
		this.distancia = distancia;
		this.recorridoEnCoord = new ArrayList<String>();
		this.mensajesDeControl = new ArrayList<Document>();
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
	@Override
	public void update(Observable o, Object arg) 
	{
		mensajesDeControl.add((Document)arg);
		// TODO: Guardar tambien en coordenadas o reemplazarlo?
	}
	
	

}
