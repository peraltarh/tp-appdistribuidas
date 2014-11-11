package dao.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	private ClientePersistencia cliente;
	private SucursalPersistencia sucursal;
	private List<MercaderiaPersistencia> mercaderias;
	private List<DestinatarioPersistencia> destinatarios;
	private List<ConsideracionEspecialPersistencia> consideraciones;

	public PedidoPersistencia(String manifiesto, String dirDestino, Date fechaEnregaMaxima,
			Date fechaEntregaEstimada, String condEspeciales,
			Date horarioDeEntregaDesde, Date horarioDeEntregahasta,
			String dirDeRetiroSoloEmpresa, int prioridad, SucursalPersistencia sucursal,ClientePersistencia cliente) 
	{
		this.manifiesto = manifiesto;
		this.dirDestino = dirDestino;
		this.fechaEnregaMaxima = fechaEnregaMaxima;
		this.fechaEntregaEstimada = fechaEntregaEstimada;
		this.condEspeciales = condEspeciales;
		this.horarioDeEntregaDesde = horarioDeEntregaDesde;
		this.horarioDeEntregahasta = horarioDeEntregahasta;
		this.dirDeRetiroSoloEmpresa = dirDeRetiroSoloEmpresa;
		this.prioridad = prioridad;
		this.mercaderias = new ArrayList<MercaderiaPersistencia>();
		this.cliente=cliente;
		this.destinatarios = new ArrayList<DestinatarioPersistencia>();
		this.consideraciones = new ArrayList<ConsideracionEspecialPersistencia>();
	}

	public PedidoPersistencia(){}
	
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

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idPedido")
	public List<MercaderiaPersistencia> getMercaderias() {
		return mercaderias;
	}

	public void setMercaderias(List<MercaderiaPersistencia> mercaderias) {
		this.mercaderias = mercaderias;
	}

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idPedido")
	public List<ConsideracionEspecialPersistencia> getConsideraciones() {
		return consideraciones;
	}
	public void setConsideraciones(
			List<ConsideracionEspecialPersistencia> consideraciones) {
		this.consideraciones = consideraciones;
	}

	

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idPedido")
	public List<DestinatarioPersistencia> getDestinatarios() {
		return destinatarios;
	}
	public void setDestinatarios(List<DestinatarioPersistencia> destinatarios) {
		this.destinatarios = destinatarios;
	}



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

	public void addMercaderia(MercaderiaPersistencia mercaderia) {
		this.mercaderias.add(mercaderia);
	}

	public void addDestinatario(DestinatarioPersistencia destinatario) {
		this.destinatarios.add(destinatario);
	}

	public void addConsideraciones(ConsideracionEspecialPersistencia consideracionEs) {
		this.consideraciones.add(consideracionEs);
	}


	@ManyToOne
	@JoinColumn(name="numeroSucursal")
	public SucursalPersistencia getSucursal() {
		return sucursal;
	}


	public void setSucursal(SucursalPersistencia sucursal) {
		this.sucursal = sucursal;
	}

	@OneToOne
	public ClientePersistencia getCliente() {
		return cliente;
	}


	public void setCliente(ClientePersistencia cliente) {
		this.cliente = cliente;
	}

	
}
