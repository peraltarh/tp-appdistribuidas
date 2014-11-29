package clases;

import java.util.ArrayList;
import java.util.Arrays;

public class Armas implements PoliticasDeEnvio 
{
	static private ArrayList<String> armas= new ArrayList<String>(Arrays.asList("Escopeta", "Rifle", "Pistola", "Revolver", "Ametralladora"));  
	
	public Armas (){}

	@Override
	public String Evaluar(Pedido _pedido) 
	{
		for(String tipo_arma: armas)
		{
			if(_pedido.getManifiesto().contains(tipo_arma))
				return "Armas-No se puede transportar";
		}
			
		return null;
	}

}
