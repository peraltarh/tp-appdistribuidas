package clases;

import java.util.ArrayList;
import java.util.List;

public class CuentaCorriente {
	
	private int cbu;
	private float saldoActual;
	private float minimoPermitidoSinAuth;
	private boolean estado;
	private List<MovimientoCuenta> movimientos;
	
	public CuentaCorriente(int cbu,float saldoActual, float minimoPermitidoSinAuth,
			boolean estado) {
		this.cbu=cbu;
		this.saldoActual = saldoActual;
		this.minimoPermitidoSinAuth = minimoPermitidoSinAuth;
		this.estado = estado;
		this.movimientos = new ArrayList<MovimientoCuenta>();
	}

	public CuentaCorriente() {
		// TODO Auto-generated constructor stub
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

	public List<MovimientoCuenta> getMovimientos() {
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

	public void setMovimientos(List<MovimientoCuenta> movimientos) {
		this.movimientos = movimientos;
	}

	public int getCbu() {
		return cbu;
	}

	public void setCbu(int cbu) {
		this.cbu = cbu;
	}
	
	
	
	

}
