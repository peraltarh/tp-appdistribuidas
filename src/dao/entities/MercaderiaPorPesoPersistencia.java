package dao.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="porPeso")
public class MercaderiaPorPesoPersistencia extends MercaderiaPersistencia{

	private float peso;

	public MercaderiaPorPesoPersistencia(float alto, float ancho, float profundidad, String fragilidad, boolean aplicable, int cantApilable,
			String condDeViaje, String indicacionesManpulacion,	String coordenadasDestino, float peso, RemitoPersistencia remito) {
		super(alto, ancho, profundidad, fragilidad, aplicable, cantApilable,condDeViaje, indicacionesManpulacion, coordenadasDestino, remito);
		this.peso = peso;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	
	
	
	
}
