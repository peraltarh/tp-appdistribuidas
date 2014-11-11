package clases;

import java.util.ArrayList;
import java.util.List;

import dao.entities.CuentaCorrientePersistencia;
import dao.entities.EmpresaDirValidasPersistencia;
import dao.entities.ProductoPersistencia;

public class Empresa extends Cliente {
	
	private String razonSoial;
	private String cuit;
	private String regularidad;
	private List<EmpresaDirValidas> direccionesValidas;
	private List<Producto> productosValidos;
	private List<CuentaCorriente> cuentasCorrientes;
	
	
	public Empresa(String direccion, String telefono, String razonSoial,
			String cuit, String regularidad) {
		super(direccion, telefono);
		this.razonSoial = razonSoial;
		this.cuit = cuit;
		this.regularidad = regularidad;
		this.direccionesValidas = new ArrayList<EmpresaDirValidas>();
		this.productosValidos = new ArrayList<Producto>();
		this.cuentasCorrientes =  new ArrayList<CuentaCorriente>();
		}


	public Empresa()
	{
		super();
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

	public void setRazonSoial(String razonSoial) {
		this.razonSoial = razonSoial;
	}


	public void setCuit(String cuit) {
		this.cuit = cuit;
	}


	public void setRegularidad(String regularidad) {
		this.regularidad = regularidad;
	}


	


	

	public List<EmpresaDirValidas> getDireccionesValidas() {
		return direccionesValidas;
	}


	public void setDireccionesValidas(List<EmpresaDirValidas> direccionesValidas) {
		this.direccionesValidas = direccionesValidas;
	}


	public List<Producto> getProductosValidos() {
		return productosValidos;
	}


	public void setProductosValidos(List<Producto> productosValidos) {
		this.productosValidos = productosValidos;
	}


	public List<CuentaCorriente> getCuentasCorrientes() {
		return cuentasCorrientes;
	}


	public void setCuentasCorrientes(List<CuentaCorriente> cuentasCorrientes) {
		this.cuentasCorrientes = cuentasCorrientes;
	}


	public dao.entities.EmpresaPersistencia getEntity() {
		return new dao.entities.EmpresaPersistencia(getDireccion(), getTelefono(), getRazonSoial(), getCuit(), getRegularidad()); 
		
	}


	@Override
	public boolean sosElCliente(String cuit) {
		if(cuit.equalsIgnoreCase(this.cuit))
			return true;
		return false;
	}
	
	
	
	

}
