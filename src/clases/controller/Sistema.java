package clases.controller;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import beans.*;
import clases.*;
import clases.Pedido.ESTADO_DE_PEDIDO;
import clases.Vehiculo.ESTADO_VEHICULO;
import dao.*;
import dao.entities.*;




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



	//ALTAS START

	public ParticularBean altaParticular(String direccion, String telefono, String nombre, String apellido, String dni)
	{
		ClientePersistencia cP = null;
		for(Cliente cliente: clientes)
		{
			if((cliente.getClass()==Particular.class)&&((Particular)cliente).getDni().equals(dni))
				break;
		}		
		ParticularPersistencia p= new ParticularPersistencia(direccion, telefono,nombre,apellido,dni);
		cP = DAOCliente.getInstance().persistirParticular(p);
		Particular cN=(Particular) convertClientePersistenciaToNegocio(cP);

		this.clientes.add(cN);
		ParticularBean cB=new ParticularBean();
		cB=	(ParticularBean) Converter.getInstance().convertParticularNegocioToBean(cN);
		return (ParticularBean) cB;
	}

	public void altaEmpresa(String direccion, String telefono, String razonSocial, String cuit, String regularidad) 
	{
		for(Cliente cliente: clientes)
		{
			if((cliente.getClass()==Empresa.class)&&((Empresa)cliente).getCuit().equals(cuit))
				return;
		}	
		EmpresaPersistencia e=new EmpresaPersistencia(direccion,telefono,razonSocial,cuit,regularidad);
		ClientePersistencia cP = DAOCliente.getInstance().persistirEmpresa(e);
		this.clientes.add(convertClientePersistenciaToNegocio(cP));
	}


	public void altaCuentaCorriente(int cbu, float saldoActual, float minimoPermitidoSinAuth, String cuit) {
		EmpresaPersistencia empresa=DAOCliente.getInstance().getClienteEmpresa(cuit);
		CuentaCorrientePersistencia cc=new CuentaCorrientePersistencia(cbu, saldoActual, minimoPermitidoSinAuth, true, empresa);
		empresa.addCuentaCorriente(cc);
		DAOCliente.getInstance().persistirEmpresa(empresa);
		for(Cliente cliente: clientes)
		{
			if((cliente.getClass()==Empresa.class)&&((Empresa)cliente).getCuit().equals(cuit))
			{
				cliente = empresa.toNegocio();
				return;
			}
		}
		clientes.add(empresa.toNegocio());
	}

	public void altaProducto(String tipo, String descripcion, String cuit) {
		EmpresaPersistencia empresa=DAOCliente.getInstance().getClienteEmpresa(cuit);
		ProductoPersistencia p=new ProductoPersistencia(tipo, descripcion, empresa);
		empresa.addProductoValido(p);
		DAOCliente.getInstance().update(empresa);
		for(Cliente cliente: clientes)
		{
			if((cliente.getClass()==Empresa.class)&&((Empresa)cliente).getCuit().equals(cuit))
			{
				cliente = empresa.toNegocio();
				return;
			}
		}
		clientes.add(empresa.toNegocio());
	}

	public void altaSucursal(String nombre, String dir, String gerente, String encDespacho, String encRecepcion) {
		for(Sucursal sucursal: sucursales)
		{
			if(sucursal.getNombre().equals(nombre))
				return;
		}	
		SucursalPersistencia suc=new SucursalPersistencia(nombre, dir, gerente, encDespacho, encRecepcion);
		SucursalPersistencia sucP = DAOSucursal.getInstance().persistirSucursal(suc);
		this.sucursales.add(convertSucursalPersistenciaToNegocio(sucP));
	}

	public void altaDeposito(float cantidadMax, String encargado, String sucursal) {
		SucursalPersistencia suc=DAOSucursal.getInstance().getSucursal(sucursal);
		DepositoPersistencia dep=new DepositoPersistencia(cantidadMax, encargado, suc);
		DAODeposito.getInstance().persistirDeposito(dep);
		for(Sucursal sucursal_mem: sucursales)
		{
			if(sucursal_mem.getNombre().equals(sucursal))
			{
				sucursal_mem = convertSucursalPersistenciaToNegocio(suc);
				return;
			}
		}	
		this.sucursales.add(convertSucursalPersistenciaToNegocio(suc));
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
		for(Cliente cliente: clientes)
		{
			if((cliente.getClass()==Empresa.class)&&((Empresa)cliente).getCuit().equals(cuit))
			{
				cliente = empresa.toNegocio();
				return;
			}
		}
		clientes.add(empresa.toNegocio());
	}

	@SuppressWarnings("deprecation")
	public int altaPedido(String manifiesto, String dirDestino,
			Date fechaEnregaMaxima, Date fechaEntregaEstimada,
			String condEspeciales, Time horarioDeEntregaDesde,
			Time horarioDeEntregahasta, String dirDeRetiroSoloEmpresa,
			int prioridad, String estado, String sucursal, String idCliente, String tipoId)
	{
		Cliente cS = null;
		ClientePersistencia cP=null;
		if(tipoId.equals("cuit"))
		{
			cS = buscarClienteEmpresa(idCliente);
			cP=convertEmpresaNegocioToPersistencia(cS);
		}
		if(tipoId.equals("dni"))
		{
			cS = buscarClienteParticular(idCliente);
			cP=convertParticularNegocioToPersistencia(cS);
		}

		//Fuerzo esto porque es un pedido nuevo
		estado = "SIN_PROCESAR";
		
		java.util.Date date=new GregorianCalendar().getTime();
		
		

		
		Sucursal sucS = buscarSucursal(sucursal);
		Sucursal sucDes = buscarSucursal(dirDestino);
		
		int cantHoras = sucS.obtenerTiempoDeEntregaA(sucDes.getNumero());
		int cantDias = (cantHoras/24);
		
		if(cantDias>0) cantHoras = cantHoras - (cantDias*24);
		

		String sDate=(date.getYear()+"-"+date.getMonth()+"-"+date.getDay());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(sDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.add(Calendar.DATE, cantDias);  // number of days to add
		sDate = sdf.format(c.getTime());
		
		
		fechaEntregaEstimada = java.sql.Date.valueOf(sDate);
		SucursalPersistencia suc = convertSucursalNegocioToPersistencia(sucS);
		PedidoPersistencia pedido=new PedidoPersistencia(manifiesto, dirDestino, fechaEnregaMaxima, fechaEntregaEstimada, condEspeciales, horarioDeEntregaDesde, horarioDeEntregahasta, dirDeRetiroSoloEmpresa, prioridad, estado,suc, cP);
		PedidoPersistencia pedP = DAOPedido.getInstance().persistir(pedido);
		this.pedidos.add(convertPedidoPersistenciaToNegocio(pedP));
		return pedP.getIdPedido();
	}

	public int altaPedidoBean(PedidoBean pb)
	{
		Cliente cS = Converter.getInstance().convertClienteBeanToNegocio(pb.getCliente());
		ClientePersistencia cP=convertClienteNegocioToPersistencia(cS);
		Sucursal sucS = buscarSucursal(pb.getSucursal().getNombre());
		
		Sucursal sucDes = buscarSucursal(pb.getDirDestino());
		
		int cantHoras = sucS.obtenerTiempoDeEntregaA(sucDes.getNumero());
		int cantDias = (cantHoras/24);
		
		if(cantDias>0) cantHoras = cantHoras - (cantDias*24);
		
		java.util.Date date=new GregorianCalendar().getTime();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH)+1 ;
		int year = cal.get(Calendar.YEAR);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		String sDate=(year+"-"+month+"-"+day);
		System.out.println();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(sDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.add(Calendar.DATE, cantDias);  // number of days to add
		sDate = sdf.format(c.getTime());
		
		
		Date fechaEntregaEstimada = java.sql.Date.valueOf(sDate);
		pb.setFechaEntregaEstimada(fechaEntregaEstimada);
		
		SucursalPersistencia sP=convertSucursalNegocioToPersistencia(sucS);
		pb.setEstado("SIN_PROCESAR");
		PedidoPersistencia pedido=new PedidoPersistencia(pb.getManifiesto(), pb.getDirDestino()
				,pb.getFechaEnregaMaxima(),pb.getFechaEntregaEstimada()
				,pb.getCondEspeciales(),pb.getHorarioDeEntregaDesde(),pb.getHorarioDeEntregahasta()
				,pb.getDirDeRetiroSoloEmpresa()
				,pb.getPrioridad(),pb.getEstado(),sP, cP);

		PedidoPersistencia pedP = DAOPedido.getInstance().persistir(pedido);
		this.pedidos.add(convertPedidoPersistenciaToNegocio(pedP));
		return pedP.getIdPedido();
	}

	//ALTAS END

	//UPDATES START
	
	//Agrega una mercaderia a un Pedido TODO Revisar
	public void actualizarPedido(PedidoBean pB) {
		
		//Obtengo la mercaderia nueva
		MercaderiaBean mercB = pB.getMercaderias().get(pB.getMercaderias().size()-1);
		
		//Busco el pedido en memoria
		PedidoPersistencia pedP = DAOPedido.getInstance().getPedido(pB.getIdPedido());
		Mercaderia mercN = Converter.getInstance().convertMercaderiaBeanToNegocio(mercB);
		
		DepositoPersistencia dP=DAODeposito.getInstance().getDeposito(mercB.getDeposito().getEncargado());
		
		MercaderiaPersistencia mercP = convertMercaderiaNegocioToPersistencia(mercN, pedP, null, dP);
		
		boolean contieneMerc = false;
		MercaderiaPersistencia merAMod = null;
		for (MercaderiaPersistencia mercTemp : pedP.getMercaderias()) {
			if(mercTemp.getIdMercaderia()==mercP.getIdMercaderia()){
				contieneMerc = true;
				merAMod = mercTemp;
				break;
			}

			
		}
		if(!contieneMerc)pedP.addMercaderia(mercP);
		else{
			MovimientoBean movB = mercB.getMovimientos().get(mercB.getMovimientos().size()-1);
			Movimiento movNeg = Converter.getInstance().convertMovimientoMercaderiaBeanToNegocio(movB);
			merAMod.addMovimiento(convertMovimientomercaderiaNegocioToPersistencia(movNeg, merAMod));	
		};
		DAOPedido.getInstance().update(pedP);
		reemplazarPedidoViejoConNuevo(convertPedidoPersistenciaToNegocio(pedP));
		
//		
//		Pedido pedN = buscarPedido(pB.getIdPedido());
//		pedN.addMercaderia(Converter.getInstance().convertMercaderiaBeanToNegocio(mercB));
//		
//		Pedido pS=Converter.getInstance().convertPedidoBeanToNegocio(pB);
//		SucursalPersistencia sP=buscarSucursalEnBD(pB.getSucursal().getNombre());
//		PedidoPersistencia pP=convertPedidoNegocioToPersistencia(pS, sP);
//		pP.setIdPedido(pB.getIdPedido());
//		DepositoPersistencia dP=DAODeposito.getInstance().getDeposito(mercB.getDeposito().getEncargado());
//		PedidoPersistencia pP2=DAOPedido.getInstance().getPedido(pB.getIdPedido());
//		pP2.setMercaderias(pP.getMercaderias());
//		pP2.getMercaderias().get(pP2.getMercaderias().size()-1).setDeposito(dP);
//		DAOPedido.getInstance().update(pP2);
//		
//		reemplazarPedidoViejoConNuevo(convertPedidoPersistenciaToNegocio(pP));
		
		}
	
	//UPDATES END
	
	//NEGOCIO START
	
	private void reemplazarPedidoViejoConNuevo(
			Pedido pedN) {
		for (Pedido pedTemp : pedidos) {
			if(pedTemp.getIdPedido() == pedN.getIdPedido()){
				pedidos.remove(pedTemp);
				break;
			}
		}
		pedidos.add(pedN);
		
	}

	public String cerrarPedido (PedidoBean pedB){
		Sucursal sucN = buscarSucursal(pedB.getSucursal().getNombre());
		Pedido pedN = buscarPedido(pedB.getIdPedido());
		return sucN.ProgramarEnvio(pedN);
	}
	

	
	//NEGOCIO END
	

	//BUSQUEDAS START


	private Pedido buscarPedido(int idPedido) {
		for (Pedido pedidoN : pedidos) {
			if(pedidoN.getIdPedido() == idPedido){
				return pedidoN;
			}
		}
		
		Pedido ped=convertPedidoPersistenciaToNegocio (DAOPedido.getInstance().getPedido(idPedido));
		pedidos.add(ped);
		return ped;
		
	}

	//Buscar en BD Depositos de Scurusal
	public List<DepositoPersistencia> buscarDepositosParaSucursalEnBd(int idSucursal) {
		List<DepositoPersistencia> depositos=new ArrayList<DepositoPersistencia>();
		depositos=DAODeposito.getInstance().getDepositos(idSucursal);
		return depositos;
	}

	public ClienteBean getClienteBean (String tipo, String numero){
		ClienteBean cB = null;

		if(tipo.equalsIgnoreCase("dni")){
			Particular cN = buscarClienteParticular(numero);
			cB = Converter.getInstance().convertParticularNegocioToBean(cN);

		}else if(tipo.equalsIgnoreCase("cuit")){
			Empresa cN = buscarClienteEmpresa(numero);
			cB = Converter.getInstance().convertEmpresaNegocioToBean(cN);
		}

		return cB;
	}

	public SucursalBean getSucursalBean (String sucursal){
		SucursalBean cB = null;

		SucursalPersistencia sP = buscarSucursalEnBD(sucursal);
		cB = convertSucursalPersistenciaToBean(sP);

		return cB;
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
			if (empT == null)return null; //Validar que se econtro
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
	public Particular buscarClienteParticular (String dni){
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
			parT = convertParticularPersistenciaToNegocio(buscarClienteParticularEnDao(dni));
			if (parT == null)return null; //Validar que se econtro
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
	
	public ArrayList<String> getListaSucursalesBean(){
		
		ArrayList<String> sucS = new ArrayList<String>();
		for (Sucursal sucN : buscarSucursales()) {
			sucS.add(sucN.getNombre());
		} 
		return sucS;
	}
	
	
	public ArrayList<Sucursal> buscarSucursales(){
		
		ArrayList<Sucursal> listSuc = new ArrayList<Sucursal>();
		
		for (SucursalPersistencia sucP : DAOSucursal.getInstance().getListSucursales()) {
			listSuc.add(convertSucursalPersistenciaToNegocio(sucP));
		}
		this.sucursales = listSuc;
		
		return listSuc;
	}


	// buscar Vehiculos en memoria
	public Vehiculo buscarVehiculo(String patente_)
	{
		for (Vehiculo vehiculo : vehiculos) 
		{
			if(vehiculo.getPatente().equals(patente_))
				return vehiculo;
		}
		Vehiculo vehTemp = convertVehiculoPersistenciaToNegocio(buscarVehiculoEnBD(patente_));
//		Vehiculo vehTemp = buscarVehiculoEnBD(patente_).toNegocio();
		vehiculos.add(vehTemp);
		
		return vehTemp;
	}
	// buscar Vehiculos en BD
	public VehiculoPersistencia buscarVehiculoEnBD(String patente_)
	{
		return DAOVehiculo.getInstance().getVehiculo(patente_);
	}


	//BUSQUEDAS END


	//CONVERT NEGOCIO TO PERSISTENCIA START

	//CONVERT CLIENTE NEGOCIO TO CLIENTE PERSISTENCIA START

	private ParticularPersistencia convertParticularNegocioToPersistencia(
			Cliente cS) {
		ParticularPersistencia cP = new ParticularPersistencia();
		cP.setApellido(((Particular)cS).getApellido());
		cP.setDireccion(cS.getDireccion());
		cP.setDni(((Particular)cS).getDni());
		cP.setNombre(((Particular)cS).getNombre());
		cP.setTelefono(cS.getTelefono());
		cP.setIdCliente(cS.getIdCliente());
		return cP;
	}

	private EmpresaPersistencia convertEmpresaNegocioToPersistencia(Cliente cS) {
		EmpresaPersistencia cp= new EmpresaPersistencia();
		cp.setCuit(((Empresa)cS).getCuit());
		cp.setDireccion(cS.getDireccion());
		cp.setRazonSoial(((Empresa)cS).getRazonSoial());
		cp.setRegularidad(((Empresa)cS).getRegularidad());
		cp.setTelefono(cS.getTelefono());
		cp.setIdCliente(cS.getIdCliente());

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
		ProductoPersistencia prodP = new ProductoPersistencia();
		prodP.setDescripcion(prodTemp.getDescripcion());
		prodP.setEmpresa(ep);
		prodP.setTipo(prodTemp.getTipo());
		prodP.setIdProd(prodTemp.getIdProd());
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

	private Particular convertParticularPersistenciaToNegocio(ParticularPersistencia pP)
	{
		if(pP == null)return null;
		Particular p=new Particular();
		p.setApellido(pP.getApellido());
		p.setDireccion(pP.getDireccion());
		p.setDni(pP.getDni());
		p.setNombre(pP.getNombre());
		p.setTelefono(pP.getTelefono());
		p.setIdCliente(pP.getIdCliente());
		return p;
	}

	private Empresa convertEmpresaPersistenciaToNegocio(EmpresaPersistencia eP)
	{
		if(eP == null)return null;
		Empresa emp = new Empresa();
		emp.setCuit(eP.getCuit());
		emp.setRazonSoial(eP.getRazonSoial());
		emp.setRegularidad(eP.getRegularidad());
		emp.setDireccion(eP.getDireccion());
		emp.setTelefono(eP.getTelefono());
		emp.setIdCliente(eP.getIdCliente());
		List<CuentaCorriente>cuentas=new ArrayList<CuentaCorriente>();
		for (CuentaCorrientePersistencia cuentaCorrientePersistencia : eP.getCuentasCorrientes()) {
			cuentas.add(convertCuentaCorrientePersistenciaToNegocio(cuentaCorrientePersistencia));
		}
		emp.setCuentasCorrientes(cuentas);

		List<EmpresaDirValidas>direcciones=new ArrayList<EmpresaDirValidas>();
		for (EmpresaDirValidasPersistencia empresaDirValidasPersistencia : eP.getDireccionesValidas()) {
			direcciones.add(convertEmpresaDirValidasPersistenciaToNegocio(empresaDirValidasPersistencia));
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

	private EmpresaDirValidas convertEmpresaDirValidasPersistenciaToNegocio (EmpresaDirValidasPersistencia eP)
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
		p.setIdProd(pp.getIdProd());
		return p;
	}

	//CONVERT CLIENTE NEGOCIO TO CLIENTE PERSISTENCIA END

	//CONVERT SUCURSAL NEGOCIO TO SUCURSAL PERSISTENCIA START


	private SucursalPersistencia convertSucursalNegocioToPersistencia(
			Sucursal sucS) {
		SucursalPersistencia sucP = new SucursalPersistencia();
		sucP.setDir(sucS.getDir());
		sucP.setEncDespacho(sucS.getEncDespacho());
		sucP.setEncRecepcion(sucS.getEncRecepcion());
		sucP.setGerente(sucS.getGerente());
		sucP.setNombre(sucS.getNombre());
		sucP.setNumeroSucursal(sucS.getNumero());
		ArrayList<PedidoPersistencia> pedidosP = new ArrayList<PedidoPersistencia>();
		for (Pedido pedidoS : sucS.getPedidos()) {
			pedidosP.add(convertPedidoNegocioToPersistencia(pedidoS,sucP));
		}
		sucP.setPedidos(pedidosP);
		ArrayList<MapaDeRutaPersistencia> rutasP = new ArrayList<MapaDeRutaPersistencia>();
		for (MapaDeRuta mapaDeRutaS : sucS.getRutas()) {
			rutasP.add(convertMapaRutaNegocioToPersistencia(mapaDeRutaS, sucP));
		}
		sucP.setRutas(rutasP);
		ArrayList<VehiculoPersistencia> vehiculosP = new ArrayList<VehiculoPersistencia>();
		for (Vehiculo vehiculoS : sucS.getVehiculos()) {
			vehiculosP.add(convertVehiculoNegocioToPersistencia(vehiculoS, sucP));
		}
		sucP.setVehiculos(vehiculosP);
		ArrayList<DepositoPersistencia> depositosP = new ArrayList<DepositoPersistencia>();
		for (Deposito depositoS : sucS.getDepositos()) {
			depositosP.add(convertDepositoNegocioToPersistencia(depositoS, sucP));
		}
		sucP.setDepositos(depositosP);

		return sucP;
	}

	private DepositoPersistencia convertDepositoNegocioToPersistencia(
			Deposito depositoS, SucursalPersistencia sucP) {
		DepositoPersistencia depP = new DepositoPersistencia();

		depP.setCantidadMax(depositoS.getCantidadMax());
		depP.setEncargado(depositoS.getEncargado());
		depP.setIdDeposito(depositoS.getIdDeposito());
		ArrayList<MercaderiaPersistencia> mercaderiasL = new ArrayList<MercaderiaPersistencia>();
		for (Mercaderia mercaderiaS : depositoS.getMercaderias()) {
			mercaderiasL.add(convertMercaderiaNegocioToPersistencia(mercaderiaS,null,null ,depP));
		}
		depP.setMercaderias(mercaderiasL);
		depP.setSuc(sucP);
		ArrayList<AreaPersistencia> areasL = new ArrayList<AreaPersistencia>();
		for (Area areaS : depositoS.getAreas()) {
			areasL.add(convertAreaNegocioToPersistencia(areaS, depP));
		}
		depP.setAreas(areasL);

		return depP;
	}


	private AreaPersistencia convertAreaNegocioToPersistencia(Area areaS, DepositoPersistencia depP) {
		AreaPersistencia AreaP = new AreaPersistencia();
		AreaP.setCapacidadMaxima(areaS.getCapacidadMaxima());
		AreaP.setDeposito(depP);
		AreaP.setDescripcion(areaS.getDescripcion());
		AreaP.setIdArea(areaS.getIdArea());

		return AreaP;
	}

	private VehiculoPersistencia convertVehiculoNegocioToPersistencia(
			Vehiculo vehiculoS2, SucursalPersistencia sucP) {
		VehiculoPersistencia vehP = new VehiculoPersistencia();
		vehP.setCondEspeciales(vehiculoS2.getCondEspeciales());
		vehP.setCoordenadaActual(vehiculoS2.getCoordenadaActual());
		vehP.setEstado(vehiculoS2.getEstado());
		vehP.setExpiracionGarantia(vehiculoS2.getExpiracionGarantia());
		vehP.setKilometrajemaximo(vehiculoS2.getKilometrajemaximo());
		vehP.setKilometrakeActual(vehiculoS2.getKilometrakeActual());
		vehP.setModelo(vehiculoS2.getModelo());
		vehP.setNroChasis(Integer.valueOf(vehiculoS2.getNroChasis()));
		vehP.setPatente(vehiculoS2.getPatente());
		vehP.setPesoMax(vehiculoS2.getPesoMax());
		vehP.setTara(vehiculoS2.getTara());
		vehP.setTipo(vehiculoS2.getTipo());
		vehP.setVolumenMax(vehiculoS2.getVolumenMax());
		vehP.setSucursal(sucP);
		ArrayList<MantenimientoRealizadoPersistencia> mantL = new ArrayList<MantenimientoRealizadoPersistencia>();
		for (MantenimientoRealizado mantenimientoRealizadoS : vehiculoS2.getMantenimientosRealizados()) {
			mantL.add(convertMantenimientoRealizadoNegocioToPersistencia(mantenimientoRealizadoS,vehP));
		}
		vehP.setMantenimientosRealizados(mantL);
		ArrayList<PlanDeMantenimientoPersistencia> mantPlanL = new ArrayList<PlanDeMantenimientoPersistencia>();
		for (PlanDeMantenimiento planDeMantenimientoS : vehiculoS2.getMantenimientosPlaneados()) {
			mantPlanL.add(convertPlanDeMantenimientoNegocioToPersistencia(planDeMantenimientoS, vehP));
		}
		vehP.setMantenimientosPlaneados(mantPlanL);
		ArrayList<RemitoPersistencia> remL = new ArrayList<RemitoPersistencia>();
		for (Remito remitoS : vehiculoS2.getRemitos()) {
			remL.add(convertRemitoNegocioToPersistencia(remitoS, vehP));
		}

		vehP.setRemitos(remL);

		return vehP;
	}

	private RemitoPersistencia convertRemitoNegocioToPersistencia(
			Remito remitoS, VehiculoPersistencia vehP) {
		RemitoPersistencia rempP = new RemitoPersistencia();
		rempP.setEstado(remitoS.getEstado());
		rempP.setNroRemito(remitoS.getNroRemito());
		rempP.setVehiculo(vehP);
		ArrayList<MercaderiaPersistencia> mercaderiasL = new ArrayList<MercaderiaPersistencia>();
		for (Mercaderia mercaderiaS : remitoS.getMercaderias()) {
			mercaderiasL.add(convertMercaderiaNegocioToPersistencia(mercaderiaS,null, rempP, null));
		}
		rempP.setMercaderias(mercaderiasL);

		return rempP;
	}


	private PlanDeMantenimientoPersistencia convertPlanDeMantenimientoNegocioToPersistencia(
			PlanDeMantenimiento planDeMantenimientoS, VehiculoPersistencia vehP) {
		PlanDeMantenimientoPersistencia planMP = new PlanDeMantenimientoPersistencia();
		planMP.setCantKilometros(planDeMantenimientoS.getCantKilometros());
		planMP.setControlEspecial(planDeMantenimientoS.getControlEspecial());
		planMP.setIdPlan(planDeMantenimientoS.getIdPlan());
		planMP.setTipo(planDeMantenimientoS.getTipo());
		planMP.setVehiculo(vehP);
		return planMP;
	}

	private MantenimientoRealizadoPersistencia convertMantenimientoRealizadoNegocioToPersistencia(
			MantenimientoRealizado mantenimientoRealizadoS, VehiculoPersistencia vehP) {
		MantenimientoRealizadoPersistencia mantReaP = new MantenimientoRealizadoPersistencia();
		mantReaP.setCosto(mantenimientoRealizadoS.getCosto());
		mantReaP.setDescripcion(mantenimientoRealizadoS.getDescripcion());
		mantReaP.setFecha(mantenimientoRealizadoS.getFecha());
		mantReaP.setIdMantenimiento(mantenimientoRealizadoS.getIdMantenimiento());
		mantReaP.setKilometrajeActual(mantenimientoRealizadoS.getKilometrajeActual());
		mantReaP.setKilometrosRealizadosDesdeUltimoControl(mantenimientoRealizadoS.getKilometrosRealizadosDesdeUltimoControl());
		mantReaP.setTipo(mantenimientoRealizadoS.getTipo());
		mantReaP.setVehiculo(vehP);
		return mantReaP;
	}

	private MapaDeRutaPersistencia convertMapaRutaNegocioToPersistencia(
			MapaDeRuta mapaDeRutaS, SucursalPersistencia sucP) {
		MapaDeRutaPersistencia mapaRutaP = new MapaDeRutaPersistencia();
		mapaRutaP.setCosto(mapaDeRutaS.getCosto());
		mapaRutaP.setDistancia(mapaDeRutaS.getDistancia());
		mapaRutaP.setDuracionHs(mapaDeRutaS.getDuracionHs());
		mapaRutaP.setIdMapa(mapaDeRutaS.getIdMapa());
		mapaRutaP.setNumSucDestino(mapaDeRutaS.getNumSucDestino());
		mapaRutaP.setNumSucOrigen(mapaDeRutaS.getNumSucOrigen());
		mapaRutaP.setSucursal(sucP);
		return mapaRutaP;
	}

	public PedidoPersistencia convertPedidoNegocioToPersistencia(
			Pedido pedidoS, SucursalPersistencia suc) {
		PedidoPersistencia pedP = new PedidoPersistencia();

		pedP.setCondEspeciales(pedidoS.getCondEspeciales());
		pedP.setDirDeRetiroSoloEmpresa(pedidoS.getDirDeRetiroSoloEmpresa());
		pedP.setDirDestino(pedidoS.getDirDestino());
		pedP.setEstado(pedidoS.getEstado());
		pedP.setFechaEnregaMaxima(pedidoS.getFechaEnregaMaxima());
		pedP.setFechaEntregaEstimada(pedidoS.getFechaEntregaEstimada());
		pedP.setHorarioDeEntregaDesde(pedidoS.getHorarioDeEntregaDesde());
		pedP.setHorarioDeEntregahasta(pedidoS.getHorarioDeEntregahasta());
		pedP.setIdPedido(pedidoS.getIdPedido());
		pedP.setManifiesto(pedidoS.getManifiesto());
		pedP.setPrioridad(pedidoS.getPrioridad());
		pedP.setSucursal(suc);

		ArrayList<ConsideracionEspecialPersistencia> consideraciones = new ArrayList<ConsideracionEspecialPersistencia>();
		for (ConsideracionEspecial consideracionEspecialS : pedidoS.getConsideraciones()) {

			consideraciones.add(convertConsideracionEspecialNegocioToPersistenacia(consideracionEspecialS,pedP));
		}
		pedP.setConsideraciones(consideraciones);
		ArrayList<DestinatarioPersistencia> destinatarios = new ArrayList<DestinatarioPersistencia>();
		for (Destinatario destS : pedidoS.getDestinatarios()) {
			destinatarios.add(convertDestinatarioNegocioToPersistencia(destS, pedP));
		}
		pedP.setDestinatarios(destinatarios);
		ArrayList<MercaderiaPersistencia> mercaderias = new ArrayList<MercaderiaPersistencia>();
		for (Mercaderia mercS : pedidoS.getMercaderias()) {
			mercaderias.add(convertMercaderiaNegocioToPersistencia(mercS, pedP, null ,null));
		}
		pedP.setMercaderias(mercaderias);
		pedP.setCliente(convertClienteNegocioToPersistencia(pedidoS.getClinete()));

		return pedP;
	}



	private ClientePersistencia convertClienteNegocioToPersistencia(
			Cliente clinete) {
		ClientePersistencia clienteP = null;

		if(clinete instanceof Empresa){
			clienteP = convertEmpresaNegocioToPersistencia(clinete);
		}
		if(clinete instanceof Particular){
			clienteP = convertParticularNegocioToPersistencia(clinete);
		}

		return clienteP;
	}

	private MercaderiaPersistencia convertMercaderiaNegocioToPersistencia(
			Mercaderia mercS, PedidoPersistencia pedP, RemitoPersistencia rempP, DepositoPersistencia depP) {

		MercaderiaPersistencia mercP = null;

		if(mercS instanceof MercaderiaPorPeso)
			mercP = convertMercaderiaPorPesoNegocioToPersistencia((MercaderiaPorPeso)mercS, pedP,rempP,depP);

		if(mercS instanceof MercaderiaPorVolumen)
			mercP = convertMercaderiaPorVolumentNegocioToPersistencia((MercaderiaPorVolumen)mercS, pedP,rempP,depP);

		return mercP;
	}


	private MercaderiaPorVolumenPersistencia convertMercaderiaPorVolumentNegocioToPersistencia(
			MercaderiaPorVolumen mercS, PedidoPersistencia pedP, RemitoPersistencia rempP, DepositoPersistencia depP) {
		MercaderiaPorVolumenPersistencia mercP = new MercaderiaPorVolumenPersistencia();
		mercP.setAlto(mercS.getAlto());
		mercP.setAncho(mercS.getAncho());
		mercP.setApilable(mercS.isAplilable());
		mercP.setCantApilable(mercS.getCantApilable());
		mercP.setCondDeViaje(mercS.getCondDeViaje());
		mercP.setCoordenadasDestino(mercS.getCoordenadasDestino());
		mercP.setDeposito(depP);
		mercP.setFragilidad(mercS.getFragilidad());
		mercP.setIdMercaderia(mercS.getIdMercaderia());
		mercP.setIndicacionesManpulacion(mercS.getIndicacionesManpulacion());
		mercP.setPedido(pedP);
		mercP.setProfundidad(mercS.getProfundidad());
		mercP.setRemito(rempP);
		mercP.setVolumen(mercS.getVolumen());
		ArrayList<MovimientoPersistencia> movL = new ArrayList<MovimientoPersistencia>();
		for (Movimiento movimientoS : mercS.getMovimientos()) {
			movL.add(convertMovimientomercaderiaNegocioToPersistencia(movimientoS,mercP));
		}
		mercP.setMovimientos(movL);


		return mercP;
	}



	private MercaderiaPorPesoPersistencia convertMercaderiaPorPesoNegocioToPersistencia(
			MercaderiaPorPeso mercS, PedidoPersistencia pedP, RemitoPersistencia rempP, DepositoPersistencia depP) {
		MercaderiaPorPesoPersistencia mercP = new MercaderiaPorPesoPersistencia();
		mercP.setAlto(mercS.getAlto());
		mercP.setAncho(mercS.getAncho());
		mercP.setApilable(mercS.isAplilable());
		mercP.setCantApilable(mercS.getCantApilable());
		mercP.setCondDeViaje(mercS.getCondDeViaje());
		mercP.setCoordenadasDestino(mercS.getCoordenadasDestino());
		mercP.setDeposito(depP);
		mercP.setFragilidad(mercS.getFragilidad());
		mercP.setIdMercaderia(mercS.getIdMercaderia());
		mercP.setIndicacionesManpulacion(mercS.getIndicacionesManpulacion());
		mercP.setPedido(pedP);
		mercP.setProfundidad(mercS.getProfundidad());
		mercP.setRemito(rempP);
		mercP.setPeso(mercS.getPeso());
		ArrayList<MovimientoPersistencia> movL = new ArrayList<MovimientoPersistencia>();
		for (Movimiento movimientoS : mercS.getMovimientos()) {
			movL.add(convertMovimientomercaderiaNegocioToPersistencia(movimientoS, mercP));
		}
		mercP.setMovimientos(movL);

		return mercP;
	}

	private MovimientoPersistencia convertMovimientomercaderiaNegocioToPersistencia(
			Movimiento movimientoS, MercaderiaPersistencia mercP) {
		MovimientoPersistencia movP = new MovimientoPersistencia();
		movP.setCondicionDeArribo(movimientoS.getCondicionDeArribo());
		movP.setDestino(movimientoS.getDestino());
		movP.setEstado(movimientoS.getEstado());
		movP.setFechaLlegada(movimientoS.getFechaLlegada());
		movP.setFechaSalida(movimientoS.getFechaSalida());
		movP.setIdMovimiento(movimientoS.getIdMovimiento());
		movP.setMercaderia(mercP);
		movP.setOrigen(movimientoS.getOrigen());
		return movP;
	}

	private DestinatarioPersistencia convertDestinatarioNegocioToPersistencia(
			Destinatario destS, PedidoPersistencia pedP) {
		DestinatarioPersistencia detP = new DestinatarioPersistencia();
		detP.setApellido(destS.getApellido());
		detP.setDni(destS.getDni());
		detP.setNombre(destS.getNombre());
		detP.setPedido(pedP);
		return detP;
	}

	private ConsideracionEspecialPersistencia convertConsideracionEspecialNegocioToPersistenacia(
			ConsideracionEspecial consideracionEspecialS,PedidoPersistencia pedP ) {
		ConsideracionEspecialPersistencia consEP = new ConsideracionEspecialPersistencia();

		consEP.setAutorizacionAvioneta(consideracionEspecialS.isAutorizacionAvioneta());
		consEP.setCostoExtra(consideracionEspecialS.getCostoExtra());
		consEP.setEntregaInmediata(consideracionEspecialS.isEntregaInmediata());
		consEP.setIdConsideracionEspecial(consideracionEspecialS.getIdConsideracionEspecial());
		consEP.setPedido(pedP);
		consEP.setRequiereAvioneta(consideracionEspecialS.isRequiereAvioneta());
		consEP.setRequiereCamionExterno(consideracionEspecialS.isRequiereCamionExterno());
		ArrayList<VehiculoExternoPersistencia> vehiculosExternos = new ArrayList<VehiculoExternoPersistencia>();
		for (VehiculoExterno vehiculoExternoS : consideracionEspecialS.getvExternos()) {
			vehiculosExternos.add(convertVehiculoExternoNegocioToPersistencia(vehiculoExternoS, consEP));
		}
		consEP.setvExternos(vehiculosExternos);
		ArrayList<CarrierPersistencia> carriers = new ArrayList<CarrierPersistencia>();
		for (Carrier carrierS : consideracionEspecialS.getCarriers()) {
			carriers.add(convertCarrierNegocioToPersistencia(carrierS));
		}
		consEP.setCarriers(carriers);
		return consEP;
	}

	private CarrierPersistencia convertCarrierNegocioToPersistencia(
			Carrier carrierS) {
		CarrierPersistencia carrierP = new CarrierPersistencia();
		carrierP.setConsideracionEspecial(null);
		carrierP.setCosto(carrierS.getCosto());
		carrierP.setDestino(carrierS.getDestino());
		carrierP.setIdCarrier(carrierS.getIdCarrier());
		carrierP.setOrigen(carrierS.getOrigen());
		return carrierP;
	}

	private VehiculoExternoPersistencia convertVehiculoExternoNegocioToPersistencia(
			VehiculoExterno vehiculoExternoS, ConsideracionEspecialPersistencia conEP) {
		VehiculoExternoPersistencia vehExP = new VehiculoExternoPersistencia();
		vehExP.setCapacidadCarga(vehiculoExternoS.getCapacidadCarga());
		vehExP.setConsideracionEspecial(conEP);
		vehExP.setIdentificacion(vehiculoExternoS.getIdentificacion());
		vehExP.setIdVehiculoExterno(vehiculoExternoS.getIdVehiculoExterno());
		vehExP.setTipo(vehiculoExternoS.getTipo());
		return vehExP;
	}

	//CONVERT SUCURSAL NEGOCIO TO SUCURSAL PERSISTENCIA END

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
			boolean encontrado = false;
			for (Pedido pedido : pedidos) {
				if(pedido.getIdPedido() == pedP.getIdPedido()){
					sucT.addPedido(pedido);
					encontrado = true;
					break;
				}
			}
			if(encontrado==false){
				Pedido pedTemp = convertPedidoPersistenciaToNegocio(pedP);
				pedidos.add(pedTemp);
				sucT.addPedido(pedTemp);
			}
		};
		for (MapaDeRutaPersistencia mapP : sucBd.getRutas()) {
			sucT.addRuta(convertMapaRutaPersistenciaToNegocio(mapP));
		};
		for (VehiculoPersistencia vehP : sucBd.getVehiculos()) {

			
			boolean encontrado = false;
			for (Vehiculo vehiculo : vehiculos){
				if(vehiculo.getPatente().equals(vehP.getPatente())){
					sucT.addVehiculo(vehiculo);
					encontrado = true;
					break;
				}
			}
			if(encontrado==false){
				Vehiculo vehTemp = convertVehiculoPersistenciaToNegocio(vehP);
				vehiculos.add(vehTemp);
				sucT.addVehiculo(vehTemp);
			}

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

		for (AreaPersistencia areaP : depP.getAreas()) {
			depN.addAreas(convertAreaPersistenciaToNegocio(areaP));
		}
		return depN;
	}

	private Area convertAreaPersistenciaToNegocio(AreaPersistencia areaP) {
		Area areaS = new Area();
		areaS.setCapacidadMaxima(areaP.getCapacidadMaxima());
		areaS.setDescripcion(areaP.getDescripcion());
		areaS.setIdArea(areaP.getIdArea());
		return areaS;
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
		if(vehP.getEstado().equalsIgnoreCase("DISPONIBLE"))
			vehN.setEstado(ESTADO_VEHICULO.DISPONIBLE);
		if(vehP.getEstado().equalsIgnoreCase("DESPACHADO"))
		vehN.setEstado(ESTADO_VEHICULO.DESPACHADO);
		if(vehP.getEstado().equalsIgnoreCase("MEDIA_CARGA"))
		vehN.setEstado(ESTADO_VEHICULO.MEDIA_CARGA);

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
				pedP.getPrioridad(),
				convertClientePersistenciaToNegocio(pedP.getCliente()));
		pedN.setIdPedido(pedP.getIdPedido());
		
		if(pedP.getEstado().equalsIgnoreCase("SIN_PROCESAR"))
		pedN.setEstado(ESTADO_DE_PEDIDO.SIN_PROCESAR);
		if(pedP.getEstado().equalsIgnoreCase("PENDIENTE"))
		pedN.setEstado(ESTADO_DE_PEDIDO.PENDIENTE);
		if(pedP.getEstado().equalsIgnoreCase("DESPACHADO"))
		pedN.setEstado(ESTADO_DE_PEDIDO.DESPACHADO);
		if(pedP.getEstado().equalsIgnoreCase("ENTREGADO"))
		pedN.setEstado(ESTADO_DE_PEDIDO.ENTREGADO);

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

	private Cliente convertClientePersistenciaToNegocio(
			ClientePersistencia cliente) {
		if(cliente!=null)
			if(cliente instanceof EmpresaPersistencia){
				return convertEmpresaPersistenciaToNegocio((EmpresaPersistencia) cliente);
			}
			else if(cliente instanceof ParticularPersistencia){
				return convertParticularPersistenciaToNegocio((ParticularPersistencia) cliente);
			}
		return null;
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
		Mercaderia mercN = null;

		if(mercP instanceof MercaderiaPorPesoPersistencia) 
			mercN = convertMercaderiaPorPesoPersistenciaToNegocio((MercaderiaPorPesoPersistencia) mercP);

		if(mercP instanceof MercaderiaPorVolumenPersistencia)
			mercN = convertMercaderiaPorVolumenPersistenciaToNegocio((MercaderiaPorVolumenPersistencia) mercP);

		return mercN;
	}

	private Mercaderia convertMercaderiaPorVolumenPersistenciaToNegocio(
			MercaderiaPorVolumenPersistencia mercP) {

		MercaderiaPorVolumen mercS = new MercaderiaPorVolumen();
		mercS.setAlto(mercP.getAlto());
		mercS.setAncho(mercP.getAncho());
		mercS.setAplilable(mercP.isApilable());
		mercS.setCantApilable(mercP.getCantApilable());
		mercS.setCondDeViaje(mercP.getCondDeViaje());
		mercS.setCoordenadasDestino(mercP.getCoordenadasDestino());
		mercS.setFragilidad(mercP.getFragilidad());
		mercS.setIdMercaderia(mercP.getIdMercaderia());
		mercS.setIndicacionesManpulacion(mercP.getIndicacionesManpulacion());
		mercS.setProfundidad(mercP.getProfundidad());
		mercS.setVolumen(mercP.getVolumen());
		mercS.setMovimientos(new ArrayList<Movimiento>());
		for (MovimientoPersistencia movP : mercP.getMovimientos()) {
			mercS.addMovimiento(convertMovimientoMercaderiaPersistenciaToNegocio(movP));
		}
		return mercS;
	}

	private Mercaderia convertMercaderiaPorPesoPersistenciaToNegocio(
			MercaderiaPorPesoPersistencia mercP) {

		MercaderiaPorPeso mercS = new MercaderiaPorPeso();
		mercS.setAlto(mercP.getAlto());
		mercS.setAncho(mercP.getAncho());
		mercS.setAplilable(mercP.isApilable());
		mercS.setCantApilable(mercP.getCantApilable());
		mercS.setCondDeViaje(mercP.getCondDeViaje());
		mercS.setCoordenadasDestino(mercP.getCoordenadasDestino());
		mercS.setFragilidad(mercP.getFragilidad());
		mercS.setIdMercaderia(mercP.getIdMercaderia());
		mercS.setIndicacionesManpulacion(mercP.getIndicacionesManpulacion());
		mercS.setProfundidad(mercP.getProfundidad());
		mercS.setPeso(mercP.getPeso());
		mercS.setMovimientos(new ArrayList<Movimiento>());
		for (MovimientoPersistencia movP : mercP.getMovimientos()) {
			mercS.addMovimiento(convertMovimientoMercaderiaPersistenciaToNegocio(movP));
		}
		return mercS;
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
			
			
			//TODO
			
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

		List<MovimientoBean> listMov = new ArrayList<MovimientoBean>();
		
		for (MovimientoPersistencia movimientoP : mp.getMovimientos()) {
			listMov.add(convertMovimientoPersistenciaToBean(movimientoP,mb));
		}
		
		mb.setMovimientos(listMov);
		
		
		return mb;
	}

	private MovimientoBean convertMovimientoPersistenciaToBean(
			MovimientoPersistencia movimientoP, MercaderiaBean mercB) {
		MovimientoBean mobB = new MovimientoBean();
		mobB.setCondicionDeArribo(movimientoP.getCondicionDeArribo());
		mobB.setDestino(movimientoP.getDestino());
		mobB.setEstado(movimientoP.getEstado());
		mobB.setFechaLlegada(movimientoP.getFechaLlegada());
		mobB.setFechaSalida(movimientoP.getFechaSalida());
		mobB.setIdMovimiento(movimientoP.getIdMovimiento());
		mobB.setMercaderia(mercB);
		mobB.setOrigen(movimientoP.getOrigen());
		
		return mobB;
	}

	private DepositoBean convertDepositoPersistenciaToBean(DepositoPersistencia dp)
	{
		DepositoBean db=new DepositoBean();
		db.setIdDeposito(dp.getIdDeposito());
		db.setCantidadMax(dp.getCantidadMax());
		db.setEncargado(dp.getEncargado());
		//TODO saque esto porque sino genera un loop
		//db.setSuc(this.convertSucursalPersistenciaToBean(dp.getSuc()));
		return db;
	}


	@SuppressWarnings("unused")
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
			((EmpresaBean)cB).setCuentasCorrientes(new ArrayList<CuentaCorrienteBean>());
			for (CuentaCorrientePersistencia cuenta : ((EmpresaPersistencia)cP).getCuentasCorrientes()) {
				((EmpresaBean)cB).addCuentaCorriente(convertCuenCuentaCorrientePersistenciaToBean(cuenta,(EmpresaBean)cB));
			}
			((EmpresaBean)cB).setDireccionesValidas(new ArrayList<EmpresaDirValidasBean>());
			for (EmpresaDirValidasPersistencia dirVaP : ((EmpresaPersistencia)cP).getDireccionesValidas()) {
				((EmpresaBean)cB).addDireccionValida(convertDireccionValidaPersistenciaToBean(dirVaP,(EmpresaBean)cB));
			}
			((EmpresaBean)cB).setProductosValidos(new ArrayList<ProductoBean>());
			//TODO FOREACH CONVERT
			
		}
		if(cP.getClass().getName().equals(ParticularPersistencia.class.getName())){
			cB=new ParticularBean();
		}
		cB.setIdCliente(cP.getIdCliente());
		cB.setDireccion(cP.getDireccion());
		cB.setTelefono(cP.getTelefono());
		return cB;
	}

	private EmpresaDirValidasBean convertDireccionValidaPersistenciaToBean(
			EmpresaDirValidasPersistencia dirVaP, EmpresaBean cB) {
		EmpresaDirValidasBean dirValB = new EmpresaDirValidasBean();
		dirValB.setDireccion(dirVaP.getDireccion());
		dirValB.setEmpresa(cB);
		dirValB.setIdDir(dirVaP.getIdDir());
		dirValB.setTel(dirVaP.getTel());
		return dirValB;
	}

	private CuentaCorrienteBean convertCuenCuentaCorrientePersistenciaToBean(
			CuentaCorrientePersistencia cuentaP, EmpresaBean empB) {
		CuentaCorrienteBean cuentaB = new CuentaCorrienteBean();
		cuentaB.setCbu(cuentaP.getCbu());
		cuentaB.setEmpresa(empB);
		cuentaB.setEstado(cuentaP.isEstado());
		cuentaB.setMinimoPermitidoSinAuth(cuentaP.getMinimoPermitidoSinAuth());
		cuentaB.setMovimientos(new ArrayList<MovimientoCuentaBean>());
		//TODO cuentaB.addMovimiento();
		
		cuentaB.setSaldoActual(cuentaP.getSaldoActual());
		return cuentaB;
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
		sb.setRutas(null);
		sb.setVehiculos(null);
		sb.setPedidos(null);
		
		ArrayList<DepositoBean> depBL = new ArrayList<DepositoBean>();
		
		for (DepositoPersistencia depositoP : sp.getDepositos()) {
			depBL.add(convertDepositoPersistenciaToBean(depositoP));
		}
		sb.setDepositos(depBL);

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
		pBean.setFechaEntregaEstimada(pP.getFechaEntregaEstimada());
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
		pBean.setDestinatarios(new ArrayList<DestinatarioBean>());
		pBean.setConsideraciones(new ArrayList<ConsideracionEspecialBean>());

		return pBean;
	}



	public List<PedidoBean> getPedidosDeBd() {
		List<PedidoPersistencia> ped=new ArrayList<PedidoPersistencia>();
		ped=DAOPedido.getInstance().getPedidos();
		List<PedidoBean> pedidosBean=convertPedidosPersistenciaToBean(ped);
		return pedidosBean;
	}

	public List<PedidoBean> getPedidosCliente(int idCliente) {
		List<PedidoPersistencia> pP=new ArrayList<PedidoPersistencia>();		
		pP=DAOPedido.getInstance().getPedidosPorCliente(idCliente);
		List<PedidoBean> pedidosBean=convertPedidosPersistenciaToBean(pP);
		return pedidosBean;
	}

	public String validarPedidosPorVencerDeSucursal (String sucursal){
		Sucursal sucTemp = buscarSucursal(sucursal);
		return sucTemp.validarPedidosAVencer();
	}
	

}