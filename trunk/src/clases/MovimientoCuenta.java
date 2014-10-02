package clases;

import java.sql.Date;

public class MovimientoCuenta {
	
	private Date fecha;
	private float monto;
	public MovimientoCuenta(Date fecha, float monto) {
		super();
		this.fecha = fecha;
		this.monto = monto;
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
