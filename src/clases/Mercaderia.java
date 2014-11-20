package clases;

import java.util.ArrayList;

public class Mercaderia {
	
	private float alto;
	private float ancho;
	private float profundidad;
	private String fragilidad;
	private boolean aplilable;
	private int cantApilable;
	private int idMercaderia;
	private String condDeViaje;
	private String indicacionesManpulacion;
	private String coordenadasDestino;
	private ArrayList<Movimiento> movimientos;
	
	public Mercaderia(float alto, float ancho, float profundidad,
			String fragilidad, boolean aplicable, int cantApilable,
			String condDeViaje, String indicacionesManpulacion,
			String coordenadasDestino) {
		super();
		this.alto = alto;
		this.ancho = ancho;
		this.profundidad = profundidad;
		this.fragilidad = fragilidad;
		this.aplilable = aplicable;
		this.cantApilable = cantApilable;
		this.condDeViaje = condDeViaje;
		this.indicacionesManpulacion = indicacionesManpulacion;
		this.coordenadasDestino = coordenadasDestino;
		this.movimientos = new ArrayList<Movimiento>();
	}

	public Mercaderia() {
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

	public boolean isAplilable() {
		return aplilable;
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

	public ArrayList<Movimiento> getMovimientos() {
		return movimientos;
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

	public void setAplilable(boolean aplicable) {
		this.aplilable = aplicable;
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

	public void addMovimiento (Movimiento movimiento) {
		this.movimientos.add(movimiento);
	}

	public int getIdMercaderia() {
		return idMercaderia;
	}

	public void setIdMercaderia(int idMercaderia) {
		this.idMercaderia = idMercaderia;
	}

	public void setMovimientos(ArrayList<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	
}
