package clases;

public class Producto {
	
	private String tipo;
	private String nombre;
	public Producto(String tipo, String nombre) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
