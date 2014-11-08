package dao.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Destinatario")
public class DestinatarioPersistencia {
	
	private String nombre;
	private String apellido;
	private int dni;
	private PedidoPersistencia pedido;
	
	public DestinatarioPersistencia(String nombre, String apellido, int dni, PedidoPersistencia pedido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.pedido=pedido;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	@Id
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
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
