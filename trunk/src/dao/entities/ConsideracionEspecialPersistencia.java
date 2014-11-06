package dao.entities;

import java.util.ArrayList;

public class ConsideracionEspecialPersistencia {
	
	private boolean entregaInmediata;
	private boolean requiereAvioneta;
	private boolean autorizacionAvioneta;
	private boolean requiereCamionExterno;
	private float costoExtra;
	private ArrayList<CarrierPersistencia> carriers;
	private ArrayList<VehiculoExternoPersistencia> vExternos;
	
	
	public ConsideracionEspecialPersistencia(boolean entregaInmediata,
			boolean requiereAvioneta, boolean autorizacionAvioneta,
			boolean requiereCamionExterno, float costoExtra
			) {
		super();
		this.entregaInmediata = entregaInmediata;
		this.requiereAvioneta = requiereAvioneta;
		this.autorizacionAvioneta = autorizacionAvioneta;
		this.requiereCamionExterno = requiereCamionExterno;
		this.costoExtra = costoExtra;
		this.carriers = new ArrayList<CarrierPersistencia>();
		this.vExternos = new ArrayList<VehiculoExternoPersistencia>();
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


	public boolean isRequiereCamionExterno() {
		return requiereCamionExterno;
	}


	public float getCostoExtra() {
		return costoExtra;
	}


	public ArrayList<CarrierPersistencia> getCarriers() {
		return carriers;
	}


	public ArrayList<VehiculoExternoPersistencia> getvExternos() {
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


	public void setRequiereCamionExterno(boolean requiereCamionExterno) {
		this.requiereCamionExterno = requiereCamionExterno;
	}


	public void setCostoExtra(float costoExtra) {
		this.costoExtra = costoExtra;
	}


	public void addCarrier(CarrierPersistencia carrier) {
		this.carriers.add(carrier);
	}


	public void addvExterno(VehiculoExternoPersistencia vehiculo) {
		this.vExternos.add(vehiculo);
	}
	
	
	

}
