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
    // Devuelve los contratistas externos que cumplen con las condiciones
    // especiales del pedido.
    //------------------------------------------------------------------
	public List<EmpresaSubContratada> contratarTransporteExterno(Pedido pedido)
	{
		// TODO: Cargar BBDD de empresas de transporte.
		ArrayList<ConsideracionEspecial> listaConsideraciones = pedido.getConsideraciones();
		for(ConsideracionEspecial ce: listaConsideraciones )
		{
			if(ce.isRequiereAvioneta())
				return solicitarAvionetaExterna(ce);
			
			if(ce.isRequiereCamionExterno())// a granel
				return solicitarVehiculoExterno(ce);
			
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
	private List<EmpresaSubContratada> solicitarAvionetaExterna(ConsideracionEspecial ce)
	{
		List<EmpresaSubContratada> empAereas = new ArrayList<EmpresaSubContratada>();
		for(EmpresaSubContratada et: lEmpresasDeTransporte )
		{
			// TODO Añadir empresas
		}	
		return empAereas;
	}
	
	@SuppressWarnings("unused")
	private List<EmpresaSubContratada> solicitarCarrierExterno(ConsideracionEspecial ce)
	{
		List<EmpresaSubContratada> carriers = new ArrayList<EmpresaSubContratada>();
		for(EmpresaSubContratada et: lEmpresasDeTransporte )
		{
			// TODO Añadir empresas
		}	
		return carriers;
	}
	
	@SuppressWarnings("unused")
	private List<EmpresaSubContratada> solicitarVehiculoExterno(ConsideracionEspecial ce)
	{
		List<EmpresaSubContratada> vExternos = new ArrayList<EmpresaSubContratada>();
		for(EmpresaSubContratada et: lEmpresasDeTransporte )
		{
			// TODO Añadir empresas
		}	
		return vExternos;
	}
}
