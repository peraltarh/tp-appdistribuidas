package clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import clases.Pedido.ESTADO_DE_PEDIDO;
import clases.Vehiculo.ESTADO_VEHICULO;
import clases.controller.Sistema;
import dao.DAOPedido;

public class Sucursal {
	
	private int numero;
	private String nombre;
	private String dir;
	private String gerente;
	private String encDespacho;
	private String encRecepcion;
	private ArrayList<Deposito> depositos;
	private ArrayList<Pedido> pedidos;
	private ArrayList<Vehiculo> vehiculos;
	private ArrayList<MapaDeRuta> rutas;
	public Sucursal(int numero, String nombre, String dir, String gerente,
			String encDespacho, String encRecepcion) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.dir = dir;
		this.gerente = gerente;
		this.encDespacho = encDespacho;
		this.encRecepcion = encRecepcion;
		this.depositos = new ArrayList<Deposito>();
		this.pedidos = new ArrayList<Pedido>();
		this.vehiculos = new ArrayList<Vehiculo>();
		this.rutas = new ArrayList<MapaDeRuta>();
	}
	public int getNumero() {
		return numero;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDir() {
		return dir;
	}
	public String getGerente() {
		return gerente;
	}
	public String getEncDespacho() {
		return encDespacho;
	}
	public String getEncRecepcion() {
		return encRecepcion;
	}
	public ArrayList<Deposito> getDepositos() {
		return depositos;
	}
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	public ArrayList<MapaDeRuta> getRutas() {
		return rutas;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public void setGerente(String gerente) {
		this.gerente = gerente;
	}
	public void setEncDespacho(String encDespacho) {
		this.encDespacho = encDespacho;
	}
	public void setEncRecepcion(String encRecepcion) {
		this.encRecepcion = encRecepcion;
	}
	public void addDeposito(Deposito deposito) {
		this.depositos.add(deposito);
	}
	public void addPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}
	public void addVehiculo(Vehiculo vehiculo) {
		this.vehiculos.add(vehiculo);
	}
	public void addRuta(MapaDeRuta ruta) {
		this.rutas.add(ruta);
	}
	
	// Recibe un cliente nuevo o el Id del cliente(si ya existe), mas un pedido completo
//	public String RegistrarPedido(Cliente _cliente, PedidoPersistencia _pedido)
//	{
//		String resultado = "";
//		Cliente clienteBD = null;// TODO: Reemplazar null por busqueda en la BBDD (DAOCliente)
//		// Esta el cliente en la BBDD?
//		if(clienteBD == null)
//		{
//			// [No]->Dar de alta.
//			// comprobar que esten todos los datos necesarios y que no haya errores.
//			resultado = validarCliente(_cliente);
//			// Paso la validación?
//			if(!resultado.isEmpty())
//			{
//				// [No]-> Devolver resultado de la validación.
//				return resultado;
//			}else{
//				// Alta de cliente
//				if(_cliente.getClass()==Particular.class)
//					DAOCliente.getInstance().persistirParticular(((Particular)_cliente).getEntity());
//				else
//					DAOCliente.getInstance().persistirEmpresa(((Empresa)_cliente).getEntity());
//			}
//		}
//		// Cliente[Ok]-> Validar y persistir pedido.
//		// Validar mercaderias
//		for(MercaderiaPersistencia mercaderia :_pedido.getMercaderias())
//		{
//			resultado += validarMercaderia(clienteBD, mercaderia);			
//		}
//		if(!resultado.isEmpty())
//			return resultado;
//		// Mercaderias[Ok]
//		DAOPedido.getInstance().persistir(_pedido);
//		
//		return resultado;// Operación finalizada con éxito
//	}
	
	//------------------------------------------------------------------
	// Comprueba que no falten completar datos del cliente.
	// Devuelve un string con todos los campos a completar.
	//------------------------------------------------------------------
	public String validarCliente(Cliente _cliente)
	{
		String validacion = "";
		if(_cliente.getDireccion().isEmpty())
			validacion += "Completar dirección. \n";
		if(_cliente.getTelefono().isEmpty())
			validacion += "Completar telefono. \n";
		if(_cliente.getClass()==Particular.class)
		{
			Particular particular = (Particular)_cliente;
			if(particular.getDni().isEmpty())
				validacion += "Completar DNI. \n";
			if(particular.getApellido().isEmpty())
				validacion += "Completar apellido. \n";
			if(particular.getNombre().isEmpty())
				validacion += "Completar nombre. \n";
		}else{
			Empresa empresa = (Empresa)_cliente;
			if(empresa.getCuit().isEmpty())
				validacion += "Completar CUIT. \n";
			if(empresa.getDireccion().isEmpty())
				validacion += "Completar direccion. \n";
			if(empresa.getRazonSoial().isEmpty())
				validacion += "Completar razón social. \n";
			if(empresa.getRegularidad().isEmpty())
				validacion += "Completar regularidad. \n";
			if(empresa.getTelefono().isEmpty())
				validacion += "Completar telefono. \n";
		}
		return validacion;// Si todo esta Ok devuelve un String vacio.
	}
	
	public String validarMercaderia(Cliente _cliente, Mercaderia _mercaderia)
	{
		String validacion = "";
		//TODO: _cliente.get getAutorizaciones -> implementar?
		for(PoliticasDeEnvio politica :Sistema.getInstance().getPoliticas())
		{
			validacion = politica.Evaluar(_mercaderia);
		}
		return validacion;
	}
	
	//------------------------------------------------------------------
	// Recibe un pedido y ubica la carga en algún vehiculo.
	// Si se dan las condiciones, se realiza el envío.
	// Si no hay vehiculos/espacio disponible, devuelve una notificacion
	// y no se genera remito.
	// Devuelve null en un envío exitoso.
	//------------------------------------------------------------------
	public String ProgramarEnvio(Pedido _pedido) 
	{
		// TODO validar mercaderia.
		if(_pedido.getEstado().equals("despachado")) return "Pedido ya fue despachado";
		
		for(ConsideracionEspecial ce: _pedido.getConsideraciones())
		{
//			if(ce.isRequiereAvioneta() || ce.isRequiereCamionExterno())
//				return TercerizarTransporte(_pedido);
			if(ce.isEntregaInmediata())
				return ForzarEnvio(_pedido);
		}
			
		float volumenOcupado, pesoCombinado = 0;
		boolean porVolumen= (_pedido.getVolumenTotal()>0);
		
		// La politica de la empresa es que si la carga ocupa como minimo un 70% de la capacidad
		// del vehiculo, la carga se envía directamente.
		// Asi que empiezo buscando algún vehiculo en el cual la carga ocupe entre el 70% y 100% 
		// para realizar directamente el envío.
		for(Vehiculo vehiculo : vehiculos)
		{
			// Un vehiculo en estado "Disponible" no tiene ninguna carga asignada.
			if(vehiculo.getEstado().equals("disponible"))
			{
				volumenOcupado = 0;
				pesoCombinado = 0;
				if(porVolumen)
					volumenOcupado = vehiculo.getVolumenMax()/100.f*_pedido.getVolumenTotal();
				else //PorPeso
					pesoCombinado = vehiculo.getPesoMax()/100.f*_pedido.getPesoTotal();
				
				if(volumenOcupado > 100 || pesoCombinado > 100)
					continue;// supera la capacidad del vehiculo, pasar al proximo.
				if(volumenOcupado > 70 || pesoCombinado > 70)
				{
					// >70% implica directamente realizar el envío.
					Remito remito = new Remito(0, "pendiente");// TODO: Nro. remito dejarselo a BBDD
					for(Mercaderia mercaderia : _pedido.getMercaderias())
						remito.addMercaderia(mercaderia);
					vehiculo.addRemito(remito);
					vehiculo.despachar();
					_pedido.setEstado(ESTADO_DE_PEDIDO.DESPACHADO);
					
					//TODO Chequear
					DAOPedido.getInstance().update(Sistema.getInstance().convertPedidoNegocioToPersistencia(_pedido, null));
					
					return "Pedido Despachado";
				}
			}
		}
		// No se pudo realizar el envío de forma individual, así que paso a combinar la carga con otras 
		// que esten en vehiculos parcialmente llenos("media carga").
		for(Vehiculo vehiculo : vehiculos)
		{
			// Solamente los vehiculos con cargas pendientes
			if(vehiculo.getEstado().equals("media_carga"))
			{
				// Verifico que este en media carga por volumen. (no puedo mezclar por volumen y por peso)
				if(vehiculo.isCargaPorVolumen()  && (vehiculo.getVolumenDisponible()<_pedido.getVolumenTotal()))
				{
					Remito remito = new Remito(0, "Entrega pendiente");// TODO: Nro. remito dejarselo a BBDD
					for(Mercaderia mercaderia : _pedido.getMercaderias())
						remito.addMercaderia(mercaderia);
					vehiculo.addRemito(remito);
					// Si los pedidos combinados llegan al 70%, despacharlos.
					if(vehiculo.getVolumenMax()/100.f*vehiculo.getVolumenDisponible() <= 30)
					{
						vehiculo.despachar();// cambia vehiculo y remitos asociados a "Despachado"
						_pedido.setEstado(ESTADO_DE_PEDIDO.DESPACHADO);
						return "Pedido despachado";
					}else{
						remito.setEstado("pendiente");
						vehiculo.setEstado(ESTADO_VEHICULO.MEDIA_CARGA);			
						_pedido.setEstado(ESTADO_DE_PEDIDO.PENDIENTE);
						return "Pedido Pendiente";
					}
				}else{
				// Si no es por volumen tiene que ser por peso.
					if(vehiculo.getPesoDisponible()<_pedido.getPesoTotal())
					{
						Remito remito = new Remito(0, "Entrega pendiente");// TODO: Nro. remito dejarselo a BBDD
						for(Mercaderia mercaderia : _pedido.getMercaderias())
							remito.addMercaderia(mercaderia);
						vehiculo.addRemito(remito);
						// Si los pedidos combinados llegan al 70%, despacharlos.
						if(vehiculo.getPesoMax()/100.f*vehiculo.getPesoDisponible() <= 30)
						{
							vehiculo.despachar();// cambia vehiculo y remitos asociados a "Despachado"
							_pedido.setEstado(ESTADO_DE_PEDIDO.DESPACHADO);
							return "Pedido despachado";
						}else{
							remito.setEstado("pendiente");
							vehiculo.setEstado(ESTADO_VEHICULO.MEDIA_CARGA);	
							_pedido.setEstado(ESTADO_DE_PEDIDO.PENDIENTE);
							return "Pedido Pendiente";
						}
					}
				}
			}
		}
		// Si tampoco se pudo combinar con otra carga la asigno a un vehiculo que esté disponible
		// y lo dejo en "media carga" para combinar con otra carga a futuro.
		for(Vehiculo vehiculo : vehiculos)
		{
			// Un vehiculo en estado "Disponible" no tiene ninguna carga asignada.
			if(vehiculo.getEstado().equals("disponible"))
			{
				volumenOcupado = 0;
				pesoCombinado = 0;
				if(porVolumen)
					volumenOcupado = vehiculo.getVolumenMax()/100.f*_pedido.getVolumenTotal();
				else //PorPeso
					pesoCombinado = vehiculo.getPesoMax()/100.f*_pedido.getPesoTotal();
				
				if(volumenOcupado > 100 || pesoCombinado > 100)
					continue;// supera la capacidad del vehiculo, pasar al proximo.
				
				Remito remito = new Remito(0, "pendiente");// TODO: Nro. remito dejarselo a BBDD
				for(Mercaderia mercaderia : _pedido.getMercaderias())
					remito.addMercaderia(mercaderia);
				vehiculo.addRemito(remito);
				vehiculo.setEstado(ESTADO_VEHICULO.MEDIA_CARGA);
				_pedido.setEstado(ESTADO_DE_PEDIDO.PENDIENTE);
				//TODO Chequear
				DAOPedido.getInstance().update(Sistema.getInstance().convertPedidoNegocioToPersistencia(_pedido, null));
				
				return "Pedido Pendiente";
			}
		}
		// Es imposible asignar el pedido a un vehiculo propio.
		return new String("No hay vehiculos/espacio disponible");
	}
	
	//------------------------------------------------------------------
	// Busca los pedidos correspondientes a la sucrusal que no hayan
	// sido enviados y que esten por vencer. 
	// Realiza los envios de cualquier forma posible.
	// Devuelve null si no quedaron envíos pendientes.
	//------------------------------------------------------------------
	public String validarPedidosAVencer() 
	{
		float aVencer = 0, propios = 0, terceros = 0;
		List<Pedido> pedidosAVencer = new ArrayList<Pedido>();
		// Recorro los pedidos pendientes y calulo el tiempo restante para 
		// su vencimiento, si es menor a 3 días lo sumo a la lista de pedidos
		// a vencer.
		for(Pedido pedido : pedidos)
		{
			if(pedido.equals("despachado"))
				continue;
			int diasRestantes = (int) TimeUnit.MILLISECONDS.toDays(pedido.getFechaEnregaMaxima().getTime() - (new Date()).getTime());
			if(diasRestantes <= 3)// cualquier número, reemplazar por lo que se necesite
			{
				if(pedido.equals("pendiente"))
				{
					// TODO: Falta una forma de relacionar el pedido con el vehiculo
					// El pedido está asignado a un vehiculo pero esta pendiente, asi que lo despacho.
				/*	for(Vehiculo vehiculo : vehiculos)
					{
						for(Remito remito : vehiculo.getRemitos())
						{
							if(remito.getNroRemito() == 0)
							{
								
							}
						}
					}*/
				}else{
					// El pedido no está asignado, asi que lo añado a una lista para procesar a continuación.
					pedidosAVencer.add(pedido);
				}
			}
		}
		aVencer = pedidosAVencer.size();
		// Intentar despachar con los vehiculos propios
		for(Pedido pedido : pedidosAVencer)
		{
			if(ForzarEnvio(pedido) == null)
				pedidosAVencer.remove(pedido);
		}
		propios = aVencer - pedidosAVencer.size();
		// Despachar los restantes por terceros
		for(Pedido pedido : pedidosAVencer)
		{
			if(TercerizarTransporte(pedido).isEmpty())
				pedidosAVencer.remove(pedido);
		}
		terceros = aVencer - propios - pedidosAVencer.size();
		if(pedidosAVencer.isEmpty())
			return null;
		else
			return new String("Pedidos a vencer:"+aVencer+"\nDespachados por medios propios:"+propios
					+"\nDespachados por terceros:"+terceros+"Pendientes:"+(aVencer-propios-terceros));
	}
	
	private List<EmpresaSubContratada> TercerizarTransporte(Pedido pedido) 
	{
		return Contrataciones.getInstance().contratarTransporteExterno(pedido);
	}
	
	//------------------------------------------------------------------
	// Realiza el envío con vehiculos propios aunque no llegue al 70%
	// caso contrario devuelve el error correspondiente.
	// Devuelve null en un envío exitoso.
	//------------------------------------------------------------------
	public String ForzarEnvio(Pedido _pedido) 
	{
		float volumenOcupado, pesoCombinado = 0;
		boolean porVolumen= (_pedido.getVolumenTotal()>0);
		for(Vehiculo vehiculo : vehiculos)
		{
			// Un vehiculo en estado "Disponible" no tiene ninguna carga asignada.
			if(vehiculo.getEstado().equals("disponible"))
			{
				volumenOcupado = 0;
				pesoCombinado = 0;
				if(porVolumen)
					volumenOcupado = vehiculo.getVolumenMax()/100.f*_pedido.getVolumenTotal();
				else //PorPeso
					pesoCombinado = vehiculo.getPesoMax()/100.f*_pedido.getPesoTotal();
				
				if(volumenOcupado > 100 || pesoCombinado > 100)
					continue;// supera la capacidad del vehiculo, pasar al proximo.
				
				// >70% implica directamente realizar el envío.
				Remito remito = new Remito(0, "pendiente");// TODO: Nro. remito dejarselo a BBDD
				for(Mercaderia mercaderia : _pedido.getMercaderias())
					remito.addMercaderia(mercaderia);
				vehiculo.addRemito(remito);
				vehiculo.setEstado(ESTADO_VEHICULO.DESPACHADO);
				_pedido.setEstado(ESTADO_DE_PEDIDO.DESPACHADO);
				//TODO acualizar en memoria
				
				return null;
			}
		}
		return "No se pudo realizar el envío";
	}
}
