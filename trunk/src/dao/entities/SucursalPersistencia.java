package dao.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Sucursal")

public class SucursalPersistencia {
	
	private int numeroSucursal;
	private String nombre;
	private String dir;
	private String gerente;
	private String encDespacho;
	private String encRecepcion;
	private List<DepositoPersistencia> depositos;
	private List<PedidoPersistencia> pedidos;
	private List<VehiculoPersistencia> vehiculos;
	private List<MapaDeRutaPersistencia> rutas;
	public SucursalPersistencia(String nombre, String dir, String gerente,
			String encDespacho, String encRecepcion) {
		this.nombre = nombre;
		this.dir = dir;
		this.gerente = gerente;
		this.encDespacho = encDespacho;
		this.encRecepcion = encRecepcion;
		this.depositos = new ArrayList<DepositoPersistencia>();
		this.pedidos = new ArrayList<PedidoPersistencia>();
		this.vehiculos = new ArrayList<VehiculoPersistencia>();
		this.rutas = new ArrayList<MapaDeRutaPersistencia>();
	}
	
	@Id
	@GeneratedValue
	public int getNumeroSucursal() {
		return numeroSucursal;
	}
	public void setNumeroSucursal(int numeroSucursal) {
		this.numeroSucursal = numeroSucursal;
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
	
	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="numeroSucursal")
	public List<DepositoPersistencia> getDepositos() {
		return depositos;
	}

	public void setDepositos(ArrayList<DepositoPersistencia> depositos) {
		this.depositos = depositos;
	}
	
	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="numeroSucursal")
	public List<PedidoPersistencia> getPedidos() {
		return pedidos;
	}
	public void setPedidos(ArrayList<PedidoPersistencia> pedidos) {
		this.pedidos = pedidos;
	}
	
	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="numeroSucursal")
	public List<VehiculoPersistencia> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(ArrayList<VehiculoPersistencia> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="numeroSucursal")
	public List<MapaDeRutaPersistencia> getRutas() {
		return rutas;
	}
	
	public void setRutas(ArrayList<MapaDeRutaPersistencia> rutas) {
		this.rutas = rutas;
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
	public void addDeposito(DepositoPersistencia deposito) {
		this.depositos.add(deposito);
	}
//	public void addPedido(PedidoPersistencia pedido) {
//		this.pedidos.add(pedido);
//	}
//	public void addVehiculo(VehiculoPersistencia vehiculo) {
//		this.vehiculos.add(vehiculo);
//	}
//	public void addRuta(MapaDeRutaPersistencia ruta) {
//		this.rutas.add(ruta);
//	}
	
	// Recibe un cliente nuevo o el Id del cliente(si ya existe), mas un pedido completo
//	public String RegistrarPedido(ClientePersistencia _cliente, PedidoPersistencia _pedido)
//	{
//		String resultado = "";
//		ClientePersistencia clienteBD = null;// TODO: Reemplazar null por busqueda en la BBDD (DAOCliente)
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
//				if(_cliente.getClass()==ParticularPersistencia.class)
//					;
////					DAOCliente.getInstance().persistir(((Particular)_cliente).getEntity());
//				else
//					;
////					DAOCliente.getInstance().persistir(((Empresa)_cliente).getEntity());
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
////		DAOPedido.getInstance().persistir(_pedido);
//		
//		return resultado;// Operación finalizada con éxito
//	}
	
	// Comprueba que no falten completar datos del cliente
	public String validarCliente(ClientePersistencia _cliente)
	{
		String validacion = "";
		if(_cliente.getDireccion().isEmpty())
			validacion += "Completar dirección. \n";
		if(_cliente.getTelefono().isEmpty())
			validacion += "Completar telefono. \n";
		if(_cliente.getClass()==ParticularPersistencia.class)
		{
			ParticularPersistencia particular = (ParticularPersistencia)_cliente;
			if(particular.getDni().isEmpty())
				validacion += "Completar DNI. \n";
			if(particular.getApellido().isEmpty())
				validacion += "Completar apellido. \n";
			if(particular.getNombre().isEmpty())
				validacion += "Completar nombre. \n";
		}else{
			EmpresaPersistencia empresa = (EmpresaPersistencia)_cliente;
			// TODO: añadir los datos que faltan.
			if(empresa.getRazonSoial().isEmpty())
				validacion += "Completar razón social. \n";
		
		}
		return validacion;// Si todo esta Ok devuelve un String vacio.
	}
	
	public String validarMercaderia(ClientePersistencia _cliente, MercaderiaPersistencia _mercaderia)
	{
		String validacion = "";
		//TODO: _cliente.get getAutorizaciones -> implementar?
//		for(PoliticasDeEnvio politica :Sistema.getInstance().getPoliticas())
//		{
//			validacion = politica.Evaluar(_mercaderia);
//		}
		return validacion;
	}
	
//	public String ProgramarEnvio(PedidoPersistencia _pedido) 
//	{
//		for(VehiculoPersistencia vehiculo : vehiculos)
//		{
//			if(vehiculo.getEstado().equals("Disponible"))// TODO: Cambiar por enum?
//			{
//				// TODO: y ahora? hay mercaderia por volumen y por peso pero no con
//				// 		 ambos. Por ahora queda solamente por volumen con cast.
//				float volumenOcupado = vehiculo.getVolumenMax()/100.f*_pedido.getVolumenTotal();
//				if(volumenOcupado > 100)
//					continue;
//				if(volumenOcupado > 70)
//				{
//					RemitoPersistencia remito = new RemitoPersistencia(1, "Entrega pendiente");// TODO: Nro. remito dejarselo a BBDD
//					for(MercaderiaPersistencia mercaderia : _pedido.getMercaderias())
//						remito.addMercaderia(mercaderia);
//					vehiculo.addRemito(remito);
//					vehiculo.setEstado("Despachar");
//					return null;
//				}else{
//					RemitoPersistencia remito = new RemitoPersistencia(1, "Entrega pendiente");// TODO: Nro. remito dejarselo a BBDD
//					for(MercaderiaPersistencia mercaderia : _pedido.getMercaderias())
//						remito.addMercaderia(mercaderia);
//					vehiculo.addRemito(remito);
//					vehiculo.setEstado("Media carga");
//					return null;
//				}
//			}else{
//				if(vehiculo.getEstado().equals("Media carga")  && vehiculo.getVolumenDisponible()<_pedido.getVolumenTotal())
//				{
//					RemitoPersistencia remito = new RemitoPersistencia(1, "Entrega pendiente");// TODO: Nro. remito dejarselo a BBDD
//					for(MercaderiaPersistencia mercaderia : _pedido.getMercaderias())
//						remito.addMercaderia(mercaderia);
//					vehiculo.addRemito(remito);
//					
//					if(vehiculo.getVolumenMax()/100.f*vehiculo.getVolumenDisponible() <= 30)
//					{
//						vehiculo.setEstado("Despachar");
//						return null;
//					}else{
//						vehiculo.setEstado("Media carga");			
//						return null;
//					}
//				}
//			}
//		}
//		return new String("No hay vehiculos/espacio disponible");
//	}
//	
//	public String validarPedidosAVencer() 
//	{
//		float aVencer = 0, propios = 0, terceros = 0;
//		List<PedidoPersistencia> pedidosAVencer = new ArrayList<PedidoPersistencia>();
//		for(PedidoPersistencia pedido : pedidos)
//		{
//			int diasRestantes = (int) TimeUnit.MILLISECONDS.toDays(pedido.getFechaEnregaMaxima().getTime() - (new Date()).getTime());
//			// TODO: Cuando estaria por vencer?
//			if(diasRestantes <= 3)// cualquier número, reemplazar por lo que se necesite
//				pedidosAVencer.add(pedido);
//		}
//		aVencer = pedidosAVencer.size();
//		// Intentar despachar con los vehiculos propios
//		for(PedidoPersistencia pedido : pedidosAVencer)
//		{
//			if(ProgramarEnvio(pedido).isEmpty())// String vacio significa que se completo exitosamente la operación
//				pedidosAVencer.remove(pedido);
//		}
//		propios = aVencer - pedidosAVencer.size();
//		// Despachar los restantes por terceros
//		for(PedidoPersistencia pedido : pedidosAVencer)
//		{
//			if(TercerizarTransporte(pedido).isEmpty())
//				pedidosAVencer.remove(pedido);
//		}
//		terceros = aVencer - propios - pedidosAVencer.size();
//		if(pedidosAVencer.isEmpty())
//			return null;
//		else
//			return new String("Pedidos a vencer:"+aVencer+"\nDespachados por medios propios:"+propios
//					+"\nDespachados por terceros:"+terceros+"Pendientes:"+(aVencer-propios-terceros));
//	}
//	
//	private String TercerizarTransporte(PedidoPersistencia pedido) 
//	{
//		return ContratacionesPersistencia.getInstance().contratarTransporteExterno(pedido);
//	}
	
}
