package dao.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Movimiento")
public class MovimientoPersistencia {

	private int idMovimiento;
	private Date fechaSalida;
	private Date fechaLlegada;
	private String origen;
	private String destino;
	private String condicionDeArribo;
	private String estado;
	private MercaderiaPersistencia mercaderia;
	
	public MovimientoPersistencia(Date fechaSalida, Date fechaLlegada, String origen,
			String destino, String condicionDeArribo, String estado, MercaderiaPersistencia mercaderia) {
		super();
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.origen = origen;
		this.destino = destino;
		this.condicionDeArribo = condicionDeArribo;
		this.estado = estado;
	}

	public MovimientoPersistencia(){}
	
	@Id
	@GeneratedValue
	public int getIdMovimiento() {
		return idMovimiento;
	}




	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}



@ManyToOne
@JoinColumn(name="idMercaderia")
	public MercaderiaPersistencia getMercaderia() {
		return mercaderia;
	}




	public void setMercaderia(MercaderiaPersistencia mercaderia) {
		this.mercaderia = mercaderia;
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
	
	
	
}
