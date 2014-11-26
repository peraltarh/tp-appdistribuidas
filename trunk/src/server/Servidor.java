package server;

import interfaz.InterfazEnvios;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.sql.Date;

import clases.controller.Sistema;
import dao.DAOSucursal;
import dao.DAOVehiculo;
import dao.entities.SucursalPersistencia;
import dao.entities.VehiculoPersistencia;
import rmi.EnviosRMI;

public class Servidor extends Thread{
	
	
	public static void main(String[] args) 
	{
		new Servidor();
		System.out.println("Arranco Server Envios");
	}
	
	
	public Servidor()
	{
		run();
	}
	
	public void run()
	{
		try {
    		LocateRegistry.createRegistry(1099);	
            InterfazEnvios objetoRemoto = new EnviosRMI();
            Naming.rebind ("//localhost/Envios", objetoRemoto);
            System.out.println("Fijado en //localhost/Envios");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}

