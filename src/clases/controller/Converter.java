package clases.controller;

import java.util.ArrayList;
import java.util.List;

import beans.*;
import clases.*;
import clases.Pedido.ESTADO_DE_PEDIDO;



public class Converter {
	
	private static Converter inst = null;
	
	public static Converter getInstance (){
		if (inst == null) {
			inst = new Converter();
			
		}
		return inst;
	}
	
	public Pedido convertPedidoBeanToNegocio(PedidoBean pedB){
		Pedido pedN = new Pedido(
				pedB.getManifiesto(),
				pedB.getDirDestino(),
				pedB.getFechaEnregaMaxima(),
				pedB.getFechaEntregaEstimada(),
				pedB.getCondEspeciales(),
				pedB.getHorarioDeEntregaDesde(),
				pedB.getHorarioDeEntregahasta(),
				pedB.getDirDeRetiroSoloEmpresa(),
				pedB.getPrioridad(),
				convertClienteBeanToNegocio(pedB.getCliente()));
		pedN.setIdPedido(pedB.getIdPedido());
		if(pedB.getEstado() == null )pedB.setEstado("SIN_PROCESAR");
		if(pedB.getEstado().equalsIgnoreCase("SIN_PROCESAR"));
		pedN.setEstado(ESTADO_DE_PEDIDO.SIN_PROCESAR);
		if(pedB.getEstado().equalsIgnoreCase("PENDIENTE"));
		pedN.setEstado(ESTADO_DE_PEDIDO.PENDIENTE);
		if(pedB.getEstado().equalsIgnoreCase("DESPACHADO"));
		pedN.setEstado(ESTADO_DE_PEDIDO.DESPACHADO);
		
		for (ConsideracionEspecialBean condEsP : pedB.getConsideraciones()) {
			pedN.addConsideraciones(convertConsideracionEspecialBeanToNegocio(condEsP));
		}
		for (DestinatarioBean detP : pedB.getDestinatarios()) {
			pedN.addDestinatario(convertDestinatarioBeanToNegocio(detP));
		}
		for (MercaderiaBean merP : pedB.getMercaderias()) {
			pedN.addMercaderia(convertMercaderiaBeanToNegocio(merP));
		}

		return pedN;
		
	}

	public Mercaderia convertMercaderiaBeanToNegocio(MercaderiaBean mercB) {
		Mercaderia mercN = null;
		
		if(mercB instanceof MercaderiaPorPesoBean) 
			mercN = convertMercaderiaPorPesoBeanToNegocio((MercaderiaPorPesoBean) mercB);
		
		if(mercB instanceof MercaderiaPorVolumenBean)
			mercN = convertMercaderiaPorVolumenBeanToNegocio((MercaderiaPorVolumenBean) mercB);
		
		return mercN;
	}

	public Mercaderia convertMercaderiaPorVolumenBeanToNegocio(
			MercaderiaPorVolumenBean mercB) {
		MercaderiaPorVolumen mercS = new MercaderiaPorVolumen();
		mercS.setAlto(mercB.getAlto());
		mercS.setAncho(mercB.getAncho());
		mercS.setAplilable(mercB.isApilable());
		mercS.setCantApilable(mercB.getCantApilable());
		mercS.setCondDeViaje(mercB.getCondDeViaje());
		mercS.setCoordenadasDestino(mercB.getCoordenadasDestino());
		mercS.setFragilidad(mercB.getFragilidad());
		mercS.setIdMercaderia(mercB.getIdMercaderia());
		mercS.setIndicacionesManpulacion(mercB.getIndicacionesManpulacion());
		mercS.setProfundidad(mercB.getProfundidad());
		mercS.setVolumen(mercB.getVolumen());
		mercS.setMovimientos(new ArrayList<Movimiento>());
		if(mercB.getMovimientos()!=null)
		for (MovimientoBean movB : mercB.getMovimientos()) {
			mercS.addMovimiento(convertMovimientoMercaderiaBeanToNegocio(movB));
		}
		return mercS;
	}

	public Movimiento convertMovimientoMercaderiaBeanToNegocio(
			MovimientoBean movB) {
		Movimiento movN = new Movimiento(
				movB.getFechaSalida(),
				movB.getFechaLlegada(),
				movB.getOrigen(),
				movB.getDestino(),
				movB.getCondicionDeArribo(),
				movB.getEstado());
		return movN;
	}

	public Mercaderia convertMercaderiaPorPesoBeanToNegocio(
			MercaderiaPorPesoBean mercB) {
		MercaderiaPorPeso mercS = new MercaderiaPorPeso();
		mercS.setAlto(mercB.getAlto());
		mercS.setAncho(mercB.getAncho());
		mercS.setAplilable(mercB.isApilable());
		mercS.setCantApilable(mercB.getCantApilable());
		mercS.setCondDeViaje(mercB.getCondDeViaje());
		mercS.setCoordenadasDestino(mercB.getCoordenadasDestino());
		mercS.setFragilidad(mercB.getFragilidad());
		mercS.setIdMercaderia(mercB.getIdMercaderia());
		mercS.setIndicacionesManpulacion(mercB.getIndicacionesManpulacion());
		mercS.setProfundidad(mercB.getProfundidad());
		mercS.setPeso(mercB.getPeso());
		mercS.setMovimientos(new ArrayList<Movimiento>());
		if(mercB.getMovimientos()!=null)
		for (MovimientoBean movB : mercB.getMovimientos()) {
			mercS.addMovimiento(convertMovimientoMercaderiaBeanToNegocio(movB));
		}
		return mercS;
	}

	public Destinatario convertDestinatarioBeanToNegocio(DestinatarioBean detB) {
		Destinatario desN = new Destinatario(
				detB.getNombre(),
				detB.getApellido(),
				detB.getDni());
		return desN;
	}

	public ConsideracionEspecial convertConsideracionEspecialBeanToNegocio(
			ConsideracionEspecialBean condEsP) {
		ConsideracionEspecial condEsN = new ConsideracionEspecial(
				condEsP.isEntregaInmediata(),
				condEsP.isRequiereAvioneta(),
				condEsP.isAutorizacionAvioneta(),
				condEsP.isRequiereCamionExterno(), 
				condEsP.getCostoExtra());
		for (CarrierBean carB : condEsP.getCarriers()) {
			condEsN.addCarrier(convertCarrierBeanToNegocio(carB));
		}
		for (VehiculoExternoBean vextB : condEsP.getvExternos()) {
			condEsN.addvExterno(convertVehiculoExternoBeanToNegocio(vextB));
		}
		return condEsN;
	}
	public VehiculoExterno convertVehiculoExternoBeanToNegocio(
			VehiculoExternoBean vextB) {
		VehiculoExterno vextN = new VehiculoExterno(
				vextB.getTipo(),
				vextB.getIdentificacion(),
				vextB.getCapacidadCarga());
		return vextN;
	}

	public Carrier convertCarrierBeanToNegocio(CarrierBean carB) {
		Carrier carN = new Carrier(
				carB.getOrigen(),
				carB.getDestino(),
				carB.getCosto());
		return carN;
	}

	public Cliente convertClienteBeanToNegocio(ClienteBean cliente) {
		if(cliente!=null)
			if(cliente instanceof EmpresaBean){
				return convertEmpresaBeanToNegocio((EmpresaBean) cliente);
			}
			else if(cliente instanceof ParticularBean){
				return convertParticularBeanToNegocio((ParticularBean) cliente);
			}
		return null;
	}

	public Cliente convertParticularBeanToNegocio(ParticularBean pB) {
		Particular p=new Particular();
		p.setApellido(pB.getApellido());
		p.setDireccion(pB.getDireccion());
		p.setDni(pB.getDni());
		p.setNombre(pB.getNombre());
		p.setTelefono(pB.getTelefono());
		p.setIdCliente(pB.getIdCliente());
		return p;
	}

	public Cliente convertEmpresaBeanToNegocio(EmpresaBean eB) {
		Empresa emp = new Empresa();
		emp.setCuit(eB.getCuit());
		emp.setRazonSoial(eB.getRazonSoial());
		emp.setRegularidad(eB.getRegularidad());
		emp.setDireccion(eB.getDireccion());
		emp.setTelefono(eB.getTelefono());
		emp.setIdCliente(eB.getIdCliente());
		List<CuentaCorriente>cuentas=new ArrayList<CuentaCorriente>();
		for (CuentaCorrienteBean cuentaCorrienteB : eB.getCuentasCorrientes()) {
			cuentas.add(convertCuentaCorrienteBeanToNegocio(cuentaCorrienteB));
		}
		emp.setCuentasCorrientes(cuentas);

		List<EmpresaDirValidas>direcciones=new ArrayList<EmpresaDirValidas>();
		for (EmpresaDirValidasBean empresaDirValidasB : eB.getDireccionesValidas()) {
			direcciones.add(convertEmpresaDirValidasBeanToNegocio(empresaDirValidasB));
		}
		emp.setDireccionesValidas(direcciones);

		List<Producto>productos=new ArrayList<Producto>();
		for(ProductoBean producto: eB.getProductosValidos())
		{
			productos.add(convertProductoBeanToNegocio(producto));
		}
		emp.setProductosValidos(productos);


		return emp;
	}

	public Producto convertProductoBeanToNegocio(ProductoBean pB) {
		Producto p=new Producto();
		p.setDescripcion(pB.getDescripcion());
		p.setTipo(pB.getTipo());
		p.setIdProd(pB.getIdProd());
		return p;
	}

	public EmpresaDirValidas convertEmpresaDirValidasBeanToNegocio(
			EmpresaDirValidasBean eB) {
		EmpresaDirValidas e=new EmpresaDirValidas();
		e.setDireccion(eB.getDireccion());
		e.setTel(eB.getTel());
		return e;

	}

	public CuentaCorriente convertCuentaCorrienteBeanToNegocio(
			CuentaCorrienteBean ccB) {
		CuentaCorriente cc=new CuentaCorriente();
		cc.setCbu(ccB.getCbu());
		cc.setMinimoPermitidoSinAuth(ccB.getMinimoPermitidoSinAuth());
		cc.setSaldoActual(ccB.getSaldoActual());

		List<MovimientoCuenta>movimientosCuenta=new ArrayList<MovimientoCuenta>();
		for(MovimientoCuentaBean movimientoCuenta: ccB.getMovimientos())
		{
			movimientosCuenta.add(convertMovimientoCuentaBeanToNegocio(movimientoCuenta));
		}
		cc.setMovimientos(movimientosCuenta);


		return cc;
	}

	public MovimientoCuenta convertMovimientoCuentaBeanToNegocio(
			MovimientoCuentaBean mB) {
		MovimientoCuenta m=new MovimientoCuenta();
		m.setFecha(mB.getFecha());
		m.setMonto(mB.getMonto());		
		return m;
	}

	public ClienteBean convertParticularNegocioToBean(Particular pN) {
		ParticularBean pB=new ParticularBean();
		pB.setApellido(pN.getApellido());
		pB.setDireccion(pN.getDireccion());
		pB.setDni(pN.getDni());
		pB.setNombre(pN.getNombre());
		pB.setTelefono(pN.getTelefono());
		pB.setIdCliente(pN.getIdCliente());
		return pB;
	}

	public ClienteBean convertEmpresaNegocioToBean(Empresa eN) {
		EmpresaBean emp = new EmpresaBean();
		emp.setCuit(eN.getCuit());
		emp.setRazonSoial(eN.getRazonSoial());
		emp.setRegularidad(eN.getRegularidad());
		emp.setDireccion(eN.getDireccion());
		emp.setTelefono(eN.getTelefono());
		emp.setIdCliente(eN.getIdCliente());
		List<CuentaCorrienteBean>cuentas=new ArrayList<CuentaCorrienteBean>();
		emp.setCuentasCorrientes(cuentas);
		for (CuentaCorriente cuentaCorrienteB : eN.getCuentasCorrientes()) {
			emp.addCuentaCorriente(convertCuentaCorrienteNegocioToBean(cuentaCorrienteB));
		}

		List<EmpresaDirValidasBean>direcciones=new ArrayList<EmpresaDirValidasBean>();
		for (EmpresaDirValidas empresaDirValidasB : eN.getDireccionesValidas()) {
			direcciones.add(convertEmpresaDirValidasNegocioToBean(empresaDirValidasB));
		}
		emp.setDireccionesValidas(direcciones);

		List<ProductoBean>productos=new ArrayList<ProductoBean>();
		for(Producto producto: eN.getProductosValidos())
		{
			productos.add(convertProductoNegocioToBean(producto));
		}
		emp.setProductosValidos(productos);


		return emp;
	}

	private ProductoBean convertProductoNegocioToBean(Producto pN) {
		ProductoBean p=new ProductoBean();
		p.setDescripcion(pN.getDescripcion());
		p.setTipo(pN.getTipo());
		p.setIdProd(pN.getIdProd());
		return p;
	}

	private EmpresaDirValidasBean convertEmpresaDirValidasNegocioToBean(
			EmpresaDirValidas eN) {
		EmpresaDirValidasBean e=new EmpresaDirValidasBean();
		e.setDireccion(eN.getDireccion());
		e.setTel(eN.getTel());
		return e;
	}

	private CuentaCorrienteBean convertCuentaCorrienteNegocioToBean(
			CuentaCorriente ccN) {
		CuentaCorrienteBean cc=new CuentaCorrienteBean();
		cc.setCbu(ccN.getCbu());
		cc.setMinimoPermitidoSinAuth(ccN.getMinimoPermitidoSinAuth());
		cc.setSaldoActual(ccN.getSaldoActual());

		List<MovimientoCuentaBean>movimientosCuenta=new ArrayList<MovimientoCuentaBean>();
		for(MovimientoCuenta movimientoCuenta: ccN.getMovimientos())
		{
			movimientosCuenta.add(convertMovimientoCuentaNegocioToBean(movimientoCuenta));
		}
		cc.setMovimientos(movimientosCuenta);


		return cc;
	}

	private MovimientoCuentaBean convertMovimientoCuentaNegocioToBean(
			MovimientoCuenta mN) {
		MovimientoCuentaBean m=new MovimientoCuentaBean();
		m.setFecha(mN.getFecha());
		m.setMonto(mN.getMonto());		
		return m;
	}
	
	
	//TODO
	public PedidoBean convertPedidoNegocioToBean (Pedido pedN){
		
		return null;
		
		
	}
	

}
