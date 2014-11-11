package dao.entities;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.w3c.dom.Document;

@Entity
@Table(name="MapaDeRuta")

public class MapaDeRutaPersistencia implements Observer{
	
	private int idMapa;
	private int numSucOrigen;
	private int numSucDestino;
	private float duracionHs;
	private float costo;
	private float distancia;
	private SucursalPersistencia sucursal;
//	private List<String> recorridoEnCoord;
//	private List<Document> mensajesDeControl;
	public MapaDeRutaPersistencia(int numSucOrigen, int numSucDestino, float duracionHs,
			float costo, float distancia) {
		super();
		this.numSucOrigen = numSucOrigen;
		this.numSucDestino = numSucDestino;
		this.duracionHs = duracionHs;
		this.costo = costo;
		this.distancia = distancia;
//		this.recorridoEnCoord = new ArrayList<String>();
//		this.mensajesDeControl = new ArrayList<Document>();
	}
	
	public MapaDeRutaPersistencia(){}
	
	@Id
	@GeneratedValue
	public int getIdMapa() {
		return idMapa;
	}



	public void setIdMapa(int idMapa) {
		this.idMapa = idMapa;
	}



	public int getNumSucOrigen() {
		return numSucOrigen;
	}
	public int getNumSucDestino() {
		return numSucDestino;
	}
	@ManyToOne
	@JoinColumn(name="numeroSucursal")
	public SucursalPersistencia getSucursal() {
		return sucursal;
	}
	public void setSucursal(SucursalPersistencia sucursal) {
		this.sucursal = sucursal;
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
//	public void addCoord(String coord) {
//		this.recorridoEnCoord.add(coord);
//	}
//	public ArrayList<String> getRecorridoEnCoord() {
//		return recorridoEnCoord;
//	}
	public void update(Observable o, Object arg) 
	{
//		mensajesDeControl.add((Document)arg);
		// TODO: Guardar tambien en coordenadas o reemplazarlo?
	}
	
	

}
