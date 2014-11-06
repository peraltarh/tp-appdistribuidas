package dao.entities;

public class VehiculoExternoPersistencia {
	
	private String tipo;
	private String identificacion;
	private float capacidadCarga;
	public VehiculoExternoPersistencia(String tipo, String identificacion,
			float capacidadCarga) {
		super();
		this.tipo = tipo;
		this.identificacion = identificacion;
		this.capacidadCarga = capacidadCarga;
	}
	public String getTipo() {
		return tipo;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public float getCapacidadCarga() {
		return capacidadCarga;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public void setCapacidadCarga(float capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}
	
	

}
