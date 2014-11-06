package dao.entities;

public class ItemFacturaPersistencia {
	
	private float costo;
	private MercaderiaPersistencia mercaderia;
	public ItemFacturaPersistencia(float costo, MercaderiaPersistencia mercaderia) {
		super();
		this.costo = costo;
		this.mercaderia = mercaderia;
	}
	public float getCosto() {
		return costo;
	}
	public MercaderiaPersistencia getMercaderia() {
		return mercaderia;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public void setMercaderia(MercaderiaPersistencia mercaderia) {
		this.mercaderia = mercaderia;
	}
	
	
	
	

}
