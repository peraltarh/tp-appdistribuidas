package dao.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("Particular")
public class Particular extends Cliente{
	
	private long dni;
	private String nombre;
	private String apellido;
	
	
	public Particular(String direccion, String telefono, String nombre,
			String apellido, long dni) {
		super(direccion, telefono);
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	
	@Column (unique = true)
	public long getDni() {
		return dni;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	
	

}
