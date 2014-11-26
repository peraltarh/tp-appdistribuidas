package dao.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import clases.Mercaderia;


@Entity
@Table(name="Mercaderia")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo",discriminatorType=DiscriminatorType.STRING)

public abstract class MercaderiaPersistencia implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int idMercaderia;
	protected float alto;
	protected float ancho;
	protected float profundidad;
	protected String fragilidad;
	protected boolean apilable;
	protected int cantApilable;
	protected String condDeViaje;
	protected String indicacionesManpulacion;
	protected String coordenadasDestino;
	protected RemitoPersistencia remito;
	protected List<MovimientoPersistencia> movimientos;
	protected PedidoPersistencia pedido;
	protected DepositoPersistencia deposito;
	
	public MercaderiaPersistencia(float alto, float ancho, float profundidad,String fragilidad, boolean aplicable, int cantApilable,
			String condDeViaje, String indicacionesManpulacion,	String coordenadasDestino, RemitoPersistencia remito, PedidoPersistencia pedido, DepositoPersistencia deposito) {
		this.alto = alto;
		this.ancho = ancho;
		this.profundidad = profundidad;
		this.fragilidad = fragilidad;
		this.apilable= aplicable;
		this.cantApilable = cantApilable;
		this.condDeViaje = condDeViaje;
		this.indicacionesManpulacion = indicacionesManpulacion;
		this.coordenadasDestino = coordenadasDestino;
		this.movimientos = new ArrayList<MovimientoPersistencia>();
		this.remito=remito;
		this.pedido=pedido;
		this.deposito=deposito;
	}

	public MercaderiaPersistencia()
	{
	}
	
	@Id
	@GeneratedValue
	public int getIdMercaderia() {
		return idMercaderia;
	}
	public void setIdMercaderia(int idMercaderia) {
		this.idMercaderia = idMercaderia;
	}


@ManyToOne
@JoinColumn(name="nroRemito")
	public RemitoPersistencia getRemito() {
		return remito;
	}



	public void setRemito(RemitoPersistencia remito) {
		this.remito = remito;
	}


@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="idMercaderia")
	public List<MovimientoPersistencia> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<MovimientoPersistencia> movimientos) {
		this.movimientos = movimientos;
	}



	public float getAlto() {
		return alto;
	}

	public float getAncho() {
		return ancho;
	}

	public float getProfundidad() {
		return profundidad;
	}

	public String getFragilidad() {
		return fragilidad;
	}

	public boolean isApilable() {
		return apilable;
	}

	public int getCantApilable() {
		return cantApilable;
	}

	public String getCondDeViaje() {
		return condDeViaje;
	}

	public String getIndicacionesManpulacion() {
		return indicacionesManpulacion;
	}

	public String getCoordenadasDestino() {
		return coordenadasDestino;
	}

	public void setAlto(float alto) {
		this.alto = alto;
	}

	public void setAncho(float ancho) {
		this.ancho = ancho;
	}

	public void setProfundidad(float profundidad) {
		this.profundidad = profundidad;
	}

	public void setFragilidad(String fragilidad) {
		this.fragilidad = fragilidad;
	}

	public void setApilable(boolean aplicable) {
		this.apilable= aplicable;
	}

	public void setCantApilable(int cantApilable) {
		this.cantApilable = cantApilable;
	}

	public void setCondDeViaje(String condDeViaje) {
		this.condDeViaje = condDeViaje;
	}

	public void setIndicacionesManpulacion(String indicacionesManpulacion) {
		this.indicacionesManpulacion = indicacionesManpulacion;
	}

	public void setCoordenadasDestino(String coordenadasDestino) {
		this.coordenadasDestino = coordenadasDestino;
	}

	public void addMovimiento (MovimientoPersistencia movimiento) {
		this.movimientos.add(movimiento);
	}

	@ManyToOne
	@JoinColumn(name="idPedido")
	public PedidoPersistencia getPedido() {
		return pedido;
	}


	public void setPedido(PedidoPersistencia pedido) {
		this.pedido = pedido;
	}


@ManyToOne
@JoinColumn(name="idDeposito")
	public DepositoPersistencia getDeposito() {
		return deposito;
	}


	public void setDeposito(DepositoPersistencia deposito) {
		this.deposito = deposito;
	}

	public Mercaderia toNegocio() 
	{
		Mercaderia m = new Mercaderia();
		m.setAlto(alto);
		m.setAncho(ancho);
		m.setAplilable(apilable);
		m.setCantApilable(cantApilable);
		m.setCondDeViaje(condDeViaje);
		m.setCoordenadasDestino(coordenadasDestino);
		m.setFragilidad(fragilidad);
		m.setIdMercaderia(idMercaderia);
		m.setIndicacionesManpulacion(indicacionesManpulacion);
		m.setProfundidad(profundidad);
		for(MovimientoPersistencia movimiento: movimientos)
			m.addMovimiento(movimiento.toNegocio());
		return m;
	}

	
}
