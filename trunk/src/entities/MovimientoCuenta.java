package entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MovimientoCuenta")
public class MovimientoCuenta {
	
	private int idMovimiento;
	private Date fecha;
	private float monto;
	private CuentaCorriente cuenta;
	
	public MovimientoCuenta(Date fecha, float monto, CuentaCorriente cuenta) {
		super();
		this.fecha = fecha;
		this.monto = monto;
		this.cuenta = cuenta;
	}
	
	
	@Id
	@GeneratedValue
	public int getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}


	@ManyToOne
	@JoinColumn(name="cbu")
	public CuentaCorriente getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaCorriente cuenta) {
		this.cuenta = cuenta;
	}


	public Date getFecha() {
		return fecha;
	}
	public float getMonto() {
		return monto;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	
	
	

}
