package clases;

import java.util.ArrayList;

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
	
	

}
