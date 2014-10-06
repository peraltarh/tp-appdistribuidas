package clases;

import java.util.ArrayList;
import java.util.List;
// TODO: seguimiento satelital, los seguros y el móvil de seguridad
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
    
	public void contratarTransporteExterno(Pedido pedido)
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
			
			// Envío internacional (carrier)
			
			
			
			// Si no es ninguna de las anteriores el problema es la
			// no disponibilidad de vehiculos propios. 
			// Por lo tanto cualquier empresa normal sirve.
			solicitarVehiculoExterno(ce);
		}
		
	}
	// Para estas tres, despues de obtener la lista de empresas que cumplen
	// con los requisitos se muestran al usuario para que realice la reserva
	// y complete los datos del vehiculo, etc.
	private void solicitarAvionetaExterna(ConsideracionEspecial ce)
	{
		List<EmpresaSubContratada> empAereas;
		for(EmpresaSubContratada et: lEmpresasDeTransporte )
		{
			
		}	
	}
	
	private void solicitarCarrierExterno(ConsideracionEspecial ce)
	{
		List<EmpresaSubContratada> carriers;
		for(EmpresaSubContratada et: lEmpresasDeTransporte )
		{
			
		}	
	}
	
	private void solicitarVehiculoExterno(ConsideracionEspecial ce)
	{
		for(EmpresaSubContratada et: lEmpresasDeTransporte )
		{
			
		}	
	}
}
