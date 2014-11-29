package clases;

public class Combustibles implements PoliticasDeEnvio
{
	public Combustibles (){}

	@Override
	public String Evaluar(Pedido _pedido) 
	{
		if(_pedido.getManifiesto().contains("Combustible"))
			return "Combustible-No se puede transportar";
		return null;
	}
}
