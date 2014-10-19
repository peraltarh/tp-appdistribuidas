package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;

import dao.entities.*;

public interface InterfazEnvios extends Remote
{
	public void altaCliente(String direccion, String telefono) throws RemoteException;
	public void Empresa(String direccion, String telefono, String razonSoial,String cuit, String regularidad) throws RemoteException;
	public void EmpresaDirValidas( String direccion, Empresa empresa) throws RemoteException;
	public void CuentaCorriente(int cbu,float saldoActual, float minimoPermitidoSinAuth, boolean TRUE, Empresa emp) throws RemoteException;
	public void MovimientoCuenta(Date fecha, float monto, CuentaCorriente cuenta) throws RemoteException;
	public void Particular(String direccion, String telefono, String nombre, String apellido, long dni) throws RemoteException;
	public void Producto(String tipo, String descripcion,Empresa empresa) throws RemoteException;
	
}
