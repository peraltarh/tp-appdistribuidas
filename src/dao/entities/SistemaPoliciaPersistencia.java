package dao.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

public class SistemaPoliciaPersistencia implements Observer
{
	// Eager, inicializaci�n temprana.
    private static volatile SistemaPoliciaPersistencia instance = new SistemaPoliciaPersistencia();
    // El primer valor es el nro de chapa del vehiculo desviado, el segundo
    // indica la cantidad de mensajes de desvio continuo
    private Map<String, Integer> vehiculosDesviados = new HashMap<String,Integer>(); 
    
    // Singleton
    private SistemaPoliciaPersistencia() {}
 
    public static SistemaPoliciaPersistencia getInstance() 
    {
        return instance;
    }
    

	public void update(Observable o, Object arg) 
	{
		// Buscar si estaba fuera de ruta.
		for(Entry<String, Integer> vehiculo : vehiculosDesviados.entrySet())
		{
//			if(vehiculo.getKey() == ((VehiculoPersistencia)o).getNroChasis())
			{
				// Sigue fuera de ruta?
				if(((VehiculoPersistencia)o).getEstado().contentEquals("Desviado"))
				{
					// Es el segundo mensaje consecutivo, por lo que son al menos
					// 10 min fuera de ruta
					// TODO : Avisar a la Policia (seria algún tipo de popup en la app web)
					return;
				}else{
					// Sacarlo de la lista de vehiculos fuera de ruta.
					vehiculosDesviados.remove(((VehiculoPersistencia)o).getNroChasis());
					return;
				}
			}
		}
		// Esta ahora fuera de ruta?
		if(((VehiculoPersistencia)o).getEstado().contentEquals("Desviado"))
		{
			// Ponerlo en la lista de los vehiculos fuera de ruta.
//			vehiculosDesviados.put(((VehiculoPersistencia)o).getNroChasis(), 1);
		}
		
	}

}
