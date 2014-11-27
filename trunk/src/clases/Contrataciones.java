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
    	
    	EmpresaSubContratada emp1 = new EmpresaSubContratada("TranportesPepe");
    	emp1.addVehiculoEsterno(new VehiculoExterno("Camioneta", "ASD 123", 20000));
    	emp1.addVehiculoEsterno(new VehiculoExterno("Avioneta", "ASR 123", 20000));
    	emp1.addCarrier(new Carrier("Lanus", "Mendoza", 2000));
    	lEmpresasDeTransporte.add(emp1);
    	
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
		
		if(pedido.getConsideraciones()!=null){
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
				return solicitarVehiculoExterno(ce);
			}
		}
		return solicitarVehiculoExterno(null);
		
	}
	// Para estas tres, despues de obtener la lista de empresas que cumplen
	// con los requisitos se muestran al usuario para que realice la reserva
	// y complete los datos del vehiculo, etc.
	private List<EmpresaSubContratada> solicitarAvionetaExterna(ConsideracionEspecial ce)
	{
		List<EmpresaSubContratada> empAereas = new ArrayList<EmpresaSubContratada>();
		for(EmpresaSubContratada et: lEmpresasDeTransporte )
		{
			
			for (VehiculoExterno vehiculoE : et.getVehiculosEsternos()) {
				if(vehiculoE.getTipo().equals("Avioneta")){
					empAereas.add(et);
				}
			}
		}	
		return empAereas;
	}
	
	@SuppressWarnings("unused")
	private List<EmpresaSubContratada> solicitarCarrierExterno(ConsideracionEspecial ce)
	{
		List<EmpresaSubContratada> carriers = new ArrayList<EmpresaSubContratada>();
		for(EmpresaSubContratada et: lEmpresasDeTransporte )
		{
			if(et.getCarriers().size()!=0) {
				carriers.add(et);
			}
		}	
		return carriers;
	}
	
	private List<EmpresaSubContratada> solicitarVehiculoExterno(ConsideracionEspecial ce)
	{
		
		if(ce==null) return lEmpresasDeTransporte;
		List<EmpresaSubContratada> vExternos = new ArrayList<EmpresaSubContratada>();
		for(EmpresaSubContratada et: lEmpresasDeTransporte )
		{
			if (et.getVehiculosEsternos().size()!=0) {
				vExternos.add(et);
			}
		}	
		return vExternos;
	}
}
