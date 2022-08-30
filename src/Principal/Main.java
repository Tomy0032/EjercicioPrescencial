package Principal;

import Clases.Carrera;
import Clases.Universidad;
import DAOs.DAOCarrera;
import DAOs.DAOUniversidad;

public class Main {

	public static void main(String[] args) {
		/*
		Universidad u = new Universidad("UTEC","Fray Bentos");
		Carrera c = new Carrera("LTI",u);
		
		if(DAOUniversidad.insertUniversidad(u)) {
			System.out.println("Se inserto una universidad");
		}else {
			System.out.println("No se inserto una universidad");
		}
		
		if(DAOCarrera.insertCarrera(c)) {
			System.out.println("Se inserto una carrera");
		}else {
			System.out.println("No se inserto una carrera");
		}
		*/
		System.out.println("Cantidad de carreras: " + DAOCarrera.cantidadCarreras());
		Carrera c2 = DAOCarrera.buscarCarrera("LTI");
		System.out.println(c2);
		System.out.println(c2.getUniversidad().toString());
		System.out.println("Prueba :)");
	}

}
