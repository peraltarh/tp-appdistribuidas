package clases;

public class Producto {
	
	private String tipo;
	private String descripcion;
	private int idProd;
	public Producto(String tipo, String descripcion) {
		super();
		this.tipo = tipo;
		this.descripcion = descripcion;
	}
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	public String getTipo() {
		return tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion= descripcion;
	}
	public int getIdProd() {
		return idProd;
	}
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}
	
	

}
