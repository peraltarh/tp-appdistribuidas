package dao.entities;

import java.util.ArrayList;
import java.util.List;
// TODO: seguimiento satelital, los seguros y el m�vil de seguridad
public class ContratacionesPersistencia 
{
    private static volatile ContratacionesPersistencia instance = new ContratacionesPersistencia();    
    private List<EmpresaSubContratadaPersistencia> lEmpresasDeTransporte;
    // Singleton
    private ContratacionesPersistencia()
    {
    	lEmpresasDeTransporte = new ArrayList<EmpresaSubContratadaPersistencia>();
    }
 
    public static ContratacionesPersistencia getInstance() 
    {
        return instance;
    }
    
//	public String contratarTransporteExterno(PedidoPersistencia pedido)
//	{
//		// TODO: Cargar BBDD de empresas de transporte.
//		ArrayList<ConsideracionEspecialPersistencia> listaConsideraciones = pedido.getConsideraciones();
//		// Consideracion por mercaderia?
//		for(ConsideracionEspecialPersistencia ce: listaConsideraciones )
//		{
//			if(ce.isRequiereAvioneta())
//			{
//				solicitarAvionetaExterna(ce);
//				continue;
//			}
//			
//			if(ce.isRequiereCamionExterno())// a granel
//			{
//				solicitarVehiculoExterno(ce);
//				continue;
//			}
//			
//			// Env�o internacional (carrier)
//			
//			
//			
//			// Si no es ninguna de las anteriores el problema es la
//			// no disponibilidad de vehiculos propios. 
//			// Por lo tanto cualquier empresa normal sirve.
//			solicitarVehiculoExterno(ce);
//		}
//		return null;
//		
//	}
	// Para estas tres, despues de obtener la lista de empresas que cumplen
	// con los requisitos se muestran al usuario para que realice la reserva
	// y complete los datos del vehiculo, etc.
	@SuppressWarnings("unused")
	private void solicitarAvionetaExterna(ConsideracionEspecialPersistencia ce)
	{
		List<EmpresaSubContratadaPersistencia> empAereas;
		for(EmpresaSubContratadaPersistencia et: lEmpresasDeTransporte )
		{
			
		}	
	}
	
	@SuppressWarnings("unused")
	private void solicitarCarrierExterno(ConsideracionEspecialPersistencia ce)
	{
		List<EmpresaSubContratadaPersistencia> carriers;
		for(EmpresaSubContratadaPersistencia et: lEmpresasDeTransporte )
		{
			
		}	
	}
	
	@SuppressWarnings("unused")
	private void solicitarVehiculoExterno(ConsideracionEspecialPersistencia ce)
	{
		for(EmpresaSubContratadaPersistencia et: lEmpresasDeTransporte )
		{
			
		}	
	}
}
