package dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ProductosValidos")
public class Producto {
	
	private int idProd;
	private String tipo;
	private String descripcion;
	private Empresa empresa;
	
	
	public Producto(String tipo, String descripcion,Empresa empresa) {
		super();
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.empresa = empresa;
	}

	@Id
	@GeneratedValue
	public int getIdProd(){
		return idProd;
	}

	
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}
	
	@ManyToOne
	@JoinColumn(name="empresa")
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public String getTipo() {
		return tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
