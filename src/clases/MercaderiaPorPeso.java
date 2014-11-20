package clases;

public class MercaderiaPorPeso extends Mercaderia{

	private float peso;

	public MercaderiaPorPeso(float alto, float ancho, float profundidad,
			String fragilidad, boolean aplicable, int cantApilable,
			String condDeViaje, String indicacionesManpulacion,
			String coordenadasDestino, float peso) {
		super(alto, ancho, profundidad, fragilidad, aplicable, cantApilable,
				condDeViaje, indicacionesManpulacion, coordenadasDestino);
		this.peso = peso;
	}

	public MercaderiaPorPeso() {
		super();
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	
	
	
	
}
