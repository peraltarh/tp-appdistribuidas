package dao.entities;

public class AreaPersistencia {
	
	private String descripcion;
	private float capacidadMaxima;
	public AreaPersistencia(String descripcion, float capacidadMaxima) {
		super();
		this.descripcion = descripcion;
		this.capacidadMaxima = capacidadMaxima;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public float getCapacidadMaxima() {
		return capacidadMaxima;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setCapacidadMaxima(float capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}
	
	
	
	

}
