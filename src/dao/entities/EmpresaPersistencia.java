package dao.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import clases.Cliente;
import clases.Empresa;


@Entity
@DiscriminatorValue("Empresa")
public class EmpresaPersistencia extends ClientePersistencia implements Serializable{

	private static final long serialVersionUID = 1L;
	private String cuit;
	private String razonSoial;
	private String regularidad;
	private List<EmpresaDirValidasPersistencia> direccionesValidas;
	private List<ProductoPersistencia> productosValidos;
	private List<CuentaCorrientePersistencia> cuentasCorrientes;

	public EmpresaPersistencia(String direccion, String telefono, String razonSoial, String cuit, String regularidad) {
		super(direccion, telefono);
		this.razonSoial = razonSoial;
		this.cuit = cuit;
		this.regularidad = regularidad;
		this.direccionesValidas = new ArrayList<EmpresaDirValidasPersistencia>();
		this.productosValidos = new ArrayList<ProductoPersistencia>();
		this.cuentasCorrientes =  new ArrayList<CuentaCorrientePersistencia>();
	}

	public EmpresaPersistencia() {
		super();
		this.direccionesValidas = new ArrayList<EmpresaDirValidasPersistencia>();
		this.productosValidos = new ArrayList<ProductoPersistencia>();
		this.cuentasCorrientes =  new ArrayList<CuentaCorrientePersistencia>();
	}

	public String getRazonSoial() {
		return razonSoial;
	}

@Column(nullable=true)
	public String getCuit() {
		return cuit;
	}


	public String getRegularidad() {
		return regularidad;
	}

	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="empresa")
	public List<EmpresaDirValidasPersistencia> getDireccionesValidas() {
		return direccionesValidas;
	}


	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="empresa")
	public List<ProductoPersistencia> getProductosValidos() {
		return productosValidos;
	}

	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="empresa")
	public List<CuentaCorrientePersistencia> getCuentasCorrientes() {
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


	public void addDireccionValida(EmpresaDirValidasPersistencia direccionValida) {
		this.direccionesValidas.add(direccionValida);
	}


	public void addProductoValido(ProductoPersistencia productosValido) {
		this.productosValidos.add(productosValido);
	}


	public void setCuentasCorrientes(List<CuentaCorrientePersistencia> cuentasCorrientes) {
		this.cuentasCorrientes = cuentasCorrientes;
	}



	public void setProductosValidos(List<ProductoPersistencia> productosValidos) {
		this.productosValidos = productosValidos;
	}

	public void setDireccionesValidas(List<EmpresaDirValidasPersistencia> direccionesValidas) {
		this.direccionesValidas = direccionesValidas;
	}


	public void addCuentaCorriente(CuentaCorrientePersistencia cuentaCorriente) {
		this.cuentasCorrientes.add(cuentaCorriente);
	}

	public Empresa toNegocio() 
	{
		Empresa empresa = new Empresa();
		empresa.setCuit(cuit);
		empresa.setDireccion(direccion);
		empresa.setRazonSoial(razonSoial);
		empresa.setTelefono(telefono);
		empresa.setRegularidad(regularidad);
		empresa.setIdCliente(idCliente);
		for(CuentaCorrientePersistencia ccp : cuentasCorrientes)
			empresa.getCuentasCorrientes().add(ccp.toNegocio());
		for(ProductoPersistencia pp : productosValidos)
			empresa.getProductosValidos().add(pp.toNegocio());
		for(EmpresaDirValidasPersistencia edvp : direccionesValidas)
			empresa.getDireccionesValidas().add(edvp.toNegocio());
		return empresa;
	}





}
