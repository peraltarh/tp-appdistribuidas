package dao.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="porPeso")
public class MercaderiaPorPesoPersistencia extends MercaderiaPersistencia implements Serializable{

	private float peso;

	public MercaderiaPorPesoPersistencia(float alto, float ancho, float profundidad, String fragilidad, boolean aplicable, int cantApilable,
			String condDeViaje, String indicacionesManpulacion,	String coordenadasDestino, float peso, RemitoPersistencia remito, PedidoPersistencia pedido, DepositoPersistencia deposito) {
		super(alto, ancho, profundidad, fragilidad, aplicable, cantApilable,condDeViaje, indicacionesManpulacion, coordenadasDestino, remito, pedido, deposito);
		this.peso = peso;
	}

	public MercaderiaPorPesoPersistencia()
	{
		super();
	}
	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	
	
	
	
}
