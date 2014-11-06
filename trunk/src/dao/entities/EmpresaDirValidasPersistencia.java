package dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DireccionesEmpresa")
public class EmpresaDirValidasPersistencia {
	
	private int idDir;
	private String direccion;
	private EmpresaPersistencia empresa;
	
	
	@Id
	@GeneratedValue
	public int getIdDir() {
		return idDir;
	}
	
	public void setIdDir(int idDir) {
		this.idDir = idDir;
	}
	
	@ManyToOne
	@JoinColumn(name="empresa")
	public EmpresaPersistencia getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(EmpresaPersistencia empresa) {
		this.empresa = empresa;
	}
	
	
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public EmpresaDirValidasPersistencia( String direccion, EmpresaPersistencia empresa) {
		super();
		this.direccion = direccion;
		this.empresa = empresa;
	}
	

	
	
	

}
