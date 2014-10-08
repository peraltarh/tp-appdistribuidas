package dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DireccionesEmpresa")
public class EmpresaDirValidas {
	
	private int idDir;
	private String direccion;
	private Empresa empresa;
	
	
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
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public EmpresaDirValidas( String direccion, Empresa empresa) {
		super();
		this.direccion = direccion;
		this.empresa = empresa;
	}
	

	
	
	

}
