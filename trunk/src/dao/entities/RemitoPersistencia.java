package dao.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Remito")
public class RemitoPersistencia {
	
	private int nroRemito;
	private String estado;
	private List<MercaderiaPersistencia> mercaderias;
	private VehiculoPersistencia vehiculo;
	
	public RemitoPersistencia(int nroRemito, String estado, VehiculoPersistencia vehiculo) {
		super();
		this.nroRemito = nroRemito;
		this.estado = estado;
		this.mercaderias = new ArrayList<MercaderiaPersistencia>();
		this.vehiculo=vehiculo;
	}

	@Id
	public int getNroRemito() {
		return nroRemito;
	}

	public String getEstado() {
		return estado;
	}
@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="nroRemito")
	public List<MercaderiaPersistencia> getMercaderias() {
		return mercaderias;
	}
	public void setMercaderias(ArrayList<MercaderiaPersistencia> mercaderias) {
		this.mercaderias = mercaderias;
	}

	@ManyToOne
	@JoinColumn(name="nroChasis")
	public VehiculoPersistencia getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculoPersistencia vehiculo) {
		this.vehiculo = vehiculo;
	}

	
	public void setNroRemito(int nroRemito) {
		this.nroRemito = nroRemito;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void addMercaderia(MercaderiaPersistencia mercaderia) {
		this.mercaderias.add(mercaderia);
	}
	
	

}
