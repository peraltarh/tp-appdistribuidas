package dao.entities;

import java.util.ArrayList;
import java.util.List;

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
	public SucursalPersistencia(){}
	
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
	public void addPedido(PedidoPersistencia pedido) {
		this.pedidos.add(pedido);
	}
	public void addVehiculo(VehiculoPersistencia vehiculo) {
		this.vehiculos.add(vehiculo);
	}
	public void addRuta(MapaDeRutaPersistencia ruta) {
		this.rutas.add(ruta);
	}
	public void setDepositos(List<DepositoPersistencia> depositos) {
		this.depositos = depositos;
	}
	public void setPedidos(List<PedidoPersistencia> pedidos) {
		this.pedidos = pedidos;
	}
	public void setVehiculos(List<VehiculoPersistencia> vehiculos) {
		this.vehiculos = vehiculos;
	}
	public void setRutas(List<MapaDeRutaPersistencia> rutas) {
		this.rutas = rutas;
	}
	
}
