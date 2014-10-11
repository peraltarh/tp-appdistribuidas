package repositorio_RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;

import dao.entities.*;

public interface TDAManejoDatos extends Remote
{
	/* alta de un Cliente */
	public void Cliente(String direccion, String telefono) throws RemoteException;
	
	/* alta de una Empresa */
	public void Empresa(String direccion, String telefono, String razonSoial,
			String cuit, String regularidad) throws RemoteException;
	
	/* alta de un Empresa Direccion Valida */
	public void EmpresaDirValidas( String direccion, Empresa empresa) throws RemoteException;

	
	/* alta de una CuentaCorriente */
	public void CuentaCorriente(int cbu,float saldoActual, float minimoPermitidoSinAuth, boolean TRUE, Empresa emp) throws RemoteException;
	
	/* alta de una MovimientoCuenta */
	public void MovimientoCuenta(Date fecha, float monto, CuentaCorriente cuenta) throws RemoteException;
	
	/* alta de una Particular */
	public void Particular(String direccion, String telefono, String nombre, String apellido, long dni) throws RemoteException;
	
	/* alta de una Producto */
	public void Producto(String tipo, String descripcion,Empresa empresa) throws RemoteException;
	
}
