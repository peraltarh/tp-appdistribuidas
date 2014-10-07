package app;


import java.sql.Date;
import java.util.GregorianCalendar;

import entities.*;
import dao.DAOCliente;


public class Prueba {

	public static void main(String[] args) {

		AltaDatos();
		
		
		
		
	}

	private static void AltaDatos() {
		
		
		entities.Empresa emp = new entities.Empresa("Dir", "232323", "Empresa1", "200202020", "Regular");
		emp.addDireccioneValida(new EmpresaDirValidas ("DirValida1", emp));
		emp.addDireccioneValida(new EmpresaDirValidas ("DirValida2", emp));
		
		emp.addProductoValido(new Producto("Caja", "Bombones", emp));
		emp.addProductoValido(new Producto("Caja", "Sandwiches", emp));
		
		CuentaCorriente cuenta= new CuentaCorriente(12345,100, 50, true,emp);
		cuenta.addMovimiento(new MovimientoCuenta(null, 10,cuenta));
		
		emp.addCuentaCorriente(cuenta);


		DAOCliente.getInstance().persistir(new entities.Particular("Dir", "202020", "Pepe", "Lopez", 33333));
		DAOCliente.getInstance().persistir(new entities.Particular("Di2r", "202020", "Luis", "Lopez", 33334));
		DAOCliente.getInstance().persistir(emp);
		

	}

}
