package dao.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Factura")

public class FacturaPersistencia {
	
	private int idFactura;
	private Date fecha;
	private float total;
	private ClientePersistencia cliente;
	private List<ItemFacturaPersistencia> items;
	public FacturaPersistencia(Date fecha, float total, ClientePersistencia cliente) {
		this.fecha = fecha;
		this.total = total;
		this.cliente = cliente;
		this.items = new ArrayList<ItemFacturaPersistencia>();
	}
	
	public FacturaPersistencia(){}
	
	@Id
	@GeneratedValue
	public int getIdFactura()
	{
		return this.idFactura;
	}
	public void setIdFactura(int idFactura)
	{
		this.idFactura=idFactura;
	}
	
	public Date getFecha() 
	{
		return fecha;
	}
	public float getTotal() {
		return total;
	}
	@OneToOne
	public ClientePersistencia getCliente() {
		return cliente;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idFactura")
	public List<ItemFacturaPersistencia> getItems() {
		return items;
	}
	
	public void setItems(List<ItemFacturaPersistencia> items)
	{
		this.items= items;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public void setCliente(ClientePersistencia cliente) {
		this.cliente = cliente;
	}
	public void addItem(ItemFacturaPersistencia item) {
		this.items.add(item);
	}
	
	

}
