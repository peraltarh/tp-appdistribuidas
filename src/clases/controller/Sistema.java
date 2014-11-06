package clases.controller;

import java.util.ArrayList;
import java.util.Iterator;

import clases.*;
import dao.DAOCliente;
import dao.entities.EmpresaPersistencia;
import dao.entities.EmpresaDirValidasPersistencia;



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
		Particular p=new Particular(direccion,telefono,nombre,apellido,dni);
		addCliente(p);
//		dao.entities.Particular p2 = new dao.entities.Particular(direccion,telefono,nombre,apellido,dni);
//		this.clientes2.add(p2);
		DAOCliente.getInstance().persistir(new dao.entities.ParticularPersistencia(direccion,telefono,nombre,apellido,dni));
	}

	public void altaEmpresa(String direccion, String telefono, String razonSocial, String cuit, String regularidad) {
		clases.Empresa e=new clases.Empresa (direccion,telefono,razonSocial,cuit,regularidad);
		clientes.add(e);
		DAOCliente.getInstance().persistir(new dao.entities.EmpresaPersistencia(direccion,telefono,razonSocial,cuit,regularidad));
	}

	//Falla el buscarEmpresa-> Inserta mal los datos y genera duplicados en la base.
	public void agregarDireccionValida(String direccion, String cuit) {
//		clases.Empresa e = buscarEmpresa(cuit);
//		e.addDireccioneValida(new EmpresaDirValidas(direccion, e));
//		DAOCliente.getInstance().persistir(new dao.entities.Empresa(e.getDireccion(),e.getTelefono(),e.getRazonSoial(),e.getCuit(),e.getRegularidad()));
		
	}

//Falla con el CAST.
	
	private clases.Empresa buscarEmpresa(String cuit) 
	{
		int i=0;
		for (clases.Cliente c:clientes)
		{
			if(c.sosElCliente(cuit))
			{
				return (clases.Empresa) c;
			}
		}
		return null;
	}
}
