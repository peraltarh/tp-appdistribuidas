package clases;


public class EmpresaDirValidas {
	
	private String direccion;
	private String tel;
	
	public EmpresaDirValidas( String direccion, String tel) {
		this.direccion = direccion;
		this.tel=tel;
	}

	public EmpresaDirValidas() {
		// TODO Auto-generated constructor stub
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	
}
