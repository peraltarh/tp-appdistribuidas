package dao.entities;

public class DestinatarioPersistencia {
	
	private String nombre;
	private String apellido;
	private long dni;
	public DestinatarioPersistencia(String nombre, String apellido, long dni) {
		super();
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
