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
public class CuentaCorrientePersistencia {
	private int cbu;
	private float saldoActual;
	private float minimoPermitidoSinAuth;
	private boolean estado;
	private EmpresaPersistencia empresa;
	private List<MovimientoCuentaPersistencia> movimientos;
	
	public CuentaCorrientePersistencia(int cbu,float saldoActual, float minimoPermitidoSinAuth,
			boolean estado, EmpresaPersistencia emp) {
		super();
		this.cbu = cbu;
		this.saldoActual = saldoActual;
		this.minimoPermitidoSinAuth = minimoPermitidoSinAuth;
		this.estado = estado;
		this.movimientos = new ArrayList<MovimientoCuentaPersistencia>();
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

	public void setMovimientos(List<MovimientoCuentaPersistencia> movimientos) {
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
	public List<MovimientoCuentaPersistencia> getMovimientos() {
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

	
	public void addMovimiento(MovimientoCuentaPersistencia movimiento) {
		this.saldoActual=this.saldoActual+movimiento.getMonto();
		this.movimientos.add(movimiento);
	}
	
	
	
	@ManyToOne
	@JoinColumn(name="empresa")
	public EmpresaPersistencia getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaPersistencia empresa) {
		this.empresa = empresa;
	}

}
