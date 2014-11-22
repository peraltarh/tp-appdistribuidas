package dao.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import clases.MovimientoCuenta;

@Entity
@Table(name="MovimientoCuenta")
public class MovimientoCuentaPersistencia {
	
	private int idMovimiento;
	private Date fecha;
	private float monto;
	private CuentaCorrientePersistencia cuenta;
	
	public MovimientoCuentaPersistencia(Date fecha, float monto, CuentaCorrientePersistencia cuenta) {
		super();
		this.fecha = fecha;
		this.monto = monto;
		this.cuenta = cuenta;
	}
	
	public MovimientoCuentaPersistencia(){}
	
	
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
	public CuentaCorrientePersistencia getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaCorrientePersistencia cuenta) {
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

	public MovimientoCuenta toNegocio() 
	{
		MovimientoCuenta mc = new MovimientoCuenta();
		mc.setFecha(fecha);
		mc.setMonto(monto);
		return mc;
	}
	
	
	

}
