package dao.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Destinatario")
public class DestinatarioPersistencia {
	
	private String nombre;
	private String apellido;
	private long dni;
	private PedidoPersistencia pedido;
	
	public DestinatarioPersistencia(String nombre, String apellido, int dni, PedidoPersistencia pedido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.pedido=pedido;
	}
	
	public DestinatarioPersistencia(){}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	@Id
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@ManyToOne
	@JoinColumn(name="idPedido")
	public PedidoPersistencia getPedido() {
		return pedido;
	}
	public void setPedido(PedidoPersistencia pedido) {
		this.pedido = pedido;
	}
	
	
	
	

}
