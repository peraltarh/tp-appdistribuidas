package clases;

import java.sql.Date;

public class Movimiento {

	private Date fechaSalida;
	private Date fechaLlegada;
	private String origen;
	private String destino;
	private String condicionDeArribo;
	private String estado;
	private int idMovimiento;
	
	public Movimiento(Date fechaSalida, Date fechaLlegada, String origen,
			String destino, String condicionDeArribo, String estado) {
		super();
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.origen = origen;
		this.destino = destino;
		this.condicionDeArribo = condicionDeArribo;
		this.estado = estado;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public String getOrigen() {
		return origen;
	}

	public String getDestino() {
		return destino;
	}

	public String getCondicionDeArribo() {
		return condicionDeArribo;
	}

	public String getEstado() {
		return estado;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public void setCondicionDeArribo(String condicionDeArribo) {
		this.condicionDeArribo = condicionDeArribo;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}


	
	
	
}
