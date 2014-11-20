package clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import clases.controller.Sistema;

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
	
	// Comprueba que no falten completar datos del cliente
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
			// TODO: añadir los datos que faltan.
			if(empresa.getRazonSoial().isEmpty())
				validacion += "Completar razón social. \n";
		
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
	
	public String ProgramarEnvio(Pedido _pedido) 
	{
		for(Vehiculo vehiculo : vehiculos)
		{
			if(vehiculo.getEstado().equals("Disponible"))// TODO: Cambiar por enum?
			{
				// TODO: y ahora? hay mercaderia por volumen y por peso pero no con
				// 		 ambos. Por ahora queda solamente por volumen con cast.
				float volumenOcupado = vehiculo.getVolumenMax()/100.f*_pedido.getVolumenTotal();
				if(volumenOcupado > 100)
					continue;
				if(volumenOcupado > 70)
				{
					Remito remito = new Remito(1, "Entrega pendiente");// TODO: Nro. remito dejarselo a BBDD
					for(Mercaderia mercaderia : _pedido.getMercaderias())
						remito.addMercaderia(mercaderia);
					vehiculo.addRemito(remito);
					vehiculo.setEstado("Despachar");
					return null;
				}else{
					Remito remito = new Remito(1, "Entrega pendiente");// TODO: Nro. remito dejarselo a BBDD
					for(Mercaderia mercaderia : _pedido.getMercaderias())
						remito.addMercaderia(mercaderia);
					vehiculo.addRemito(remito);
					vehiculo.setEstado("Media carga");
					return null;
				}
			}else{
				if(vehiculo.getEstado().equals("Media carga")  && vehiculo.getVolumenDisponible()<_pedido.getVolumenTotal())
				{
					Remito remito = new Remito(1, "Entrega pendiente");// TODO: Nro. remito dejarselo a BBDD
					for(Mercaderia mercaderia : _pedido.getMercaderias())
						remito.addMercaderia(mercaderia);
					vehiculo.addRemito(remito);
					
					if(vehiculo.getVolumenMax()/100.f*vehiculo.getVolumenDisponible() <= 30)
					{
						vehiculo.setEstado("Despachar");
						return null;
					}else{
						vehiculo.setEstado("Media carga");			
						return null;
					}
				}
			}
		}
		return new String("No hay vehiculos/espacio disponible");
	}
	
	public String validarPedidosAVencer() 
	{
		float aVencer = 0, propios = 0, terceros = 0;
		List<Pedido> pedidosAVencer = new ArrayList<Pedido>();
		for(Pedido pedido : pedidos)
		{
			int diasRestantes = (int) TimeUnit.MILLISECONDS.toDays(pedido.getFechaEnregaMaxima().getTime() - (new Date()).getTime());
			// TODO: Cuando estaria por vencer?
			if(diasRestantes <= 3)// cualquier número, reemplazar por lo que se necesite
				pedidosAVencer.add(pedido);
		}
		aVencer = pedidosAVencer.size();
		// Intentar despachar con los vehiculos propios
		for(Pedido pedido : pedidosAVencer)
		{
			if(ProgramarEnvio(pedido).isEmpty())// String vacio significa que se completo exitosamente la operación
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
	
	private String TercerizarTransporte(Pedido pedido) 
	{
		return Contrataciones.getInstance().contratarTransporteExterno(pedido);
	}
	
}
