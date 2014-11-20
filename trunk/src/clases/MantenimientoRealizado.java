package clases;

import java.sql.Date;

public class MantenimientoRealizado {
	
	private String descripcion;
	private float costo;
	private Date fecha;
	private int idMantenimiento;
	private float kilometrajeActual;
	private float kilometrosRealizadosDesdeUltimoControl;
	private String tipo;
	public MantenimientoRealizado(String descripcion, float costo, Date fecha,
			float kilometrajeActual,
			float kilometrosRealizadosDesdeUltimoControl, String tipo) {
		super();
		this.descripcion = descripcion;
		this.costo = costo;
		this.fecha = fecha;
		this.kilometrajeActual = kilometrajeActual;
		this.kilometrosRealizadosDesdeUltimoControl = kilometrosRealizadosDesdeUltimoControl;
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public float getCosto() {
		return costo;
	}
	public Date getFecha() {
		return fecha;
	}
	public float getKilometrajeActual() {
		return kilometrajeActual;
	}
	public float getKilometrosRealizadosDesdeUltimoControl() {
		return kilometrosRealizadosDesdeUltimoControl;
	}
	public String getTipo() {
		return tipo;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setKilometrajeActual(float kilometrajeActual) {
		this.kilometrajeActual = kilometrajeActual;
	}
	public void setKilometrosRealizadosDesdeUltimoControl(
			float kilometrosRealizadosDesdeUltimoControl) {
		this.kilometrosRealizadosDesdeUltimoControl = kilometrosRealizadosDesdeUltimoControl;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getIdMantenimiento() {
		return idMantenimiento;
	}
	public void setIdMantenimiento(int idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}

	
	

}
