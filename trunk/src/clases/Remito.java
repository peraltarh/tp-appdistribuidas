package clases;

import java.util.ArrayList;

public class Remito {
	
	private int nroRemito;
	private String estado;
	private ArrayList<Mercaderia> mercaderias;
	
	public Remito(int nroRemito, String estado) {
		super();
		this.nroRemito = nroRemito;
		this.estado = estado;
		this.mercaderias = new ArrayList<Mercaderia>();
	}

	public Remito() {}

	public int getNroRemito() {
		return nroRemito;
	}

	public String getEstado() {
		return estado;
	}

	public ArrayList<Mercaderia> getMercaderias() {
		return mercaderias;
	}

	public void setNroRemito(int nroRemito) {
		this.nroRemito = nroRemito;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void addMercaderia(Mercaderia mercaderia) {
		this.mercaderias.add(mercaderia);
	}
	
	

}
