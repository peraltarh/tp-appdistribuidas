package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;

import dao.entities.*;

public interface InterfazEnvios extends Remote
{
	public void EmpresaDirValidas( String direccion, EmpresaPersistencia empresa) throws RemoteException;
	public void CuentaCorriente(int cbu,float saldoActual, float minimoPermitidoSinAuth, boolean TRUE, EmpresaPersistencia emp) throws RemoteException;
	public void MovimientoCuenta(Date fecha, float monto, CuentaCorrientePersistencia cuenta) throws RemoteException;
	public void altaParticular(String direccion, String telefono, String nombre, String apellido, String dni) throws RemoteException;
	public void Producto(String tipo, String descripcion,EmpresaPersistencia empresa) throws RemoteException;
	public void altaEmpresa(String direccion, String telefono, String razonSoial, String cuit, String regularidad) throws RemoteException;
	
}
