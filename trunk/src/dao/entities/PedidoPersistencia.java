package dao.entities;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Pedido")

public class PedidoPersistencia {
	private int idPedido;
	private String manifiesto;
	private String dirDestino;
	private Date fechaEnregaMaxima;
	private Date fechaEntregaEstimada;
	private String condEspeciales;
	private Date horarioDeEntregaDesde;
	private Date horarioDeEntregahasta;
	private String dirDeRetiroSoloEmpresa;
	private int prioridad;
	private SucursalPersistencia sucursal;
//	private ArrayList<MercaderiaPersistencia> mercaderias;
//	private ArrayList<DestinatarioPersistencia> destinatarios;
//	private ArrayList<ConsideracionEspecialPersistencia> consideraciones;
	
	public PedidoPersistencia(String manifiesto, String dirDestino, Date fechaEnregaMaxima,
			Date fechaEntregaEstimada, String condEspeciales,
			Date horarioDeEntregaDesde, Date horarioDeEntregahasta,
			String dirDeRetiroSoloEmpresa, int prioridad, SucursalPersistencia sucursal) {
		super();
		this.manifiesto = manifiesto;
		this.dirDestino = dirDestino;
		this.fechaEnregaMaxima = fechaEnregaMaxima;
		this.fechaEntregaEstimada = fechaEntregaEstimada;
		this.condEspeciales = condEspeciales;
		this.horarioDeEntregaDesde = horarioDeEntregaDesde;
		this.horarioDeEntregahasta = horarioDeEntregahasta;
		this.dirDeRetiroSoloEmpresa = dirDeRetiroSoloEmpresa;
		this.prioridad = prioridad;
//		this.mercaderias = new ArrayList<MercaderiaPersistencia>();
//		this.destinatarios = new ArrayList<DestinatarioPersistencia>();
//		this.consideraciones = new ArrayList<ConsideracionEspecialPersistencia>();
		
	}
	

@Id
@GeneratedValue
	public int getIdPedido() {
		return idPedido;
	}



	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}



	public String getManifiesto() {
		return manifiesto;
	}

	public String getDirDestino() {
		return dirDestino;
	}

	public Date getFechaEnregaMaxima() {
		return fechaEnregaMaxima;
	}

	public Date getFechaEntregaEstimada() {
		return fechaEntregaEstimada;
	}

	public String getCondEspeciales() {
		return condEspeciales;
	}

	public Date getHorarioDeEntregaDesde() {
		return horarioDeEntregaDesde;
	}

	public Date getHorarioDeEntregahasta() {
		return horarioDeEntregahasta;
	}

	public String getDirDeRetiroSoloEmpresa() {
		return dirDeRetiroSoloEmpresa;
	}

	public int getPrioridad() {
		return prioridad;
	}

//	public ArrayList<MercaderiaPersistencia> getMercaderias() {
//		return mercaderias;
//	}
//
//	public ArrayList<DestinatarioPersistencia> getDestinatarios() {
//		return destinatarios;
//	}
//
//	public ArrayList<ConsideracionEspecialPersistencia> getConsideraciones() {
//		return consideraciones;
//	}

	public void setManifiesto(String manifiesto) {
		this.manifiesto = manifiesto;
	}

	public void setDirDestino(String dirDestino) {
		this.dirDestino = dirDestino;
	}

	public void setFechaEnregaMaxima(Date fechaEnregaMaxima) {
		this.fechaEnregaMaxima = fechaEnregaMaxima;
	}

	public void setFechaEntregaEstimada(Date fechaEntregaEstimada) {
		this.fechaEntregaEstimada = fechaEntregaEstimada;
	}

	public void setCondEspeciales(String condEspeciales) {
		this.condEspeciales = condEspeciales;
	}

	public void setHorarioDeEntregaDesde(Date horarioDeEntregaDesde) {
		this.horarioDeEntregaDesde = horarioDeEntregaDesde;
	}

	public void setHorarioDeEntregahasta(Date horarioDeEntregahasta) {
		this.horarioDeEntregahasta = horarioDeEntregahasta;
	}

	public void setDirDeRetiroSoloEmpresa(String dirDeRetiroSoloEmpresa) {
		this.dirDeRetiroSoloEmpresa = dirDeRetiroSoloEmpresa;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

//	public void addMercaderia(MercaderiaPersistencia mercaderia) {
//		this.mercaderias.add(mercaderia);
//	}
//
//	public void addDestinatario(DestinatarioPersistencia destinatario) {
//		this.destinatarios.add(destinatario);
//	}
//
//	public void addConsideraciones(ConsideracionEspecialPersistencia consideracionEs) {
//		this.consideraciones.add(consideracionEs);
//	}

	
	@ManyToOne
	@JoinColumn(name="numeroSucursal")
	public SucursalPersistencia getSucursal() {
		return sucursal;
	}


	public void setSucursal(SucursalPersistencia sucursal) {
		this.sucursal = sucursal;
	}


//	public void setMercaderias(ArrayList<MercaderiaPersistencia> mercaderias) {
//		this.mercaderias = mercaderias;
//	}
//
//
//	public void setDestinatarios(ArrayList<DestinatarioPersistencia> destinatarios) {
//		this.destinatarios = destinatarios;
//	}
//
//
//	public void setConsideraciones(
//			ArrayList<ConsideracionEspecialPersistencia> consideraciones) {
//		this.consideraciones = consideraciones;
//	}
//
//
//	// 
//	public float getPesoTotal() 
//	{
//		float pesoTotal=0;
//		for(MercaderiaPersistencia mercaderia : mercaderias)
//		{
//			pesoTotal += ((MercaderiaPorPesoPersistencia)mercaderia).getPeso();
//		}
//		return pesoTotal;
//	}
//
//	public float getVolumenTotal() 
//	{
//		float volumenTotal=0;
//		for(MercaderiaPersistencia mercaderia : mercaderias)
//		{
//			volumenTotal += ((MercaderiaPorVolumenPersistencia)mercaderia).getVolumen();
//		}
//		return volumenTotal;
//	}
//	
//	
	
}
