package clases;

public class Cliente {

	protected String direccion;
	protected String telefono;
	public Cliente(String direccion, String telefono) {
		super();
		this.direccion = direccion;
		this.telefono = telefono;
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
