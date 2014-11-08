package dao.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ConsideracionEspecial")
public class ConsideracionEspecialPersistencia {
	
	private int idConsideracionEspecial;
	private boolean entregaInmediata;
	private boolean requiereAvioneta;
	private boolean autorizacionAvioneta;
	private boolean requiereCamionExterno;
	private float costoExtra;
	private List<CarrierPersistencia> carriers;
	private List<VehiculoExternoPersistencia> vExternos;
	private PedidoPersistencia pedido;
	
	public ConsideracionEspecialPersistencia(boolean entregaInmediata,
			boolean requiereAvioneta, boolean autorizacionAvioneta,
			boolean requiereCamionExterno, float costoExtra, PedidoPersistencia pedido) {
		super();
		this.entregaInmediata = entregaInmediata;
		this.requiereAvioneta = requiereAvioneta;
		this.autorizacionAvioneta = autorizacionAvioneta;
		this.requiereCamionExterno = requiereCamionExterno;
		this.costoExtra = costoExtra;
		this.carriers = new ArrayList<CarrierPersistencia>();
		this.vExternos = new ArrayList<VehiculoExternoPersistencia>();
		this.pedido=pedido;
	}


	
	@Id
	@GeneratedValue
	public int getIdConsideracionEspecial() {
		return idConsideracionEspecial;
	}




	public void setIdConsideracionEspecial(int idConsideracionEspecial) {
		this.idConsideracionEspecial = idConsideracionEspecial;
	}



	
@ManyToOne
@JoinColumn(name="idPedido")
	public PedidoPersistencia getPedido() {
		return pedido;
	}




	public void setPedido(PedidoPersistencia pedido) {
		this.pedido = pedido;
	}




	public boolean isEntregaInmediata() {
		return entregaInmediata;
	}


	public boolean isRequiereAvioneta() {
		return requiereAvioneta;
	}


	public boolean isAutorizacionAvioneta() {
		return autorizacionAvioneta;
	}


	public boolean isRequiereCamionExterno() {
		return requiereCamionExterno;
	}


	public float getCostoExtra() {
		return costoExtra;
	}

@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="idConsderacionEspecial")
	public List<CarrierPersistencia> getCarriers() {
		return carriers;
	}


	public void setCarriers(List<CarrierPersistencia> carriers) {
		this.carriers = carriers;
	}



	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idConsderacionEspecial")
	public List<VehiculoExternoPersistencia> getvExternos() {
		return vExternos;
	}


	public void setvExternos(List<VehiculoExternoPersistencia> vExternos) {
		this.vExternos = vExternos;
	}
	public void setEntregaInmediata(boolean entregaInmediata) {
		this.entregaInmediata = entregaInmediata;
	}


	public void setRequiereAvioneta(boolean requiereAvioneta) {
		this.requiereAvioneta = requiereAvioneta;
	}


	public void setAutorizacionAvioneta(boolean autorizacionAvioneta) {
		this.autorizacionAvioneta = autorizacionAvioneta;
	}


	public void setRequiereCamionExterno(boolean requiereCamionExterno) {
		this.requiereCamionExterno = requiereCamionExterno;
	}


	public void setCostoExtra(float costoExtra) {
		this.costoExtra = costoExtra;
	}


	public void addCarrier(CarrierPersistencia carrier) {
		this.carriers.add(carrier);
	}


	public void addvExterno(VehiculoExternoPersistencia vehiculo) {
		this.vExternos.add(vehiculo);
	}
	
	
	

}
