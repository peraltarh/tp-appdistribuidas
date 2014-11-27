package clases;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Pedido {

	private String manifiesto;
	private String dirDestino;
	private Date fechaEnregaMaxima;
	private Date fechaEntregaEstimada;
	private String condEspeciales;
	private Time horarioDeEntregaDesde;
	private Time horarioDeEntregahasta;
	private String dirDeRetiroSoloEmpresa;
	private String estado;// procesar / despachado / pendiente.
	private int prioridad;
	private int idPedido;
	private Cliente clinete;
	private ArrayList<Mercaderia> mercaderias;
	private ArrayList<Destinatario> destinatarios;
	private ArrayList<ConsideracionEspecial> consideraciones;
	
	public enum ESTADO_DE_PEDIDO
	{
		PENDIENTE, DESPACHADO, SIN_PROCESAR, ENTREGADO
	}
	
	public Pedido(String manifiesto, String dirDestino, Date fechaEnregaMaxima,
			Date fechaEntregaEstimada, String condEspeciales,
			Time horarioDeEntregaDesde, Time horarioDeEntregahasta,
			String dirDeRetiroSoloEmpresa, int prioridad, Cliente cliente) {
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
		this.mercaderias = new ArrayList<Mercaderia>();
		this.destinatarios = new ArrayList<Destinatario>();
		this.consideraciones = new ArrayList<ConsideracionEspecial>();
		this.clinete = cliente;
		this.setEstado(ESTADO_DE_PEDIDO.SIN_PROCESAR);
		
	}
	

	public Cliente getClinete() {
		return clinete;
	}


	public void setClinete(Cliente clinete) {
		this.clinete = clinete;
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

	public Time getHorarioDeEntregaDesde() {
		return horarioDeEntregaDesde;
	}

	public Time getHorarioDeEntregahasta() {
		return horarioDeEntregahasta;
	}

	public String getDirDeRetiroSoloEmpresa() {
		return dirDeRetiroSoloEmpresa;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public ArrayList<Mercaderia> getMercaderias() {
		return mercaderias;
	}

	public ArrayList<Destinatario> getDestinatarios() {
		return destinatarios;
	}

	public ArrayList<ConsideracionEspecial> getConsideraciones() {
		return consideraciones;
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

	public void setHorarioDeEntregaDesde(Time horarioDeEntregaDesde) {
		this.horarioDeEntregaDesde = horarioDeEntregaDesde;
	}

	public void setHorarioDeEntregahasta(Time horarioDeEntregahasta) {
		this.horarioDeEntregahasta = horarioDeEntregahasta;
	}

	public void setDirDeRetiroSoloEmpresa(String dirDeRetiroSoloEmpresa) {
		this.dirDeRetiroSoloEmpresa = dirDeRetiroSoloEmpresa;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public void addMercaderia(Mercaderia mercaderia) {
		this.mercaderias.add(mercaderia);
	}

	public void addDestinatario(Destinatario destinatario) {
		this.destinatarios.add(destinatario);
	}

	public void addConsideraciones(ConsideracionEspecial consideracionEs) {
		this.consideraciones.add(consideracionEs);
	}

	// 
	public float getPesoTotal() 
	{
		float pesoTotal=0;
		for(Mercaderia mercaderia : mercaderias)
		{
			if(mercaderia.getClass() == MercaderiaPorPeso.class)
				pesoTotal += ((MercaderiaPorPeso)mercaderia).getPeso();
		}
		return pesoTotal;
	}

	public float getVolumenTotal() 
	{
		float volumenTotal=0;
		for(Mercaderia mercaderia : mercaderias)
		{
			if(mercaderia.getClass() == MercaderiaPorVolumen.class)
				volumenTotal += ((MercaderiaPorVolumen)mercaderia).getVolumen();
		}
		return volumenTotal;
	}

	
	public String getEstado() 
	{
	/*	if(estado.equals("pendiente"))
			return ESTADO_DEL_PEDIDO.PENDIENTE;
		if(estado.equals("despachado"))
			return ESTADO_DEL_PEDIDO.DESPACHADO;
		return ESTADO_DEL_PEDIDO.SIN_PROCESAR;*/
		return estado;
	}

	public void setEstado(ESTADO_DE_PEDIDO estado) 
	{
		switch(estado)
		{
		case PENDIENTE:
			this.estado = "PENDIENTE";
			break;
		case ENTREGADO:
			this.estado = "ENTREGADO";
			break;
		case DESPACHADO:
			this.estado = "DESPACHADO";
			break;
		default:
			this.estado = "SIN_PROCESAR";
		}
	}

	public void setMercaderias(ArrayList<Mercaderia> mercaderias) {
		this.mercaderias = mercaderias;
	}

	public void setDestinatarios(ArrayList<Destinatario> destinatarios) {
		this.destinatarios = destinatarios;
	}

	public void setConsideraciones(ArrayList<ConsideracionEspecial> consideraciones) {
		this.consideraciones = consideraciones;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	
	
	
}
