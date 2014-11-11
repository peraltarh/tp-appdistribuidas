package dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ItemFactura")

public class ItemFacturaPersistencia {
	
	private int idItemFactura;
	private float costo;
	private MercaderiaPersistencia mercaderia;
	private FacturaPersistencia factura;
	public ItemFacturaPersistencia(float costo, MercaderiaPersistencia mercaderia, FacturaPersistencia factura) {
		super();
		this.costo = costo;
		this.mercaderia = mercaderia;
	}
	
	public ItemFacturaPersistencia(){}
	@Id
	@GeneratedValue
	public int getIdItemFactura() {
		return idItemFactura;
	}



	public void setIdItemFactura(int idItemFactura) {
		this.idItemFactura = idItemFactura;
	}

@ManyToOne
@JoinColumn(name="idFactura")

	public FacturaPersistencia getFactura() {
		return factura;
	}



	public void setFactura(FacturaPersistencia factura) {
		this.factura = factura;
	}



	public float getCosto() {
		return costo;
	}
	@OneToOne
	@JoinColumn(name="idItemFactura")
	public MercaderiaPersistencia getMercaderia() {
		return mercaderia;
	}
	
	public void setMercaderia(MercaderiaPersistencia mercaderia) {
		this.mercaderia = mercaderia;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	
	
	
	
	

}
