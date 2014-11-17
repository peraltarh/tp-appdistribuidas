package clases.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import beans.ClienteBean;
import beans.DepositoBean;
import beans.EmpresaBean;
import beans.MercaderiaBean;
import beans.MercaderiaPorPesoBean;
import beans.MercaderiaPorVolumenBean;
import beans.ParticularBean;
import beans.PedidoBean;
import beans.RemitoBean;
import beans.SucursalBean;
import clases.*;
import dao.DAOCliente;
import dao.DAOCuentaCorriente;
import dao.DAODeposito;
import dao.DAOPedido;
import dao.DAOSucursal;
import dao.entities.ClientePersistencia;
import dao.entities.CuentaCorrientePersistencia;
import dao.entities.DepositoPersistencia;
import dao.entities.EmpresaPersistencia;
import dao.entities.EmpresaDirValidasPersistencia;
import dao.entities.MercaderiaPersistencia;
import dao.entities.MercaderiaPorPesoPersistencia;
import dao.entities.MercaderiaPorVolumenPersistencia;
import dao.entities.MovimientoCuentaPersistencia;
import dao.entities.ParticularPersistencia;
import dao.entities.PedidoPersistencia;
import dao.entities.ProductoPersistencia;
import dao.entities.RemitoPersistencia;
import dao.entities.SucursalPersistencia;



public class Sistema {

	private static Sistema sys = null;

	private List<Sucursal> sucursales;
	private List<PoliticasDeEnvio> politicas;
	private List<MapaDeRuta> rutas;
	private List<Vehiculo> vehiculos;
	private List<Remito> remitos;
	private List<Pedido> pedidos;
	private List<Factura> facturas;
	private List<Cliente> clientes;
	private List<CuentaCorriente> cuentasCorrientes;


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

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public List<PoliticasDeEnvio> getPoliticas() {
		return politicas;
	}

	public List<MapaDeRuta> getRutas() {
		return rutas;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public List<Remito> getRemitos() {
		return remitos;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public List<CuentaCorriente> getCuentasCorrientes() {
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

	}

	public void altaEmpresa(String direccion, String telefono, String razonSocial, String cuit, String regularidad) {
		EmpresaPersistencia e=new EmpresaPersistencia(direccion,telefono,razonSocial,cuit,regularidad);
		DAOCliente.getInstance().persistirEmpresa(e);

	}

	public List<DepositoPersistencia> getDepositos(int idSucursal) {
		List<DepositoPersistencia> depositos=new ArrayList<DepositoPersistencia>();
		depositos=DAODeposito.getInstance().getDepositos(idSucursal);
		return depositos;
	}


	public void altaCuentaCorriente(int cbu, float saldoActual, float minimoPermitidoSinAuth, String cuit) {
		EmpresaPersistencia empresa=DAOCliente.getInstance().getClienteEmpresa(cuit);
		CuentaCorrientePersistencia cc=new CuentaCorrientePersistencia(cbu, saldoActual, minimoPermitidoSinAuth, true, empresa);
		empresa.addCuentaCorriente(cc);
		DAOCliente.getInstance().persistirEmpresa(empresa);

	}

	public void altaProducto(String tipo, String descripcion, String cuit) {
		EmpresaPersistencia empresa=DAOCliente.getInstance().getClienteEmpresa(cuit);
		ProductoPersistencia p=new ProductoPersistencia(tipo, descripcion, empresa);
		empresa.addProductoValido(p);
		DAOCliente.getInstance().update(empresa);
	}

	public void altaSucursal(String nombre, String dir, String gerente, String encDespacho, String encRecepcion) {

		SucursalPersistencia suc=new SucursalPersistencia(nombre, dir, gerente, encDespacho, encRecepcion);
		DAOSucursal.getInstance().persistirSucursal(suc);
	}

	public void altaDeposito(float cantidadMax, String encargado, String sucursal) {
		SucursalPersistencia suc=DAOSucursal.getInstance().getSucursal(sucursal);
		DepositoPersistencia dep=new DepositoPersistencia(cantidadMax, encargado, suc);
		DAODeposito.getInstance().persistirDeposito(dep);
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

	public EmpresaPersistencia buscarClienteEmpresa(String cuit)
	{
		return DAOCliente.getInstance().getClienteEmpresa(cuit);

	}
	public ParticularPersistencia buscarClienteParticular(String dni)
	{
		return DAOCliente.getInstance().getClienteParticular(dni);

	}
	public void altaPedido(String manifiesto, String dirDestino,
			Date fechaEnregaMaxima, Date fechaEntregaEstimada,
			String condEspeciales, Date horarioDeEntregaDesde,
			Date horarioDeEntregahasta, String dirDeRetiroSoloEmpresa,
			int prioridad, String estado, String sucursal, String cliente, String tipoC) 
	{
		ClientePersistencia c=null;
		if(tipoC.equals("cuit"))
		{
			c=DAOCliente.getInstance().getClienteEmpresa(cliente);
		}
		if(tipoC.equals("dni"))
		{
			c=DAOCliente.getInstance().getClienteParticular(cliente);
		}

		SucursalPersistencia suc=DAOSucursal.getInstance().getSucursal(sucursal);
		PedidoPersistencia pedido=new PedidoPersistencia(manifiesto, dirDestino, fechaEnregaMaxima, fechaEntregaEstimada, condEspeciales, horarioDeEntregaDesde, horarioDeEntregahasta, dirDeRetiroSoloEmpresa, prioridad, estado,suc, c);
		DAOPedido.getInstance().persistir(pedido);
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

	//FALTA TERMINAR EL CONVERT DE CLIENTE, SUCURSAL Y LAS 3 LISTAS.
	private List<PedidoBean> convertPedidosPersistenciaToBean(List<PedidoPersistencia> list)
	{
		List<PedidoBean>listaPedidoBean=new ArrayList<PedidoBean>();
		for (PedidoPersistencia pP : list) 
		{
			PedidoBean pBean=new PedidoBean();
			pBean.setManifiesto(pP.getManifiesto());
			pBean.setIdPedido(pP.getIdPedido());
			pBean.setDirDestino(pP.getDirDestino());
			pBean.setFechaEnregaMaxima(pP.getFechaEnregaMaxima());
			pBean.setFechaEnregaMaxima(pP.getFechaEntregaEstimada());
			pBean.setCondEspeciales(pP.getCondEspeciales());
			pBean.setHorarioDeEntregaDesde(pP.getHorarioDeEntregaDesde());
			pBean.setHorarioDeEntregahasta(pP.getHorarioDeEntregahasta());
			pBean.setEstado(pP.getEstado());
			pBean.setDirDeRetiroSoloEmpresa(pP.getDirDeRetiroSoloEmpresa());
			pBean.setPrioridad(pP.getPrioridad());
			pBean.setCliente(this.convertClientePersistenciaToBean(pP.getCliente()));
			pBean.setSucursal(this.convertSucursalPersistenciaToBean(pP.getSucursal()));
			for(MercaderiaPersistencia mP : pP.getMercaderias())
			{
				MercaderiaBean mB=this.convertMercaderiaPersistenciaToBean(mP);
				pBean.addMercaderia(mB);
			}
			pBean.setDestinatarios(null);
			pBean.setConsideraciones(null);

			listaPedidoBean.add(pBean);
		}
		return listaPedidoBean;
	}

	private MercaderiaBean convertMercaderiaPersistenciaToBean(MercaderiaPersistencia mp)
	{
		MercaderiaBean mb=null;
		if(mp.getClass().getName().equals(MercaderiaPorPesoPersistencia.class.getName()))
			mb=new MercaderiaPorPesoBean();
		if(mp.getClass().getName().equals(MercaderiaPorVolumenPersistencia.class.getName()))
			mb=new MercaderiaPorVolumenBean();
		mb.setAlto(mp.getAlto());
		mb.setAncho(mp.getAncho());
		mb.setCondDeViaje(mp.getCondDeViaje());
		mb.setCoordenadasDestino(mp.getCoordenadasDestino());
		mb.setDeposito(this.convertDepositoPersistenciaToBean(mp.getDeposito()));		
		mb.setFragilidad(mp.getFragilidad());
		mb.setIdMercaderia(mp.getIdMercaderia());
		mb.setIndicacionesManpulacion(mp.getIndicacionesManpulacion());
		mb.setProfundidad(mp.getProfundidad());
		mb.setRemito(this.convertRemitoPersistenciaToBean(mp.getRemito()));
		return mb;
	}

	private DepositoBean convertDepositoPersistenciaToBean(DepositoPersistencia dp)
	{
		DepositoBean db=new DepositoBean();
		db.setIdDeposito(dp.getIdDeposito());
		db.setCantidadMax(dp.getCantidadMax());
		db.setEncargado(db.getEncargado());
		db.setSuc(this.convertSucursalPersistenciaToBean(dp.getSuc()));
		return db;
	}


	private RemitoBean convertRemitoPersistenciaToBean(RemitoPersistencia rp)
	{
		RemitoBean rb=new RemitoBean();
		rb.setEstado(rp.getEstado());
		rb.setNroRemito(rp.getNroRemito());
		return rb;
	}
	private ClienteBean convertClientePersistenciaToBean(ClientePersistencia cP)
	{
		ClienteBean cB=null;
		if(cP.getClass().getName().equals(EmpresaPersistencia.class.getName())){
			cB=new EmpresaBean();
		}
		if(cP.getClass().getName().equals(ParticularPersistencia.class.getName())){
			cB=new ParticularBean();
		}
		cB.setIdCliente(cP.getIdCliente());
		cB.setDireccion(cP.getDireccion());
		cB.setTelefono(cP.getTelefono());
		return cB;
	}

	private SucursalBean convertSucursalPersistenciaToBean(SucursalPersistencia sp)
	{
		SucursalBean sb=new SucursalBean();
		sb.setDir(sp.getDir());
		sb.setEncDespacho(sp.getEncDespacho());
		sb.setEncRecepcion(sp.getEncRecepcion());
		sb.setGerente(sp.getGerente());
		sb.setNombre(sp.getNombre());
		sb.setNumeroSucursal(sp.getNumeroSucursal());

		return sb;
	}

	public List<PedidoBean> getPedidosPorEstado(String estado) {
		List<PedidoPersistencia> pedEstado=new ArrayList<PedidoPersistencia>();
		pedEstado=DAOPedido.getInstance().getPedidosPorEstado(estado);
		List<PedidoBean> pedidosBean=convertPedidosPersistenciaToBean(pedEstado);
		return pedidosBean;
	}

	public PedidoBean getPedido(int numeroPedido) 
	{
		PedidoPersistencia pp=DAOPedido.getInstance().getPedidoPorEstado(numeroPedido);
		PedidoBean pb=this.convertPedidoPersistenciaToBean(pp);		
		return pb;
	}

	private PedidoBean convertPedidoPersistenciaToBean(PedidoPersistencia pP) {
		PedidoBean pBean=new PedidoBean();
		pBean.setManifiesto(pP.getManifiesto());
		pBean.setIdPedido(pP.getIdPedido());
		pBean.setDirDestino(pP.getDirDestino());
		pBean.setFechaEnregaMaxima(pP.getFechaEnregaMaxima());
		pBean.setFechaEnregaMaxima(pP.getFechaEntregaEstimada());
		pBean.setCondEspeciales(pP.getCondEspeciales());
		pBean.setHorarioDeEntregaDesde(pP.getHorarioDeEntregaDesde());
		pBean.setHorarioDeEntregahasta(pP.getHorarioDeEntregahasta());
		pBean.setEstado(pP.getEstado());
		pBean.setDirDeRetiroSoloEmpresa(pP.getDirDeRetiroSoloEmpresa());
		pBean.setPrioridad(pP.getPrioridad());
		pBean.setCliente(this.convertClientePersistenciaToBean(pP.getCliente()));
		pBean.setSucursal(this.convertSucursalPersistenciaToBean(pP.getSucursal()));
		for(MercaderiaPersistencia mP : pP.getMercaderias())
		{
			MercaderiaBean mB=this.convertMercaderiaPersistenciaToBean(mP);
			pBean.addMercaderia(mB);
		}
		pBean.setDestinatarios(null);
		pBean.setConsideraciones(null);

		return pBean;
	}



}
