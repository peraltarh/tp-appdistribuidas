package clases;

import java.util.ArrayList;

public class EmpresaSubContratada {
	
	private String razonSocial;
	private ArrayList<VehiculoExterno> vehiculosEsternos;
	private ArrayList<Carrier> carriers;

	public EmpresaSubContratada(String razonSocial) {
		super();
		this.razonSocial = razonSocial;
		this.vehiculosEsternos = new ArrayList<VehiculoExterno>();
		this.carriers = new ArrayList<Carrier>();
		
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public ArrayList<VehiculoExterno> getVehiculosEsternos() {
		return vehiculosEsternos;
	}

	public ArrayList<Carrier> getCarriers() {
		return carriers;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public void addVehiculoEsterno(VehiculoExterno vehiculosEsterno) {
		this.vehiculosEsternos.add(vehiculosEsterno);
	}

	public void addCarrier(Carrier carrier) {
		this.carriers.add(carrier);
	}
	
	
	

}
