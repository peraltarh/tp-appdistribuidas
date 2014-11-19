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
import dao.entities.CarrierPersistencia;
import dao.entities.ClientePersistencia;
import dao.entities.ConsideracionEspecialPersistencia;
import dao.entities.CuentaCorrientePersistencia;
import dao.entities.DepositoPersistencia;
import dao.entities.DestinatarioPersistencia;
import dao.entities.EmpresaPersistencia;
import dao.entities.EmpresaDirValidasPersistencia;
import dao.entities.MantenimientoRealizadoPersistencia;
import dao.entities.MapaDeRutaPersistencia;
import dao.entities.MercaderiaPersistencia;
import dao.entities.MercaderiaPorPesoPersistencia;
import dao.entities.MercaderiaPorVolumenPersistencia;
import dao.entities.MovimientoCuentaPersistencia;
import dao.entities.MovimientoPersistencia;
import dao.entities.ParticularPersistencia;
import dao.entities.PedidoPersistencia;
import dao.entities.PlanDeMantenimientoPersistencia;
import dao.entities.ProductoPersistencia;
import dao.entities.RemitoPersistencia;
import dao.entities.SucursalPersistencia;
import dao.entities.VehiculoExternoPersistencia;
import dao.entities.VehiculoPersistencia;



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

	public void addSucursal(Sucursal sucursal) {
		this.sucursales.add(sucursal);
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
	
	//Buscar en memoria Empresas
	public Empresa buscarClienteEmpresa(String cuit){
		Empresa empT = null;
		
		for (Cliente clienteT : clientes) {
			if(clienteT instanceof Empresa){
				if(((Empresa)clienteT).getCuit().equals(cuit)){
					empT = (Empresa) clienteT;
					break;
				}
			}
		}
		if(empT==null){
			empT = convertEmpresaPersistenciaToNegocio(buscarClienteEmpresaEnDao(cuit));
			this.clientes.add(empT);
		}
		
		return empT;
	}
	
	//Buscar en BD Empresas
	public EmpresaPersistencia buscarClienteEmpresaEnDao(String cuit)
	{
		return DAOCliente.getInstance().getClienteEmpresa(cuit);

	}
	
	//Buscar en memoria Particulares
	public Particular buscarParticular (String dni){
		Particular parT = null;
		
		for (Cliente clienteT : clientes) {
			if(clienteT instanceof Particular){
				if(((Particular)clienteT).getDni().equals(dni)){
					parT = (Particular) clienteT;
					break;
				}
			}
		}
		if(parT==null){
			parT = convertParticularPersistenciaToCliente(buscarClienteParticularEnDao(dni));
			addCliente(parT);
		}
		
		return parT;
	}
	
	//Buscar en BD Particulares
	public ParticularPersistencia buscarClienteParticularEnDao(String dni)
	{
		return DAOCliente.getInstance().getClienteParticular(dni);

	}
	
	//Buscar en memoria Sucursales
	public Sucursal buscarSucursal (String sucursal){
		Sucursal sucT = null;
		
		for (Sucursal sucursalTemp : sucursales) {
				if(sucursalTemp.getNombre().equals(sucursal)){
					sucT = sucursalTemp;
					break;
				}
			
		}
		if(sucT==null){
			sucT = convertSucursalPersistenciaToNegocio(buscarSucursalEnBD(sucursal));
			addSucursal(sucT);
		}
		
		return sucT;
	}

	//Buscar en BD Sucursales
	public SucursalPersistencia buscarSucursalEnBD(String sucursal){
		return DAOSucursal.getInstance().getSucursal(sucursal);
	}
	

	public void altaPedido(String manifiesto, String dirDestino,
			Date fechaEnregaMaxima, Date fechaEntregaEstimada,
			String condEspeciales, Date horarioDeEntregaDesde,
			Date horarioDeEntregahasta, String dirDeRetiroSoloEmpresa,
			int prioridad, String estado, String sucursal, String idCliente,
			String tipoId)
	{
		Cliente cS = null;
		ClientePersistencia cP=null;
		if(tipoId.equals("cuit"))
		{
			cS = buscarClienteEmpresa(idCliente);
			//TODO validar que ande la convercion
			cP=convertEmpresaSistemaToPersistencia(cS);
			//cP=DAOCliente.getInstance().getClienteEmpresa(idCliente);
		}
		if(tipoId.equals("dni"))
		{
			cS = buscarClienteEmpresa(idCliente);
			//TODO validar que ande la convercion
			cP=convertParticularSistemaToPersistencia(cS);
			//cP=DAOCliente.getInstance().getClienteParticular(idCliente);
		}

		//TODO validar que ande la conversion
		SucursalPersistencia suc=buscarSucursalEnBD(sucursal);
		
		PedidoPersistencia pedido=new PedidoPersistencia(manifiesto, dirDestino, fechaEnregaMaxima, fechaEntregaEstimada, condEspeciales, horarioDeEntregaDesde, horarioDeEntregahasta, dirDeRetiroSoloEmpresa, prioridad, estado,suc, cP);
		DAOPedido.getInstance().persistir(pedido);
	}

	//CONVERT CLIENTE NEGOCIO TO CLIENTE PERSISTENCIA START
	
	private ParticularPersistencia convertParticularSistemaToPersistencia(
			Cliente cS) {
		ParticularPersistencia cP = new ParticularPersistencia(
										cS.getDireccion(),
										cS.getTelefono(),
										((Particular)cS).getNombre(),
										((Particular)cS).getApellido(),
										((Particular)cS).getDni());
		return cP;
	}

	private EmpresaPersistencia convertEmpresaSistemaToPersistencia(Cliente cS) {
		EmpresaPersistencia cp= new EmpresaPersistencia(
									cS.getDireccion(),
									cS.getTelefono(),
									((Empresa)cS).getRazonSoial(),
									((Empresa)cS).getCuit(),
									((Empresa)cS).getRegularidad());
		
		
		for (CuentaCorriente ccTem : ((Empresa)cS).getCuentasCorrientes()) {
			cp.addCuentaCorriente(convertCuentaCorrienteNegocioToPersistencia(ccTem, cp));	
		}
		for (EmpresaDirValidas dValidTemp : ((Empresa)cS).getDireccionesValidas()) {
			cp.addDireccionValida(convertDireccionValidaNegocioToPersistencia(dValidTemp,cp));
		}
		for (Producto prodTemp : ((Empresa)cS).getProductosValidos()) {	
			cp.addProductoValido(convertProductoValidoNegocioToPersistencia(prodTemp, cp));
		}
		return cp;
	}

	private ProductoPersistencia convertProductoValidoNegocioToPersistencia(
			Producto prodTemp, EmpresaPersistencia ep) {
		ProductoPersistencia prodP = new ProductoPersistencia(
				prodTemp.getTipo(), prodTemp.getDescripcion(), ep);
		return prodP;
	}

	private EmpresaDirValidasPersistencia convertDireccionValidaNegocioToPersistencia(
			EmpresaDirValidas dValidTemp, EmpresaPersistencia ep) {
		EmpresaDirValidasPersistencia dvP = new EmpresaDirValidasPersistencia(
				dValidTemp.getDireccion(), dValidTemp.getTel(), ep);
		return dvP;
	}

	private CuentaCorrientePersistencia convertCuentaCorrienteNegocioToPersistencia(
			CuentaCorriente ccTem, EmpresaPersistencia ep) {
		CuentaCorrientePersistencia ccP = new CuentaCorrientePersistencia(
													ccTem.getCbu(),
													ccTem.getSaldoActual(),
													ccTem.getMinimoPermitidoSinAuth(),
													ccTem.isEstado(),
													ep);
		for (MovimientoCuenta movTemp : ccTem.getMovimientos()) {
			ccP.addMovimiento(convertMovimientoCuentaNegocioToPersistencia(movTemp, ccP));
		}
		
		return ccP;
	}

	private MovimientoCuentaPersistencia convertMovimientoCuentaNegocioToPersistencia(
			MovimientoCuenta movTemp,CuentaCorrientePersistencia ccP) {
		MovimientoCuentaPersistencia movP = new MovimientoCuentaPersistencia(
				movTemp.getFecha(),
				movTemp.getMonto(),
				ccP);
		return movP;
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

	//CONVERT CLIENTE NEGOCIO TO CLIENTE PERSISTENCIA END
	
	//CONVERT SUCURSAL PERSISTENCIA TO SUCURSAL NEGCIO START
	
	private Sucursal convertSucursalPersistenciaToNegocio(
			SucursalPersistencia sucBd) {
		
		Sucursal sucT = new Sucursal(
				sucBd.getNumeroSucursal(),
				sucBd.getNombre(),
				sucBd.getDir(),
				sucBd.getGerente(),
				sucBd.getEncDespacho(),
				sucBd.getEncRecepcion());
		
		for (DepositoPersistencia depP : sucBd.getDepositos()) {
			sucT.addDeposito(convertDepositoPersistenciaToNegocio(depP));
		};
		for (PedidoPersistencia pedP : sucBd.getPedidos()) {
			//TODO buscar el pedido en memoria primero
			sucT.addPedido(convertPedidoPersistenciaToNegocio(pedP));
		};
		for (MapaDeRutaPersistencia mapP : sucBd.getRutas()) {
			sucT.addRuta(convertMapaRutaPersistenciaToNegocio(mapP));
		};
		for (VehiculoPersistencia vehP : sucBd.getVehiculos()) {
			//TODO buscar el vehiculo en memoria primero
			sucT.addVehiculo(convertVehiculoPersistenciaToNegocio(vehP));
		};
		
		return sucT;
	}
	
	private Deposito convertDepositoPersistenciaToNegocio(
			DepositoPersistencia depP) {
		Deposito depN = new Deposito(
				depP.getCantidadMax(),
				depP.getEncargado());
		
		for (MercaderiaPersistencia mercP : depP.getMercaderias()) {
			depN.addMercaderia(convertMercaderiaPersistenciaToNegocio(mercP));
		}
		
		depP.getAreas();
		
		
		return depN;
	}
	


	//CONVERT SUCURSAL PERSISTENCIA TO SUCURSAL NEGOCIO END
	
	//CONVERT VEHICLULO PERSISTENCIA TO VEHICLULO NEGOCIO START

	private Vehiculo convertVehiculoPersistenciaToNegocio(
			VehiculoPersistencia vehP) {
		Vehiculo vehN = new Vehiculo(
				vehP.getPesoMax(),
				vehP.getVolumenMax(),
				vehP.getCondEspeciales(),
				vehP.getTara(),
				vehP.getPatente(),
				String.valueOf(vehP.getNroChasis()),
				vehP.getTipo(),
				vehP.getKilometrakeActual(),
				vehP.getKilometrajemaximo(),
				vehP.getModelo(), 
				vehP.getCoordenadaActual(),
				vehP.getEstado(),
				vehP.getNumeroPolizaSeguro(),
				vehP.getExpiracionGarantia());
		
		for (PlanDeMantenimientoPersistencia pmP : vehP.getMantenimientosPlaneados()) {
			vehN.addMantenimientoPlaneado(convertPlanDeMantenimientoPersistenciaToNegocio(pmP));
		}
		for (MantenimientoRealizadoPersistencia mrP : vehP.getMantenimientosRealizados()) {
			vehN.addMantenimientoRealizado(convertMantenimientoRealizadoPersistenciaToNegocio(mrP));
		}
		return vehN;
	}

	private MantenimientoRealizado convertMantenimientoRealizadoPersistenciaToNegocio(
			MantenimientoRealizadoPersistencia mrP) {
		MantenimientoRealizado mrN = new MantenimientoRealizado(
				mrP.getDescripcion(),
				mrP.getCosto(),
				mrP.getFecha(),
				mrP.getKilometrajeActual(),
				mrP.getKilometrosRealizadosDesdeUltimoControl(),
				mrP.getTipo());
		return mrN;
	}

	private PlanDeMantenimiento convertPlanDeMantenimientoPersistenciaToNegocio(
			PlanDeMantenimientoPersistencia pmP) {
		PlanDeMantenimiento pmN = new PlanDeMantenimiento(
				pmP.getCantKilometros(),
				pmP.getTipo(),
				pmP.getControlEspecial());
		return pmN;
	}

	private MapaDeRuta convertMapaRutaPersistenciaToNegocio(
			MapaDeRutaPersistencia mapP) {
		MapaDeRuta mrN = new MapaDeRuta(
				mapP.getNumSucOrigen(),
				mapP.getNumSucDestino(),
				mapP.getDuracionHs(),
				mapP.getCosto(),
				mapP.getDistancia());
		return mrN;
	}
	
	//CONVERT VEHICLULO PERSISTENCIA TO VEHICLULO NEGOCIO END

	//CONVERT PEDIDO PERSISTENCIA TO PEDIDO NEGOCIO START
	
	private Pedido convertPedidoPersistenciaToNegocio(
			PedidoPersistencia pedP) {
		Pedido pedN = new Pedido(
				pedP.getManifiesto(),
				pedP.getDirDestino(),
				pedP.getFechaEnregaMaxima(),
				pedP.getFechaEntregaEstimada(),
				pedP.getCondEspeciales(),
				pedP.getHorarioDeEntregaDesde(),
				pedP.getHorarioDeEntregahasta(),
				pedP.getDirDeRetiroSoloEmpresa(),
				pedP.getPrioridad());
		
		for (ConsideracionEspecialPersistencia condEsP : pedP.getConsideraciones()) {
			pedN.addConsideraciones(convertConsideracionEspecialPersistenciaToNegocio(condEsP));
		}
		for (DestinatarioPersistencia detP : pedP.getDestinatarios()) {
			pedN.addDestinatario(convertDestinatarioPersistenciaToNegocio(detP));
		}
		for (MercaderiaPersistencia merP : pedP.getMercaderias()) {
			pedN.addMercaderia(convertMercaderiaPersistenciaToNegocio(merP));
		}

		return pedN;
	}

	private Destinatario convertDestinatarioPersistenciaToNegocio(
			DestinatarioPersistencia detP) {
		Destinatario desN = new Destinatario(
				detP.getNombre(),
				detP.getApellido(),
				detP.getDni());
		return desN;
	}

	private ConsideracionEspecial convertConsideracionEspecialPersistenciaToNegocio(
			ConsideracionEspecialPersistencia condEsP) {
		ConsideracionEspecial condEsN = new ConsideracionEspecial(
				condEsP.isEntregaInmediata(),
				condEsP.isRequiereAvioneta(),
				condEsP.isAutorizacionAvioneta(),
				condEsP.isRequiereCamionExterno(), 
				condEsP.getCostoExtra());
		for (CarrierPersistencia carP : condEsP.getCarriers()) {
			condEsN.addCarrier(convertCarrierPersistenciaToNegocio(carP));
		}
		for (VehiculoExternoPersistencia vextP : condEsP.getvExternos()) {
			condEsN.addvExterno(convertVehiculoExternoPersistenaciaToNegocio(vextP));
		}
		return condEsN;
	}

	private VehiculoExterno convertVehiculoExternoPersistenaciaToNegocio(
			VehiculoExternoPersistencia vextP) {
		VehiculoExterno vextN = new VehiculoExterno(
				vextP.getTipo(),
				vextP.getIdentificacion(),
				vextP.getCapacidadCarga());
		return vextN;
	}

	private Carrier convertCarrierPersistenciaToNegocio(CarrierPersistencia carP) {
		Carrier carN = new Carrier(
				carP.getOrigen(),
				carP.getDestino(),
				carP.getCosto());
		return carN;
	}

	private Mercaderia convertMercaderiaPersistenciaToNegocio(
			MercaderiaPersistencia mercP) {
		Mercaderia mercN = new Mercaderia(
				mercP.getAlto(),
				mercP.getAncho(),
				mercP.getProfundidad(),
				mercP.getFragilidad(),
				mercP.isApilable(),
				mercP.getCantApilable(),
				mercP.getCondDeViaje(),
				mercP.getIndicacionesManpulacion(),
				mercP.getCoordenadasDestino());

		for (MovimientoPersistencia movP : mercP.getMovimientos()) {
			mercN.addMovimiento(convertMovimientoMercaderiaPersistenciaToNegocio(movP));
		};
		
		return mercN;
	}
	
	private Movimiento convertMovimientoMercaderiaPersistenciaToNegocio(
			MovimientoPersistencia movP) {
		Movimiento movN = new Movimiento(
				movP.getFechaSalida(),
				movP.getFechaLlegada(),
				movP.getOrigen(),
				movP.getDestino(),
				movP.getCondicionDeArribo(),
				movP.getEstado());
		return movN;
	}
	//CONVERT PEDIDO PERSISTENCIA TO PEDIDO NEGOCIO END
	
	
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
		mb.setRemito(null);
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
		MercaderiaBean mB=null;
		for(MercaderiaPersistencia mP : pP.getMercaderias())
		{
			mB=this.convertMercaderiaPersistenciaToBean(mP);
			pBean.addMercaderia(mB);
		}
		pBean.setDestinatarios(null);
		pBean.setConsideraciones(null);

		return pBean;
	}



}
