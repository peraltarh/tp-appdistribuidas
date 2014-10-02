package clases;

import java.sql.Date;
import java.util.ArrayList;

public class Factura {
	
	private Date fecha;
	private float total;
	private Cliente cliente;
	private ArrayList<ItemFactura> items;
	public Factura(Date fecha, float total, Cliente cliente) {
		super();
		this.fecha = fecha;
		this.total = total;
		this.cliente = cliente;
		this.items = new ArrayList<ItemFactura>();
	}
	public Date getFecha() {
		return fecha;
	}
	public float getTotal() {
		return total;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public ArrayList<ItemFactura> getItems() {
		return items;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void addItem(ItemFactura item) {
		this.items.add(item);
	}
	
	

}
