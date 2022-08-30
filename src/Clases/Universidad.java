package Clases;

public class Universidad {
	
	private int idUniversidad;
	private String nombre;
	private String ubicacion;
	public int prueba;
	
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

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		return "Universidad [idUniversidad=" + idUniversidad + ", nombre=" + nombre + ", ubicacion=" + ubicacion + "]";
	}


}
