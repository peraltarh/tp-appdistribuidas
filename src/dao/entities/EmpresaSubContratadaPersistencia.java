package dao.entities;

import java.util.ArrayList;

public class EmpresaSubContratadaPersistencia {
	
	private String razonSocial;
	private ArrayList<VehiculoExternoPersistencia> vehiculosEsternos;
	private ArrayList<CarrierPersistencia> carriers;

	public EmpresaSubContratadaPersistencia(String razonSocial) {
		super();
		this.razonSocial = razonSocial;
		this.vehiculosEsternos = new ArrayList<VehiculoExternoPersistencia>();
		this.carriers = new ArrayList<CarrierPersistencia>();
		
	}

	public EmpresaSubContratadaPersistencia(){}
	
	public String getRazonSocial() {
		return razonSocial;
	}

	public ArrayList<VehiculoExternoPersistencia> getVehiculosEsternos() {
		return vehiculosEsternos;
	}

	public ArrayList<CarrierPersistencia> getCarriers() {
		return carriers;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public void addVehiculoEsterno(VehiculoExternoPersistencia vehiculosEsterno) {
		this.vehiculosEsternos.add(vehiculosEsterno);
	}

	public void addCarrier(CarrierPersistencia carrier) {
		this.carriers.add(carrier);
	}
	
	
	

}
