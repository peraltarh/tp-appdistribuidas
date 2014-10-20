package clases;

import java.util.ArrayList;

public class Empresa extends Cliente {
	
	private String razonSoial;
	private String cuit;
	private String regularidad;
	private ArrayList<String> direccionesValidas;
	private ArrayList<Producto> productosValidos;
	private CuentaCorriente cuentaCorriente;
	
	
	public Empresa(String direccion, String telefono, String razonSoial,
			String cuit, String regularidad) {
		super(direccion, telefono);
		this.razonSoial = razonSoial;
		this.cuit = cuit;
		this.regularidad = regularidad;
		this.direccionesValidas = new ArrayList<String>();
		this.productosValidos = new ArrayList<Producto>();
		this.cuentaCorriente = null;
	}


	public String getRazonSoial() {
		return razonSoial;
	}


	public String getCuit() {
		return cuit;
	}


	public String getRegularidad() {
		return regularidad;
	}


	public ArrayList<String> getDireccionesValidas() {
		return direccionesValidas;
	}


	public ArrayList<Producto> getProductosValidos() {
		return productosValidos;
	}


	public CuentaCorriente getCuentaCorriente() {
		return cuentaCorriente;
	}


	public void setRazonSoial(String razonSoial) {
		this.razonSoial = razonSoial;
	}


	public void setCuit(String cuit) {
		this.cuit = cuit;
	}


	public void setRegularidad(String regularidad) {
		this.regularidad = regularidad;
	}


	public void addDireccioneValida(String direccionesValida) {
		this.direccionesValidas.add(direccionesValida);
	}


	public void addProductoValido(Producto productosValido) {
		this.productosValidos.add(productosValido);
	}


	public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}


	public dao.entities.Empresa getEntity() {
		return new dao.entities.Empresa(getDireccion(), getTelefono(), getRazonSoial(), getCuit(), getRegularidad()); 
		
	}


	@Override
	public boolean sosElCliente(String cuit) {
		if(cuit.equalsIgnoreCase(this.cuit))
			return true;
		return false;
	}
	
	
	
	

}
