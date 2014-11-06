package dao.entities;

public class CarrierPersistencia {
	
	private String origen;
	private String destino;
	private float costo;
	public CarrierPersistencia(String origen, String destino, float costo) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.costo = costo;
	}
	public String getOrigen() {
		return origen;
	}
	public String getDestino() {
		return destino;
	}
	public float getCosto() {
		return costo;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	
	
	

}
