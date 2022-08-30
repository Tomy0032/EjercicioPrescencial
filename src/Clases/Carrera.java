package Clases;

public class Carrera {
	
	private int idCarrera;
	private String nombre;
	private Universidad universidad;
	
	public Carrera(int idCarrera, String nombre, Universidad universidad) {
		this.idCarrera = idCarrera;
		this.nombre = nombre;
		this.universidad = universidad;
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Universidad getUniversidad() {
		return universidad;
	}

	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}

	@Override
	public String toString() {
		return "Carrera [idCarrera=" + idCarrera + ", nombre=" + nombre + ", universidad=" + universidad + "]";
	}
	
}
