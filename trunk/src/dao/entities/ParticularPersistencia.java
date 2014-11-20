package dao.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("Particular")
public class ParticularPersistencia extends ClientePersistencia implements Serializable{

	private static final long serialVersionUID = 1L;
	private String dni;
	private String nombre;
	private String apellido;


	public ParticularPersistencia(String direccion, String telefono, String nombre,	String apellido, String dni) {
		super(direccion, telefono);
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
	public ParticularPersistencia() {
		super();
	}
		
	
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}



}
