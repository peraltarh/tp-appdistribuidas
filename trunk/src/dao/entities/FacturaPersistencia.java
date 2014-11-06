package dao.entities;

import java.sql.Date;
import java.util.ArrayList;

public class FacturaPersistencia {
	
	private Date fecha;
	private float total;
	private ClientePersistencia cliente;
	private ArrayList<ItemFacturaPersistencia> items;
	public FacturaPersistencia(Date fecha, float total, ClientePersistencia cliente) {
		super();
		this.fecha = fecha;
		this.total = total;
		this.cliente = cliente;
		this.items = new ArrayList<ItemFacturaPersistencia>();
	}
	public Date getFecha() {
		return fecha;
	}
	public float getTotal() {
		return total;
	}
	public ClientePersistencia getCliente() {
		return cliente;
	}
	public ArrayList<ItemFacturaPersistencia> getItems() {
		return items;
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
