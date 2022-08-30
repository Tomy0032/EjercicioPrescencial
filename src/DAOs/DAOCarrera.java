package DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Clases.Carrera;
import DataBase.DatabaseManager;

public class DAOCarrera {
	
	private final static 
	String CONTAR_CARRERAS = "SELECT COUNT(*) CARRERAS FROM CARRERA";
	
	private final static
	String INSERT = "INSERT INTO CARRERA VALUES(SEQ_ID_CARRERA.NEXTVAL,?,?)";
	
	private final static
	String BUSCAR = "SELECT * FROM CARRERA WHERE NOMBRE=?";
	
	public static int cantidadCarreras() {
		
		int cantidad = 0;
		
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(CONTAR_CARRERAS);
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				cantidad = resultado.getInt("CARRERAS");
			}
			
			return cantidad;
			
		}catch(SQLException e){
			e.printStackTrace();
			return cantidad;
		}
		
	}
	
	public static boolean insertCarrera(Carrera c) {
		
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT);
		
			statement.setInt(1, DAOUniversidad.buscarNombre((c.getUniversidad().getNombre())).getIdUniversidad());		
			statement.setString(2, c.getNombre());
			
			int retorno = statement.executeUpdate();
			
			return retorno>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static Carrera buscarCarrera(String nombre) {
		
		Carrera c = null;
		
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR);
			
			statement.setString(1, nombre);
			
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				c = new Carrera(resultado.getString("NOMBRE"),DAOUniversidad.buscarId(resultado.getInt("ID_UNIVERSIDAD")));
				c.setIdCarrera(resultado.getInt("ID_CARRERA"));
			}
			
			return c;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

}
