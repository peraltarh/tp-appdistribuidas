package clases;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

public class SistemaPolicia implements Observer
{
	// Eager, inicialización temprana.
    private static volatile SistemaPolicia instance = new SistemaPolicia();
    // El primer valor es el nro de chapa del vehiculo desviado, el segundo
    // indica la cantidad de mensajes de desvio continuo
    private Map<String, Integer> vehiculosDesviados = new HashMap<String,Integer>(); 
    
    // Singleton
    private SistemaPolicia() {}
 
    public static SistemaPolicia getInstance() 
    {
        return instance;
    }
    
	@Override
	public void update(Observable o, Object arg) 
	{
		// Buscar si estaba fuera de ruta.
		for(Entry<String, Integer> vehiculo : vehiculosDesviados.entrySet())
		{
			if(vehiculo.getKey() == ((Vehiculo)o).getNroChasis())
			{
				// Sigue fuera de ruta?
				if(((Vehiculo)o).getEstado().contentEquals("Desviado"))
				{
					// Es el segundo mensaje consecutivo, por lo que son al menos
					// 10 min fuera de ruta
					// TODO : Avisar a la Policia
					return;
				}else{
					// Sacarlo de la lista de vehiculos fuera de ruta.
					vehiculosDesviados.remove(((Vehiculo)o).getNroChasis());
					return;
				}
			}
		}
		// Esta ahora fuera de ruta?
		if(((Vehiculo)o).getEstado().contentEquals("Desviado"))
		{
			// Ponerlo en la lista de los vehiculos fuera de ruta.
			vehiculosDesviados.put(((Vehiculo)o).getNroChasis(), 1);
		}
		
	}

}
