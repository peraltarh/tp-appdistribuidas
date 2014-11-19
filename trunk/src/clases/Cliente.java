package clases;

public abstract class Cliente {

	protected String direccion;
	protected String telefono;
	protected int idCliente;
	public Cliente(String direccion, String telefono,int idCliente) {
		super();
		this.direccion = direccion;
		this.telefono = telefono;
		this.idCliente = idCliente;
	}
	public Cliente() {
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
	public abstract boolean sosElCliente(String cuit);
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
}
