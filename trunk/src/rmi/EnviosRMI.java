package rmi;

import interfaz.InterfazEnvios;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;

import controller.MesaController;
import clases.controller.Sistema;

public class EnviosRMI extends UnicastRemoteObject implements InterfazEnvios
{

	public EnviosRMI() throws RemoteException {
//		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void Cliente(String direccion, String telefono)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Empresa(String direccion, String telefono, String razonSoial, String cuit, String regularidad) throws RemoteException {
		Sistema controller = new Sistema();
		return controller.getMesasPorEstado(estado);
		
	}

	@Override
	public void EmpresaDirValidas(String direccion, dao.entities.Empresa empresa)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CuentaCorriente(int cbu, float saldoActual,
			float minimoPermitidoSinAuth, boolean TRUE, dao.entities.Empresa emp)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void MovimientoCuenta(Date fecha, float monto, dao.entities.CuentaCorriente cuenta) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Particular(String direccion, String telefono, String nombre,
			String apellido, long dni) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Producto(String tipo, String descripcion,
			dao.entities.Empresa empresa) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
}
