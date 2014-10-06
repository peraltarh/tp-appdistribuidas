package xml;

import java.util.Date;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import clases.Vehiculo;


public class MensajeDeControl 
{
	// Eager, inicialización temprana.
    private static volatile MensajeDeControl instance = new MensajeDeControl();
    
    // Singleton
    private MensajeDeControl() {}
 
    public static MensajeDeControl getInstance() 
    {
        return instance;
    }
	
    public Document GenerarMensajeDeControl(Vehiculo vehiculo)
    {
    	Document doc = null;
	//	String ARCHIVO = "cotizacion.xml";
	    try{
	        //Crea instancia de DocumentBuilderFactory
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        //obtiene objeto DocumentBuilder
	        DocumentBuilder docBuilder = factory.newDocumentBuilder();
	        //Crea documento DOM en blanco
	        doc = docBuilder.newDocument();
	        //crea el elemento raíz y lo agrega al documento
            Element root = doc.createElement("MensajeDeControl");
            doc.appendChild(root);
	   //     root.setAttribute("numero", numero);
	     
	        //crea elementos hijo
	        Element hijo = doc.createElement("Fecha");
	        hijo.setTextContent((new Date()).toString());// fecha y hora actual
	        root.appendChild(hijo);
	            
            hijo = doc.createElement("Número de Remito");
            hijo.setTextContent(vehiculo.getNroChasis());
            root.appendChild(hijo);
	            
	        hijo = doc.createElement("Coordenadas");
	        hijo.setTextContent(vehiculo.getCoordenadaActual());
            root.appendChild(hijo);
 
	    }catch(Exception e){
	    	System.out.println(e.getMessage());
	    }
	    return doc;
	}
    
    
}
