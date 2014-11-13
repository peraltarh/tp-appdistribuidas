package dao.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Deposito")

public class DepositoPersistencia {
	private int idDeposito;
	private float cantidadMax;
	private String encargado;
	private List<AreaPersistencia> areas;
	private List<MercaderiaPersistencia> mercaderias;
	private SucursalPersistencia suc;
	

	public DepositoPersistencia(float cantidadMax, String encargado, SucursalPersistencia sucursal) {
		this.cantidadMax = cantidadMax;
		this.encargado = encargado;
		this.areas = new ArrayList<AreaPersistencia>();
		this.mercaderias = new ArrayList<MercaderiaPersistencia>();
		this.suc=sucursal;
	}

	public DepositoPersistencia(){}
	
	@Id
	@GeneratedValue
	public int getIdDeposito() {
		return idDeposito;
	}


	public void setIdDeposito(int idDeposito) {
		this.idDeposito = idDeposito;
	}
@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="idDeposito")
	public List<AreaPersistencia> getAreas() {
		return areas;
	}

	public void setAreas(ArrayList<AreaPersistencia> areas) {
		this.areas = areas;
	}


@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="idDeposito")
	public List<MercaderiaPersistencia> getMercaderias() {
		return mercaderias;
	}

	public void setMercaderias(ArrayList<MercaderiaPersistencia> mercaderias) {
		this.mercaderias = mercaderias;
	}



	public float getCantidadMax() {
		return cantidadMax;
	}

	public String getEncargado() {
		return encargado;
	}

	public void setCantidadMax(float cantidadMax) {
		this.cantidadMax = cantidadMax;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public void addAreas(AreaPersistencia area) {
		this.areas.add(area);
	}

	public void addMercaderia(MercaderiaPersistencia mercaderia) {
		this.mercaderias.add(mercaderia);
	}

@ManyToOne
@JoinColumn(name="numeroSucursal")
	public SucursalPersistencia getSuc() {
		return suc;
	}

	public void setSuc(SucursalPersistencia suc) {
		this.suc = suc;
	}

	public void setAreas(List<AreaPersistencia> areas) {
		this.areas = areas;
	}

	public void setMercaderias(List<MercaderiaPersistencia> mercaderias) {
		this.mercaderias = mercaderias;
	}
	
	

}
