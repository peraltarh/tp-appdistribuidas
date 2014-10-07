package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity
@DiscriminatorValue("Empresa")
public class Empresa extends Cliente {



	private String cuit;
	private String razonSoial;
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


	public String getRazonSoial() {
		return razonSoial;
	}


	public String getCuit() {
		return cuit;
	}


	public String getRegularidad() {
		return regularidad;
	}

	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="empresa")
	public List<EmpresaDirValidas> getDireccionesValidas() {
		return direccionesValidas;
	}


	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="empresa")
	public List<Producto> getProductosValidos() {
		return productosValidos;
	}


	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="empresa")
	public List<CuentaCorriente> getCuentasCorrientes() {
		return cuentasCorrientes;
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


	public void addDireccioneValida(EmpresaDirValidas direccionValida) {
		this.direccionesValidas.add(direccionValida);
	}


	public void addProductoValido(Producto productosValido) {
		this.productosValidos.add(productosValido);
	}


	public void setCuentasCorrientes(List<CuentaCorriente> cuentasCorrientes) {
		this.cuentasCorrientes = cuentasCorrientes;
	}


	
	public void setProductosValidos(List<Producto> productosValidos) {
		this.productosValidos = productosValidos;
	}

	public void setDireccionesValidas(List<EmpresaDirValidas> direccionesValidas) {
		this.direccionesValidas = direccionesValidas;
	}


	public void addCuentaCorriente(CuentaCorriente cuentaCorriente) {
		this.cuentasCorrientes.add(cuentaCorriente);
		
	}


	
	

}
