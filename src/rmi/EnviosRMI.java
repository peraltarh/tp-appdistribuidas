package rmi;

import interfaz.InterfazEnvios;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;

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
	public void altaEmpresa(String direccion, String telefono, String razonSoial, String cuit, String regularidad) throws RemoteException {
		Sistema sistema = new Sistema();
		sistema.altaEmpresa(direccion, telefono, telefono, telefono, telefono);
	}

	@Override
	public void EmpresaDirValidas(String direccion, dao.entities.Empresa empresa) throws RemoteException {
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
	public void Producto(String tipo, String descripcion,
			dao.entities.Empresa empresa) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void altaParticular(String direccion, String telefono, String nombre, String apellido, String dni) throws RemoteException {
		Sistema sistema=new Sistema();
		sistema.altaParticular(direccion,telefono,nombre,apellido,dni);
		
	}

	public void agregarDireccionValida(String direccion, String cuit) {
		Sistema sistema=new Sistema();
		sistema.agregarDireccionValida(direccion,cuit);
	}

	
	
}
