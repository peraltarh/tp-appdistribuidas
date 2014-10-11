package main;

import interfaz.InterfazEnvios;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import rmi.EnviosRMI;

public class Servidor extends Thread{
	
	private InterfazEnvios objetoRemoto;
	private Socket s;
	
	public static void main(String[] args) 
	{
		new Servidor();
		System.out.println("Arranco Server Restaurante");
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

