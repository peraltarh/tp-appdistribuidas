package servidor_RMI;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread{
	private Socket s;
	
	public Servidor()
	{
		int port=9999;
		
		try
		{
			ServerSocket ss=new ServerSocket(port);
			Socket s1;
			
			while(true)
			{
				s1= ss.accept();
				Servidor sNuevo= new Servidor(s1);
				System.out.print("test");
				sNuevo.start();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public Servidor(Socket s1) {
		this.s=s1;
	}
	
	public void run()
	{
		try
		{
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			ois.close();
			s.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		new Servidor();
	}
	
	

}

