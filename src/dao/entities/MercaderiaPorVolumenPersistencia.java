package dao.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="porVolumen")

public class MercaderiaPorVolumenPersistencia extends MercaderiaPersistencia{
	
	private float volumen;

	public MercaderiaPorVolumenPersistencia(float alto, float ancho, float profundidad, String fragilidad, boolean aplicable, int cantApilable,
			String condDeViaje, String indicacionesManpulacion,	String coordenadasDestino, float volumen, RemitoPersistencia remito) 
	{
		super(alto, ancho, profundidad, fragilidad, aplicable, cantApilable,
				condDeViaje, indicacionesManpulacion, coordenadasDestino, remito);
		this.volumen = volumen;
	}

	public float getVolumen() {
		return volumen;
	}

	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}

	
	
}
