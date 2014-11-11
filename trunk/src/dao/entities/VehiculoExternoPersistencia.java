package dao.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;


@Entity
@Table(name="VehiculoExterno")


public class VehiculoExternoPersistencia {
	
	private int idVehiculoExterno;
	private String tipo;
	private String identificacion;
	private float capacidadCarga;
	private ConsideracionEspecialPersistencia consideracionEspecial;
	public VehiculoExternoPersistencia(String tipo, String identificacion,
			float capacidadCarga, ConsideracionEspecialPersistencia consideracionEspecial) {
		super();
		this.tipo = tipo;
		this.identificacion = identificacion;
		this.capacidadCarga = capacidadCarga;
		this.consideracionEspecial=consideracionEspecial;
	}

	public VehiculoExternoPersistencia(){}
	@Id
	@GeneratedValue
	public int getIdVehiculoExterno() {
		return idVehiculoExterno;
	}


	public void setIdVehiculoExterno(int idVehiculoExterno) {
		this.idVehiculoExterno = idVehiculoExterno;
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


	public String getTipo() {
		return tipo;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public float getCapacidadCarga() {
		return capacidadCarga;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public void setCapacidadCarga(float capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}
	
	

}
