package rmi;

import interfaz.InterfazEnvios;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;

import clases.controller.Sistema;


public class EnviosRMI extends UnicastRemoteObject implements InterfazEnvios
{
	Sistema sistema = new Sistema();
	public EnviosRMI() throws RemoteException {
//		super();
	}

	private static final long serialVersionUID = 1L;
	


	@Override
	public void altaEmpresa(String direccion, String telefono, String razonSoial, String cuit, String regularidad) throws RemoteException {
		
		sistema.altaEmpresa(direccion, telefono, telefono, telefono, telefono);
	}

	@Override
	public void altaEmpresaDirValidas(String direccion, dao.entities.EmpresaPersistencia empresa) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void altaCuentaCorriente(int cbu, float saldoActual,	float minimoPermitidoSinAuth, String cuit)	throws RemoteException {
		sistema.altaCuentaCorriente(cbu,saldoActual,minimoPermitidoSinAuth, cuit);
		
	}
	
	

	@Override
	public void altaMovimientoCuenta(Date fecha, float monto, int cbu) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void altaProducto(String tipo, String descripcion, String cuit) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void altaParticular(String direccion, String telefono, String nombre, String apellido, String dni) throws RemoteException {
//		Sistema sistema=new Sistema();
		sistema.altaParticular(direccion,telefono,nombre,apellido,dni);
		
	}

	public void agregarDireccionValida(String direccion, String cuit) {
//		Sistema sistema=new Sistema();
		sistema.agregarDireccionValida(direccion,cuit);
	}

	@Override
	public void buscarClienteParticular(String dni) {
//		Sistema sistema=new Sistema();
		sistema.buscarClienteParticular(dni);
	}

	@Override
	public void buscarClienteEmpresa(String cuit){
		sistema.buscarClienteEmpresa(cuit);
	}

	
	
}
