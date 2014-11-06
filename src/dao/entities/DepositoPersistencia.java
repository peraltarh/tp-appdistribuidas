package dao.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Deposito")

public class DepositoPersistencia {
	private int idDeposito;
	private float cantidadMax;
	private String encargado;
//	private List<AreaPersistencia> areas;
//	private List<MercaderiaPersistencia> mercaderias;
	private SucursalPersistencia suc;
	

	public DepositoPersistencia(float cantidadMax, String encargado, SucursalPersistencia sucursal) {
		this.cantidadMax = cantidadMax;
		this.encargado = encargado;
//		this.areas = new ArrayList<AreaPersistencia>();
//		this.mercaderias = new ArrayList<MercaderiaPersistencia>();
		this.suc=sucursal;
	}

	
	@Id
	@GeneratedValue
	public int getIdDeposito() {
		return idDeposito;
	}


	public void setIdDeposito(int idDeposito) {
		this.idDeposito = idDeposito;
	}



//	public void setAreas(ArrayList<AreaPersistencia> areas) {
//		this.areas = areas;
//	}
//
//
//
//	public void setMercaderias(ArrayList<MercaderiaPersistencia> mercaderias) {
//		this.mercaderias = mercaderias;
//	}



	public float getCantidadMax() {
		return cantidadMax;
	}

	public String getEncargado() {
		return encargado;
	}

//	public List<AreaPersistencia> getAreas() {
//		return areas;
//	}
//
//	public List<MercaderiaPersistencia> getMercaderias() {
//		return mercaderias;
//	}

	public void setCantidadMax(float cantidadMax) {
		this.cantidadMax = cantidadMax;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

//	public void addAreas(AreaPersistencia area) {
//		this.areas.add(area);
//	}
//
//	public void addMercaderia(MercaderiaPersistencia mercaderia) {
//		this.mercaderias.add(mercaderia);
//	}

@ManyToOne
@JoinColumn(name="numeroSucursal")
	public SucursalPersistencia getSucursal() {
		return suc;
	}


	public void setSucursal(SucursalPersistencia sucursal) {
		this.suc = sucursal;
	}
	
	

}
