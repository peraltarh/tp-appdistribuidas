package clases;

public class MercaderiaPorVolumen extends Mercaderia{
	
	private float volumen;

	public MercaderiaPorVolumen(float alto, float ancho, float profundidad,
			String fragilidad, boolean aplicable, int cantApilable,
			String condDeViaje, String indicacionesManpulacion,
			String coordenadasDestino, float volumen) {
		super(alto, ancho, profundidad, fragilidad, aplicable, cantApilable,
				condDeViaje, indicacionesManpulacion, coordenadasDestino);
		this.volumen = volumen;
	}

	public float getVolumen() {
		return volumen;
	}

	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}

	
	
}
