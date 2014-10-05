package app;

import controller.Sistema;
import dao.DAOClienteEmpresa;
import dao.DAOsistema;
import clases.*;

public class Prueba {

	public static void main(String[] args) {

		AltaDatos();
		
		
		
		
	}

	private static void AltaDatos() {
		
		
		DAOsistema.getInstance().persistir(Sistema.getInstance());
		DAOClienteEmpresa.getInstance().persistir(new Empresa("Direccion1", "2059687", "Empresa1", "2059687", "Nuevo"));

		
	}

}
