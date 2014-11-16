package rmi;


import interfaz.InterfazEnvios;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import beans.PedidoBean;
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
		sistema.altaEmpresa(direccion, telefono, razonSoial, cuit, regularidad);
	}

	@Override
	public void agregarEmpresaDireccionValida(String direccion, String tel,String cuit) throws RemoteException {
		sistema.agregarEmpresaDireccionValida(direccion, tel,cuit);	
	}

	@Override
	public void altaCuentaCorriente(int cbu, float saldoActual,	float minimoPermitidoSinAuth, String cuit)	throws RemoteException {
		sistema.altaCuentaCorriente(cbu,saldoActual,minimoPermitidoSinAuth, cuit);
		
	}
	
	

	@Override
	public void altaMovimientoCuenta(Date fecha, float monto, int cbu) throws RemoteException {
		sistema.altaMovimientoCuenta(fecha,monto,cbu);
	}


	public void altaProducto(String tipo, String descripcion, String cuit) throws RemoteException {
		sistema.altaProducto(tipo,descripcion,cuit);
		
	}

	@Override
	public void altaParticular(String direccion, String telefono, String nombre, String apellido, String dni) throws RemoteException {
		sistema.altaParticular(direccion,telefono,nombre,apellido,dni);
		
	}


	@Override
	public void buscarClienteParticular(String dni) {
		sistema.buscarClienteParticular(dni);
	}

	@Override
	public void buscarClienteEmpresa(String cuit) {
		sistema.buscarClienteEmpresa(cuit);
	}

	@Override
	public void altaSucursal(String nombre, String dir, String gerente,
			String encDespacho, String encRecepcion) {
		sistema.altaSucursal(nombre,dir,gerente,encDespacho,encRecepcion);
	}

	public void altaDeposito(float cantidadMax, String encargado, String sucursal)
	{
		sistema.altaDeposito(cantidadMax, encargado, sucursal);
	}

	@Override
	public void altaPedido(String manifiesto, String dirDestino,Date fechaEnregaMaxima, Date fechaEntregaEstimada,String condEspeciales, Date horarioDeEntregaDesde,Date horarioDeEntregahasta, String dirDeRetiroSoloEmpresa,int prioridad, String estado, String sucursal, String cliente, String tipoC)
	{
		sistema.altaPedido( manifiesto,  dirDestino, fechaEnregaMaxima,  fechaEntregaEstimada, condEspeciales,  horarioDeEntregaDesde, horarioDeEntregahasta,  dirDeRetiroSoloEmpresa, prioridad,estado,  sucursal,  cliente, tipoC);
		
	}

	@Override
	public List<PedidoBean> getMesasPorEstado(String estado) throws RemoteException {
		List<PedidoBean> pedidos=new ArrayList<PedidoBean>();
		pedidos= sistema.getPedidosPorEstado(estado);
		return pedidos;
	}
	
	
}