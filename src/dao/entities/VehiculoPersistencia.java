package dao.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import clases.PlanDeMantenimiento;
import xml.MensajeDeControl;


@Entity
@Table(name="Vehiculo")

public class VehiculoPersistencia extends Observable {

	private float pesoMax;
	private float volumenMax;
	private String condEspeciales;
	private float tara;
	private String patente;
	private int nroChasis;
	private String tipo;
	private float kilometrakeActual;
	private float kilometrajemaximo;
	private Date modelo;
	private String coordenadaActual;
	private String estado;
	private long numeroPolizaSeguro;
	private Date expiracionGarantia;
	private SucursalPersistencia sucursal;
	private List<PlanDeMantenimientoPersistencia> mantenimientosPlaneados;
	private List<MantenimientoRealizadoPersistencia> mantenimientosRealizados;
	private List<RemitoPersistencia> remitos;

	public VehiculoPersistencia(float pesoMax, float volumenMax, String condEspeciales,	float tara, String patente, int nroChasis, String tipo,	float kilometrakeActual, float kilometrajemaximo, Date modelo,
			String coordenadaActual, String estado, long numeroPolizaSeguro,
			Date expiracionGarantia, SucursalPersistencia sucursal) {
		super();
		this.pesoMax = pesoMax;
		this.volumenMax = volumenMax;
		this.condEspeciales = condEspeciales;
		this.tara = tara;
		this.patente = patente;
		this.nroChasis = nroChasis;
		this.tipo = tipo;
		this.kilometrakeActual = kilometrakeActual;
		this.kilometrajemaximo = kilometrajemaximo;
		this.modelo = modelo;
		this.coordenadaActual = coordenadaActual;
		this.estado = estado;
		this.numeroPolizaSeguro = numeroPolizaSeguro;
		this.expiracionGarantia = expiracionGarantia;
		this.mantenimientosPlaneados= new ArrayList<PlanDeMantenimientoPersistencia>();
		this.mantenimientosRealizados = new ArrayList<MantenimientoRealizadoPersistencia>();
		this.remitos = new ArrayList<RemitoPersistencia>();
	}

	
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}

	public float getPesoMax() {
		return pesoMax;
	}

	public float getVolumenMax() {
		return volumenMax;
	}

	public String getCondEspeciales() {
		return condEspeciales;
	}

	public float getTara() {
		return tara;
	}

@Id
	public int getNroChasis() {
		return nroChasis;
	}

	public String getTipo() {
		return tipo;
	}

	public float getKilometrakeActual() {
		return kilometrakeActual;
	}

	
	public float getKilometrajemaximo() {
		return kilometrajemaximo;
	}

	public Date getModelo() {
		return modelo;
	}

	public String getCoordenadaActual() {
		return coordenadaActual;
	}

	public String getEstado() {
		return estado;
	}

	public long getNumeroPolizaSeguro() {
		return numeroPolizaSeguro;
	}

	public Date getExpiracionGarantia() {
		return expiracionGarantia;
	}



	public void setPesoMax(float pesoMax) {
		this.pesoMax = pesoMax;
	}

	public void setVolumenMax(float volumenMax) {
		this.volumenMax = volumenMax;
	}

	public void setCondEspeciales(String condEspeciales) {
		this.condEspeciales = condEspeciales;
	}

	public void setTara(float tara) {
		this.tara = tara;
	}

	public void setNroChasis(int nroChasis) {
		this.nroChasis = nroChasis;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setKilometrakeActual(float kilometrakeActual) {
		this.kilometrakeActual = kilometrakeActual;
	}

	public void setKilometrajemaximo(float kilometrajemaximo) {
		this.kilometrajemaximo = kilometrajemaximo;
	}

	public void setModelo(Date modelo) {
		this.modelo = modelo;
	}

	public void setCoordenadaActual(String coordenadaActual) {
		this.coordenadaActual = coordenadaActual;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setNumeroPolizaSeguro(long numeroPolizaSeguro) {
		this.numeroPolizaSeguro = numeroPolizaSeguro;
	}

	public void setExpiracionGarantia(Date expiracionGarantia) {
		this.expiracionGarantia = expiracionGarantia;
	}

	@ManyToOne
	@JoinColumn(name="numeroSucursal")
	public SucursalPersistencia getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalPersistencia sucursal) {
		this.sucursal = sucursal;
	}

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="nroChasis")
	public List<PlanDeMantenimientoPersistencia> getMantenimientosPlaneados() {
		return mantenimientosPlaneados;
	}

	public void setMantenimientosPlaneados(
			List<PlanDeMantenimientoPersistencia> mantenimientosPlaneados) {
		this.mantenimientosPlaneados = mantenimientosPlaneados;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="patente")
	public List<MantenimientoRealizadoPersistencia> getMantenimientosRealizados() {
		return mantenimientosRealizados;
	}
	
	public void setMantenimientosPlaneados(ArrayList<PlanDeMantenimientoPersistencia> mantenimientosPlaneados) {
		this.mantenimientosPlaneados = mantenimientosPlaneados;
	}
	
	
	

	public void setMantenimientosRealizados(
			List<MantenimientoRealizadoPersistencia> mantenimientosRealizados) {
		this.mantenimientosRealizados = mantenimientosRealizados;
	}
@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="nroChasis")
	public List<RemitoPersistencia> getRemitos() {
		return remitos;
	}
	public void setRemitos(List<RemitoPersistencia> remitos) {
		this.remitos = remitos;
	}

	
	public void addMantenimientoPlaneado(PlanDeMantenimientoPersistencia mantenimientoPlaneado) 
	{
		this.mantenimientosPlaneados.add(mantenimientoPlaneado);
	}

	public void addMantenimientoRealizado(MantenimientoRealizadoPersistencia mantenimientoRealizado) {
		this.mantenimientosRealizados.add(mantenimientoRealizado);
	}

	
	public void addRemito(RemitoPersistencia remito) {
		this.remitos.add(remito);
	}

	public void EmitirMensajeDeControl()
	{
		setChanged();
//		Pasa como parametro un objeto de tipo Document (documento XML)
//		notifyObservers(MensajeDeControl.getInstance().GenerarMensajeDeControl(this));
	}

//	public float getVolumenDisponible() 
//	{
//		float volumenOcupado = 0;
//		for(RemitoPersistencia remito: remitos)
//		{
//			for(MercaderiaPersistencia mercaderia: remito.getMercaderias())
//			{
//				volumenOcupado += ((MercaderiaPorVolumenPersistencia)mercaderia).getVolumen();
//			}
//		}
//		return volumenMax-volumenOcupado;
//	}
	
	

}
