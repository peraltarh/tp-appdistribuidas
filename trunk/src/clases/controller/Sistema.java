package clases.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import clases.*;
import dao.DAOCliente;
import dao.DAOCuentaCorriente;
import dao.entities.ClientePersistencia;
import dao.entities.CuentaCorrientePersistencia;
import dao.entities.EmpresaPersistencia;
import dao.entities.EmpresaDirValidasPersistencia;
import dao.entities.MovimientoCuentaPersistencia;
import dao.entities.ParticularPersistencia;
import dao.entities.ProductoPersistencia;



public class Sistema {
	
	private static Sistema sys = null;
	
	private ArrayList<Sucursal> sucursales;
	private ArrayList<PoliticasDeEnvio> politicas;
	private ArrayList<MapaDeRuta> rutas;
	private ArrayList<Vehiculo> vehiculos;
	private ArrayList<Remito> remitos;
	private ArrayList<Pedido> pedidos;
	private ArrayList<Factura> facturas;
	private ArrayList<Cliente> clientes;
	private ArrayList<CuentaCorriente> cuentasCorrientes;
//	private ArrayList<dao.entities.Cliente> clientes2;
	
	
	public static Sistema getInstance(){
		if (sys ==null){sys = new Sistema();}
		return sys;
	}
	
	public Sistema(){
		this.sucursales = new ArrayList<Sucursal>();
		this.politicas = new ArrayList<PoliticasDeEnvio>();
		this.rutas = new ArrayList<MapaDeRuta>();
		this.vehiculos = new ArrayList<Vehiculo>();
		this.remitos = new ArrayList<Remito>();
		this.pedidos = new ArrayList<Pedido>();
		this.facturas = new ArrayList<Factura>();
		this.clientes = new ArrayList<Cliente>();
		this.cuentasCorrientes = new ArrayList<CuentaCorriente>();
	}

	public ArrayList<Sucursal> getSucursales() {
		return sucursales;
	}

	public ArrayList<PoliticasDeEnvio> getPoliticas() {
		return politicas;
	}

	public ArrayList<MapaDeRuta> getRutas() {
		return rutas;
	}

	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public ArrayList<Remito> getRemitos() {
		return remitos;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public ArrayList<CuentaCorriente> getCuentasCorrientes() {
		return cuentasCorrientes;
	}

	public void addSucursale(Sucursal sucursale) {
		this.sucursales.add(sucursale);
	}

	public void addPolitica(PoliticasDeEnvio politica) {
		this.politicas.add(politica);
	}

	public void addRuta(MapaDeRuta ruta) {
		this.rutas.add(ruta);
	}

	public void addVehiculo(Vehiculo vehiculo) {
		this.vehiculos.add(vehiculo);
	}

	public void addRemito(Remito remito) {
		this.remitos.add(remito);
	}

	public void addPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}

	public void addFactura(Factura factura) {
		this.facturas.add(factura);
	}

	private void addCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}

	public void addCuentaCorriente(CuentaCorriente cuentaCorriente) {
		this.cuentasCorrientes.add(cuentaCorriente);
	}


	
	public void altaParticular(String direccion, String telefono, String nombre, String apellido, String dni)
	{
		ParticularPersistencia p= new ParticularPersistencia(direccion, telefono,nombre,apellido,dni);
		DAOCliente.getInstance().persistir(p);
	}

	public void altaEmpresa(String direccion, String telefono, String razonSocial, String cuit, String regularidad) {
		EmpresaPersistencia e=new EmpresaPersistencia(direccion,telefono,razonSocial,cuit,regularidad);
		DAOCliente.getInstance().persistir(e);
	}
	

	public void buscarClienteParticular(String dni) {
		ParticularPersistencia particular=DAOCliente.getInstance().getClienteParticular(dni);
		System.out.println("\n\n\n\n\n\n"+particular.getDni());
	}

	public void buscarClienteEmpresa(String cuit) {
		EmpresaPersistencia empresa=DAOCliente.getInstance().getClienteEmpresa(cuit);
		System.out.println("\n\n\n\n\n\n"+empresa.getIdCliente());		
	}
	
	public void altaCuentaCorriente(int cbu, float saldoActual, float minimoPermitidoSinAuth, String cuit) {
		EmpresaPersistencia empresa=DAOCliente.getInstance().getClienteEmpresa(cuit);
		CuentaCorrientePersistencia cc=new CuentaCorrientePersistencia(cbu, saldoActual, minimoPermitidoSinAuth, true, empresa);
		empresa.addCuentaCorriente(cc);
		DAOCliente.getInstance().persistir(empresa);
	}

	public void altaProducto(String tipo, String descripcion, String cuit) {
		EmpresaPersistencia empresa=DAOCliente.getInstance().getClienteEmpresa(cuit);
		ProductoPersistencia p=new ProductoPersistencia(tipo, descripcion, empresa);
		empresa.addProductoValido(p);
		DAOCliente.getInstance().update(empresa);
	}

	public void altaMovimientoCuenta(Date fecha, float monto, int cbu) {
		CuentaCorrientePersistencia cuenta=DAOCuentaCorriente.getInstance().getCuentaCorriente(cbu);
		MovimientoCuentaPersistencia mov=new MovimientoCuentaPersistencia(fecha, monto, cuenta);
		cuenta.addMovimiento(mov);
		DAOCuentaCorriente.getInstance().update(cuenta);
	}

	public void agregarEmpresaDireccionValida(String direccion, String cuit) {
		EmpresaPersistencia empresa=DAOCliente.getInstance().getClienteEmpresa(cuit);
		EmpresaDirValidasPersistencia dir=new EmpresaDirValidasPersistencia(direccion, empresa);
		empresa.addDireccionValida(dir);
		DAOCliente.getInstance().update(empresa);
		
	}

	
}
