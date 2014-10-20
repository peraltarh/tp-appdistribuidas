package clases;

public class Particular extends Cliente{
	
	private String nombre;
	private String apellido;
	private long dni;
	
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
	
	public dao.entities.Particular getEntity()
	{
		return new dao.entities.Particular(direccion, telefono, nombre, apellido, dni);
	}

}
