package clases.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
		DAOCliente.getInstance().persistirParticular(p);
	
//Prueba de convert Particular		
//		p=buscarClienteParticular(dni);
//		Particular part=convertParticularPersistenciaToCliente(p);
//		System.out.println("\n\n"+part.getApellido()+"\n\n"+part.getNombre()+"\n\n"+part.getDireccion());
	}

	public void altaEmpresa(String direccion, String telefono, String razonSocial, String cuit, String regularidad) {
		EmpresaPersistencia e=new EmpresaPersistencia(direccion,telefono,razonSocial,cuit,regularidad);
		DAOCliente.getInstance().persistirEmpresa(e);
	
	}


	public ParticularPersistencia buscarClienteParticular(String dni) {
		ParticularPersistencia particular=DAOCliente.getInstance().getClienteParticular(dni);
		return particular;
	}

	public EmpresaPersistencia buscarClienteEmpresa(String cuit) {
		EmpresaPersistencia empresa=DAOCliente.getInstance().getClienteEmpresa(cuit);
		return empresa;
	}

	public void altaCuentaCorriente(int cbu, float saldoActual, float minimoPermitidoSinAuth, String cuit) {
		EmpresaPersistencia empresa=DAOCliente.getInstance().getClienteEmpresa(cuit);
		CuentaCorrientePersistencia cc=new CuentaCorrientePersistencia(cbu, saldoActual, minimoPermitidoSinAuth, true, empresa);
		empresa.addCuentaCorriente(cc);
		DAOCliente.getInstance().persistirEmpresa(empresa);
		
//Prueba de convert Empresa
//		EmpresaPersistencia e=buscarClienteEmpresa(cuit);
//		Empresa emp=convertEmpresaPersistenciaToNegocio(e);
//		System.out.println("\n\n"+emp.getCuit()+"\n\n"+"\n\n"+emp.getDireccion()+emp.getCuentasCorrientes().get(0).getCbu());
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

	public void agregarEmpresaDireccionValida(String direccion, String tel,String cuit) {
		EmpresaPersistencia empresa=DAOCliente.getInstance().getClienteEmpresa(cuit);
		EmpresaDirValidasPersistencia dir=new EmpresaDirValidasPersistencia(direccion, tel, empresa);
		empresa.addDireccionValida(dir);
		DAOCliente.getInstance().update(empresa);

	}

	private Particular convertParticularPersistenciaToCliente(ParticularPersistencia pP)
	{
		Particular p=new Particular();
		p.setApellido(pP.getApellido());
		p.setDireccion(pP.getDireccion());
		p.setDni(pP.getDni());
		p.setNombre(pP.getNombre());
		p.setTelefono(pP.getTelefono());
		return p;
	}
	//*****************************************************************
	//Sin terminar
	private Empresa convertEmpresaPersistenciaToNegocio(EmpresaPersistencia eP)
	{
		Empresa emp = new Empresa();
		emp.setCuit(eP.getCuit());
		emp.setRazonSoial(eP.getRazonSoial());
		emp.setRegularidad(eP.getRegularidad());
		emp.setDireccion(eP.getDireccion());
		emp.setTelefono(eP.getTelefono());
		List<CuentaCorriente>cuentas=new ArrayList<CuentaCorriente>();
		for (CuentaCorrientePersistencia cuentaCorrientePersistencia : eP.getCuentasCorrientes()) {
			cuentas.add(convertCuentaCorrientePersistenciaToNegocio(cuentaCorrientePersistencia));
		}
		emp.setCuentasCorrientes(cuentas);
		
		List<EmpresaDirValidas>direcciones=new ArrayList<EmpresaDirValidas>();
		for (EmpresaDirValidasPersistencia empresaDirValidasPersistencia : eP.getDireccionesValidas()) {
			direcciones.add(convertEmpresaDirValidasToNegocio(empresaDirValidasPersistencia));
		}
		emp.setDireccionesValidas(direcciones);
		
		List<Producto>productos=new ArrayList<Producto>();
		for(ProductoPersistencia producto: eP.getProductosValidos())
		{
			productos.add(convertProductoPersistenciaToNegocio(producto));
		}
		emp.setProductosValidos(productos);
		
		
		return emp;

	}
	private MovimientoCuenta convertMovimientoCuentaPersistenciaToNegocio (MovimientoCuentaPersistencia mP)
	{
		MovimientoCuenta m=new MovimientoCuenta();
		m.setFecha(mP.getFecha());
		m.setMonto(mP.getMonto());		
		return m;
	}
	
	private CuentaCorriente convertCuentaCorrientePersistenciaToNegocio(CuentaCorrientePersistencia ccP)
	{
		CuentaCorriente cc=new CuentaCorriente();
		cc.setCbu(ccP.getCbu());
		cc.setMinimoPermitidoSinAuth(ccP.getMinimoPermitidoSinAuth());
		cc.setSaldoActual(ccP.getSaldoActual());
		
		List<MovimientoCuenta>movimientosCuenta=new ArrayList<MovimientoCuenta>();
		for(MovimientoCuentaPersistencia movimientoCuenta: ccP.getMovimientos())
		{
			movimientosCuenta.add(convertMovimientoCuentaPersistenciaToNegocio(movimientoCuenta));
		}
		cc.setMovimientos(movimientosCuenta);
		
		
		return cc;
		
	}
	
	private EmpresaDirValidas convertEmpresaDirValidasToNegocio (EmpresaDirValidasPersistencia eP)
	{
		EmpresaDirValidas e=new EmpresaDirValidas();
		e.setDireccion(eP.getDireccion());
		e.setTel(eP.getTel());
		return e;
		
	}
	
	private Producto convertProductoPersistenciaToNegocio(ProductoPersistencia pp)
	{
		Producto p=new Producto();
		p.setDescripcion(pp.getDescripcion());
		p.setTipo(pp.getTipo());
		return p;
	}
	
}
