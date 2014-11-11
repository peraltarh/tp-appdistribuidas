package dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Area")
public class AreaPersistencia {
	
	private int idArea;
	private String descripcion;
	private float capacidadMaxima;
	private DepositoPersistencia deposito;
	public AreaPersistencia(String descripcion, float capacidadMaxima, DepositoPersistencia deposito) {
		this.deposito=deposito;
		this.descripcion = descripcion;
		this.capacidadMaxima = capacidadMaxima;
	}
	
	public AreaPersistencia(){}
	
	@Id
	@GeneratedValue
	public int getIdArea() {
		return idArea;
	}



	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}


@ManyToOne
@JoinColumn(name="idDeposito")
	public DepositoPersistencia getDeposito() {
		return deposito;
	}



	public void setDeposito(DepositoPersistencia deposito) {
		this.deposito = deposito;
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
