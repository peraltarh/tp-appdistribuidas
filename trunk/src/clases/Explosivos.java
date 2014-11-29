package clases;

public class Explosivos implements PoliticasDeEnvio
{
	public Explosivos (){}

	@Override
	public String Evaluar(Pedido _pedido) 
	{
		if(_pedido.getManifiesto().contains("Explosivo"))
			return "Explosivo-No se puede transportar";
		return null;
	}	
}
