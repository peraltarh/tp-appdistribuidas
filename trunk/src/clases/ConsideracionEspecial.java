package clases;

import java.util.ArrayList;

public class ConsideracionEspecial {
	
	private boolean entregaInmediata;
	private boolean requiereAvioneta;
	private boolean autorizacionAvioneta;
	private boolean requiereComionExterno;
	private float costoExtra;
	private ArrayList<Carrier> carriers;
	private ArrayList<VehiculoExterno> vExternos;
	
	
	public ConsideracionEspecial(boolean entregaInmediata,
			boolean requiereAvioneta, boolean autorizacionAvioneta,
			boolean requiereComionExterno, float costoExtra
			) {
		super();
		this.entregaInmediata = entregaInmediata;
		this.requiereAvioneta = requiereAvioneta;
		this.autorizacionAvioneta = autorizacionAvioneta;
		this.requiereComionExterno = requiereComionExterno;
		this.costoExtra = costoExtra;
		this.carriers = new ArrayList<Carrier>();
		this.vExternos = new ArrayList<VehiculoExterno>();
	}


	public boolean isEntregaInmediata() {
		return entregaInmediata;
	}


	public boolean isRequiereAvioneta() {
		return requiereAvioneta;
	}


	public boolean isAutorizacionAvioneta() {
		return autorizacionAvioneta;
	}


	public boolean isRequiereComionExterno() {
		return requiereComionExterno;
	}


	public float getCostoExtra() {
		return costoExtra;
	}


	public ArrayList<Carrier> getCarriers() {
		return carriers;
	}


	public ArrayList<VehiculoExterno> getvExternos() {
		return vExternos;
	}


	public void setEntregaInmediata(boolean entregaInmediata) {
		this.entregaInmediata = entregaInmediata;
	}


	public void setRequiereAvioneta(boolean requiereAvioneta) {
		this.requiereAvioneta = requiereAvioneta;
	}


	public void setAutorizacionAvioneta(boolean autorizacionAvioneta) {
		this.autorizacionAvioneta = autorizacionAvioneta;
	}


	public void setRequiereComionExterno(boolean requiereComionExterno) {
		this.requiereComionExterno = requiereComionExterno;
	}


	public void setCostoExtra(float costoExtra) {
		this.costoExtra = costoExtra;
	}


	public void addCarrier(Carrier carrier) {
		this.carriers.add(carrier);
	}


	public void addvExterno(VehiculoExterno vehiculo) {
		this.vExternos.add(vehiculo);
	}
	
	
	

}
