package dao.entities;

import java.util.ArrayList;

public class RemitoPersistencia {
	
	private int nroRemito;
	private String estado;
	private ArrayList<MercaderiaPersistencia> mercaderias;
	
	public RemitoPersistencia(int nroRemito, String estado) {
		super();
		this.nroRemito = nroRemito;
		this.estado = estado;
		this.mercaderias = new ArrayList<MercaderiaPersistencia>();
	}

	public int getNroRemito() {
		return nroRemito;
	}

	public String getEstado() {
		return estado;
	}

	public ArrayList<MercaderiaPersistencia> getMercaderias() {
		return mercaderias;
	}

	public void setNroRemito(int nroRemito) {
		this.nroRemito = nroRemito;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void addMercaderia(MercaderiaPersistencia mercaderia) {
		this.mercaderias.add(mercaderia);
	}
	
	

}
