package dao.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CuentaCorriente")
public class CuentaCorriente {
	private int cbu;
	private float saldoActual;
	private float minimoPermitidoSinAuth;
	private boolean estado;
	private Empresa empresa;
	private List<MovimientoCuenta> movimientos;
	
	public CuentaCorriente(int cbu,float saldoActual, float minimoPermitidoSinAuth,
			boolean estado, Empresa emp) {
		super();
		this.cbu = cbu;
		this.saldoActual = saldoActual;
		this.minimoPermitidoSinAuth = minimoPermitidoSinAuth;
		this.estado = estado;
		this.movimientos = new ArrayList<MovimientoCuenta>();
		this.empresa = emp;
	}

	@Id
	@Column(nullable = false)
	public int getCbu() {
		return cbu;
	}

	public void setCbu(int cbu) {
		this.cbu = cbu;
	}

	public void setMovimientos(List<MovimientoCuenta> movimientos) {
		this.movimientos = movimientos;
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

	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="cbu")
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
	
	
	
	@ManyToOne
	@JoinColumn(name="empresa")
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
