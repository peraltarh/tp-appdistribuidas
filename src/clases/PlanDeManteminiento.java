package clases;

public class PlanDeManteminiento {
	
	private float cantKilometros;
	private String tipo;
	private String controlEspecial;
	public PlanDeManteminiento(float cantKilometros, String tipo,
			String controlEspecial) {
		super();
		this.cantKilometros = cantKilometros;
		this.tipo = tipo;
		this.controlEspecial = controlEspecial;
	}
	public float getCantKilometros() {
		return cantKilometros;
	}
	public String getTipo() {
		return tipo;
	}
	public String getControlEspecial() {
		return controlEspecial;
	}
	public void setCantKilometros(float cantKilometros) {
		this.cantKilometros = cantKilometros;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setControlEspecial(String controlEspecial) {
		this.controlEspecial = controlEspecial;
	}
	
	

}
