package dao.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import clases.MantenimientoRealizado;

@Entity
@Table(name="MantenimientoRealizado")

public class MantenimientoRealizadoPersistencia {
	
	private int idMantenimiento;
	private String descripcion;
	private float costo;
	private Date fecha;
	private float kilometrajeActual;
	private float kilometrosRealizadosDesdeUltimoControl;
	private String tipo;
	private VehiculoPersistencia vehiculo;
	public MantenimientoRealizadoPersistencia(String descripcion, float costo, Date fecha,
			float kilometrajeActual,
			float kilometrosRealizadosDesdeUltimoControl, String tipo, VehiculoPersistencia vehiculo) {
		super();
		this.descripcion = descripcion;
		this.costo = costo;
		this.fecha = fecha;
		this.kilometrajeActual = kilometrajeActual;
		this.kilometrosRealizadosDesdeUltimoControl = kilometrosRealizadosDesdeUltimoControl;
		this.tipo = tipo;
	}
	
	public MantenimientoRealizadoPersistencia(){}
	
	@Id
	@GeneratedValue	
	public int getIdMantenimiento() {
		return idMantenimiento;
	}

	public void setIdMantenimiento(int idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}



@ManyToOne
@JoinColumn(name="patente")
	public VehiculoPersistencia getVehiculo() {
		return vehiculo;
	}




	public void setVehiculo(VehiculoPersistencia vehiculo) {
		this.vehiculo = vehiculo;
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

	public MantenimientoRealizado toNegocio() 
	{
		MantenimientoRealizado mr = new MantenimientoRealizado();
		mr.setCosto(costo);
		mr.setDescripcion(descripcion);
		mr.setFecha(fecha);
		mr.setIdMantenimiento(idMantenimiento);
		mr.setKilometrajeActual(kilometrajeActual);
		mr.setKilometrosRealizadosDesdeUltimoControl(kilometrosRealizadosDesdeUltimoControl);
		mr.setTipo(tipo);
		return mr;
	}
	
	

}
