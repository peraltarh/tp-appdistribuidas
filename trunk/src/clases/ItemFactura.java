package clases;

public class ItemFactura {
	
	private float costo;
	private Mercaderia mercaderia;
	public ItemFactura(float costo, Mercaderia mercaderia) {
		super();
		this.costo = costo;
		this.mercaderia = mercaderia;
	}
	public float getCosto() {
		return costo;
	}
	public Mercaderia getMercaderia() {
		return mercaderia;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public void setMercaderia(Mercaderia mercaderia) {
		this.mercaderia = mercaderia;
	}
	
	
	
	

}
