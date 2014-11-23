package dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import clases.PlanDeMantenimiento;

@Entity
@Table(name="PlanDeMantenimiento")

public class PlanDeMantenimientoPersistencia {

	private int idPlan;
	private float cantKilometros;
	private String tipo;
	private String controlEspecial;
	private VehiculoPersistencia vehiculo;
	public PlanDeMantenimientoPersistencia(float cantKilometros, String tipo, String controlEspecial, VehiculoPersistencia vehiculo) {
		this.cantKilometros = cantKilometros;
		this.tipo = tipo;
		this.controlEspecial = controlEspecial;
		this.vehiculo=vehiculo;
	}

	public PlanDeMantenimientoPersistencia(){}

	@Id
	@GeneratedValue
	public int getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}


	@ManyToOne
	@JoinColumn(name="nroChasis")
	public VehiculoPersistencia getVehiculo() {
		return vehiculo;
	}



	public void setVehiculo(VehiculoPersistencia vehiculo) {
		this.vehiculo = vehiculo;
	}



	public float getCantKilometros() {
		return cantKilometros;
	}
	public String getTipo() {
		return tipo;
	}
	public String getControlEspecial() {
		return controlEspecial;
	}
	public void setCantKilometros(float cantKilometros) {
		this.cantKilometros = cantKilometros;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setControlEspecial(String controlEspecial) {
		this.controlEspecial = controlEspecial;
	}

	public PlanDeMantenimiento toNegocio() 
	{
		PlanDeMantenimiento pdm = new PlanDeMantenimiento();
		pdm.setCantKilometros(cantKilometros);
		pdm.setControlEspecial(controlEspecial);
		pdm.setIdPlan(idPlan);
		pdm.setTipo(tipo);
		return pdm;
	}



}
