package servidor_RMI;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import ejemplo_1.rmi.GestionAlumnos;
import repositorio_RMI.TDAManejoDatos;

public class Servidor extends Thread{
	
	private TDAManejoDatos objetoRemoto;
	private Socket s;
	
	public static void main(String[] args) 
	{
		new Servidor();
	}
	
	
	public Servidor()
	{
		run();
	}

	public Servidor(Socket s1) {
		this.s=s1;
	}
	
	public void run()
	{
		try {
    		LocateRegistry.createRegistry(1099);	
            TDAManejoDatos gestionAlumnos = new GestionAlumnos();
            Naming.rebind ("//localhost/GestionAlumnos", gestionAlumnos);
            System.out.println("Fijado en //localhost/GestionAlumnos");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		try
//		{
//			
//			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
//			ois.close();
//			s.close();
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
	}
	
	
	

}

