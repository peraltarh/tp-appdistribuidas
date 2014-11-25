package clases;

import java.util.ArrayList;
import java.util.List;
// TODO: seguimiento satelital, los seguros y el m�vil de seguridad
public class Contrataciones 
{
    private static volatile Contrataciones instance = new Contrataciones();    
    private List<EmpresaSubContratada> lEmpresasDeTransporte;
    // Singleton
    private Contrataciones()
    {
    	lEmpresasDeTransporte = new ArrayList<EmpresaSubContratada>();
    }
 
    public static Contrataciones getInstance() 
    {
        return instance;
    }
    
    //------------------------------------------------------------------
    // Realiza los envios por medio de una compania externa.
    //------------------------------------------------------------------
	public String contratarTransporteExterno(Pedido pedido)
	{
		// TODO: Cargar BBDD de empresas de transporte.
		ArrayList<ConsideracionEspecial> listaConsideraciones = pedido.getConsideraciones();
		// Consideracion por mercaderia?
		for(ConsideracionEspecial ce: listaConsideraciones )
		{
			if(ce.isRequiereAvioneta())
			{
				solicitarAvionetaExterna(ce);
				continue;
			}
			
			if(ce.isRequiereCamionExterno())// a granel
			{
				solicitarVehiculoExterno(ce);
				continue;
			}
			
			// Env�o internacional (carrier)
			
			
			
			// Si no es ninguna de las anteriores el problema es la
			// no disponibilidad de vehiculos propios. 
			// Por lo tanto cualquier empresa normal sirve.
			solicitarVehiculoExterno(ce);
		}
		return null;
		
	}
	// Para estas tres, despues de obtener la lista de empresas que cumplen
	// con los requisitos se muestran al usuario para que realice la reserva
	// y complete los datos del vehiculo, etc.
	@SuppressWarnings("unused")
	private void solicitarAvionetaExterna(ConsideracionEspecial ce)
	{
		List<EmpresaSubContratada> empAereas;
		for(EmpresaSubContratada et: lEmpresasDeTransporte )
		{
			
		}	
	}
	
	@SuppressWarnings("unused")
	private void solicitarCarrierExterno(ConsideracionEspecial ce)
	{
		List<EmpresaSubContratada> carriers;
		for(EmpresaSubContratada et: lEmpresasDeTransporte )
		{
			
		}	
	}
	
	@SuppressWarnings("unused")
	private void solicitarVehiculoExterno(ConsideracionEspecial ce)
	{
		for(EmpresaSubContratada et: lEmpresasDeTransporte )
		{
			
		}	
	}
}
