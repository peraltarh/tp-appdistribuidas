package clases;

public class Particular extends Cliente{
	
	private String nombre;
	private String apellido;
	private String dni;
	
	public Particular(String direccion, String telefono, String nombre,
			String apellido, String dni, int idCliente) {
		super(direccion, telefono, idCliente);
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	public Particular() {
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
	@Override
	public boolean sosElCliente(String dni) {
		if(dni.equalsIgnoreCase(this.dni))
			return true;
		return false;
	}
	
	public dao.entities.ParticularPersistencia getEntity()
	{
		return new dao.entities.ParticularPersistencia(direccion, telefono, nombre, apellido, dni);
	}

}
