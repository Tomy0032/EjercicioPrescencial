package Clases;

public class Universidad {
	
	private int idUniversidad;
	private String nombre;
	
	public Universidad(int idUniversidad, String nombre) {
		this.idUniversidad = idUniversidad;
		this.nombre = nombre;
	}

	public int getIdUniversidad() {
		return idUniversidad;
	}

	public void setIdUniversidad(int idUniversidad) {
		this.idUniversidad = idUniversidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Universidad [idUniversidad=" + idUniversidad + ", nombre=" + nombre + "]";
	}
	
}
