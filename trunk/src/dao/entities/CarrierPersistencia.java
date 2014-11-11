package dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Carrier")
public class CarrierPersistencia {
	
	private int idCarrier;
	private String origen;
	private String destino;
	private float costo;
	private ConsideracionEspecialPersistencia consideracionEspecial;
	public CarrierPersistencia(String origen, String destino, float costo,ConsideracionEspecialPersistencia consideracionEspecial) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.costo = costo;
		this.consideracionEspecial=consideracionEspecial;
	}
	
	public CarrierPersistencia(){}
	
@Id
@GeneratedValue
	public int getIdCarrier() {
		return idCarrier;
	}

	public void setIdCarrier(int idCarrier) {
		this.idCarrier = idCarrier;
	}
	
	@ManyToOne
	@JoinColumn(name="idConsideracionEspecial")
	public ConsideracionEspecialPersistencia getConsideracionEspecial() {
		return consideracionEspecial;
	}
	public void setConsideracionEspecial(
			ConsideracionEspecialPersistencia consideracionEspecial) {
		this.consideracionEspecial = consideracionEspecial;
	}








	public String getOrigen() {
		return origen;
	}
	public String getDestino() {
		return destino;
	}
	public float getCosto() {
		return costo;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	
	
	

}
