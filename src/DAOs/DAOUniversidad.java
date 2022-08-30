package DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Clases.Universidad;
import DataBase.DatabaseManager;

public class DAOUniversidad {
	
	private final static
	String INSERT = "INSERT INTO UNIVERSIDAD VALUES(SEQ_ID_UNIVERSIDAD.NEXTVAL,?,?)";
	
	private final static
	String BUSCAR_NOMBRE_UBICACION = "SELECT * FROM UNIVERSIDAD WHERE NOMBRE=? AND UBICACION=?";
	
	private final static
	String BUSCAR_ID = "SELECT * FROM UNIVERSIDAD WHERE ID_UNIVERSIDAD=?";
	
	public static boolean insertUniversidad(Universidad u) {
		
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT);
		
			statement.setString(1, u.getNombre());
			statement.setString(2, u.getUbicacion());		
			
			int retorno = statement.executeUpdate();
			
			return retorno>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static Universidad buscarNombreUbicacion(String nombre, String ubicacion) {
		
		Universidad u = null;
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_NOMBRE_UBICACION);
			
			statement.setString(1, nombre);
			statement.setString(2, ubicacion);
			
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				u = new Universidad(nombre,resultado.getString("UBICACION"));
				u.setIdUniversidad(resultado.getInt("ID_UNIVERSIDAD"));
			}
			
			return u;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
public static Universidad buscarId(int id) {
		
		Universidad u = null;
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_ID);
			
			statement.setInt(1, id);
			
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				u = new Universidad(resultado.getString("NOMBRE"),resultado.getString("UBICACION"));
				u.setIdUniversidad(resultado.getInt("ID_UNIVERSIDAD"));
			}
			
			return u;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
