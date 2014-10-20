package app;


import interfaz.InterfazEnvios;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import rmi.EnviosRMI;

//Con RMI no deberia ir
import dao.DAOCliente;
import dao.entities.*;


public class Prueba {
		
	//DAMIAN
	InterfazEnvios iE=null;
	
	public static void main(String[] args)
	{
		new Prueba();
	}
	
    public boolean getStub() {
    	
    	try {
			iE = (InterfazEnvios)Naming.lookup ("//localhost/Envios");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
    }
    
    public Prueba(){
    	if(getStub()) 
    	{
    		try {
    			iE.altaParticular("salta 1234", "543523", "Pepe", "Garcia", "32243243");
    			
    		} catch (RemoteException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	} 
    }
	
	
	
	private static void AltaDatos()
	{
		try {
			InterfazEnvios iE=null;
			
			iE.altaParticular("salta 1234", "543523", "Pepe", "Garcia", "32243243");
//			EnviosRMI envios=new EnviosRMI();
//			envios.altaParticular("salta 1234", "543523", "Pepe", "Garcia", "32243243");
//			envios.altaEmpresa("DirEmpresa","3432423","Empresa1","111111","Regular");
//			envios.altaEmpresa("DirEmpresa2","999999","Empresa2","222222","Regular");
//			envios.agregarDireccionValida("DireccionValida","111111");
//			
			//iE.altaCliente("direccion1", "5464523423");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//RODRIGO

//	private static void AltaDatos() {
//		
//		
//		dao.entities.Empresa emp = new dao.entities.Empresa("Dir", "232323", "Empresa1", "200202020", "Regular");
//		emp.addDireccioneValida(new EmpresaDirValidas ("DirValida1", emp));
//		emp.addDireccioneValida(new EmpresaDirValidas ("DirValida2", emp));
//		
//		emp.addProductoValido(new Producto("Caja", "Bombones", emp));
//		emp.addProductoValido(new Producto("Caja", "Sandwiches", emp));
//		
//		CuentaCorriente cuenta= new CuentaCorriente(12345,100, 50, true,emp);
//		cuenta.addMovimiento(new MovimientoCuenta(null, 10,cuenta));
//		
//		emp.addCuentaCorriente(cuenta);
//
//
//		DAOCliente.getInstance().persistir(new dao.entities.Particular("Dir", "202020", "Pepe", "Lopez", 33333));
//		DAOCliente.getInstance().persistir(new dao.entities.Particular("Di2r", "202020", "Luis", "Lopez", 33334));
//		DAOCliente.getInstance().persistir(emp);
//		
//
//	}





}
