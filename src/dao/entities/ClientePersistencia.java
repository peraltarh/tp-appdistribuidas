package dao.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="Cliente")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo",discriminatorType=DiscriminatorType.STRING)

public abstract class ClientePersistencia implements Serializable{

	private static final long serialVersionUID = 1L;
	protected int idCliente;
	protected String direccion;
	protected String telefono;

	
	
	public ClientePersistencia(String direccion, String telefono) {
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public ClientePersistencia() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdCliente(){
		return idCliente;
	}
	
	public void setIdCliente(int idCliente){
		this.idCliente = idCliente;
	}
	
	
	public String getDireccion() {
		return direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	
	
}
