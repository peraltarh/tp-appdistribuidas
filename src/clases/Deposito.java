package clases;

import java.util.ArrayList;

public class Deposito {
	
	private float cantidadMax;
	private String encargado;
	private ArrayList<Area> areas;
	private ArrayList<Mercaderia> mercaderias;
	private int idDeposito;
	
	public Deposito(float cantidadMax, String encargado) {
		super();
		this.cantidadMax = cantidadMax;
		this.encargado = encargado;
		this.areas = new ArrayList<Area>();
		this.mercaderias = new ArrayList<Mercaderia>();
	}

	public float getCantidadMax() {
		return cantidadMax;
	}

	public String getEncargado() {
		return encargado;
	}

	public ArrayList<Area> getAreas() {
		return areas;
	}

	public ArrayList<Mercaderia> getMercaderias() {
		return mercaderias;
	}

	public void setCantidadMax(float cantidadMax) {
		this.cantidadMax = cantidadMax;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public void addAreas(Area area) {
		this.areas.add(area);
	}

	public void addMercaderia(Mercaderia mercaderia) {
		this.mercaderias.add(mercaderia);
	}

	public int getIdDeposito() {
		return idDeposito;
	}

	public void setIdDeposito(int idDeposito) {
		this.idDeposito = idDeposito;
	}
	


}
