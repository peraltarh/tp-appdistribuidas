package clases;

import java.util.ArrayList;

public class CuentaCorriente {
	
	private float saldoActual;
	private float minimoPermitidoSinAuth;
	private boolean estado;
	private ArrayList<MovimientoCuenta> movimientos;
	
	public CuentaCorriente(float saldoActual, float minimoPermitidoSinAuth,
			boolean estado) {
		super();
		this.saldoActual = saldoActual;
		this.minimoPermitidoSinAuth = minimoPermitidoSinAuth;
		this.estado = estado;
		this.movimientos = new ArrayList<MovimientoCuenta>();
	}

	public float getSaldoActual() {
		return saldoActual;
	}

	public float getMinimoPermitidoSinAuth() {
		return minimoPermitidoSinAuth;
	}

	public boolean isEstado() {
		return estado;
	}

	public ArrayList<MovimientoCuenta> getMovimientos() {
		return movimientos;
	}

	public void setSaldoActual(float saldoActual) {
		this.saldoActual = saldoActual;
	}

	public void setMinimoPermitidoSinAuth(float minimoPermitidoSinAuth) {
		this.minimoPermitidoSinAuth = minimoPermitidoSinAuth;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void addMovimiento(MovimientoCuenta movimiento) {
		this.movimientos.add(movimiento);
	}
	
	
	
	

}
