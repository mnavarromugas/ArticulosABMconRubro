package gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Articulo;
import model.Rubro;

public class GestorDB {
	private String CONN = "jdbc:sqlserver://LAPTOP-0CRE86U4\\SQLEXPRESS:1433;databaseName=ArticulosABM";
	private String USER = "sa";
	private String PASS = "123456";
	
	public ArrayList<Articulo> obtenerTodosLosArticulos() {
		ArrayList<Articulo> lista = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(CONN, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Articulo");

			while(rs.next()) {
				int id = rs.getInt(1);
				String descripcion = rs.getString(2);
				float precio = rs.getFloat(3);
				int idRubro = rs.getInt(4);

				Rubro rubro = obtenerRubroPorID(idRubro);

				Articulo a = new Articulo(id, descripcion, precio, rubro);
				lista.add(a);
			}

			stmt.close();
			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return lista;
	}	

	public void agregarArticulo(Articulo nuevo) {
		try {
			Connection conn = DriverManager.getConnection(CONN, USER, PASS);
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Articulo VALUES (?,?,?)");
			pstmt.setString(1, nuevo.getDescripcion());
			pstmt.setFloat(2, nuevo.getPrecio());
			pstmt.setInt(3, nuevo.getRubro().getId());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void modificarArticulo(Articulo articulo) {
		try {
			Connection conn = DriverManager.getConnection(CONN, USER, PASS);
			PreparedStatement pstmt = conn.prepareStatement("UPDATE Articulo SET descripcion=?, precio=?, idRubro=? WHERE id=?");
			pstmt.setString(1, articulo.getDescripcion());
			pstmt.setFloat(2, articulo.getPrecio());
			pstmt.setInt(3, articulo.getRubro().getId());
			pstmt.setInt(4, articulo.getId());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public void agregarOModificar(Articulo a) {
		if (a.getId() == -1) {
			agregarArticulo(a);
		} else {
			modificarArticulo(a);
		}
	}

	public void eliminarArticulo(int id) {
		try {
			Connection conn = DriverManager.getConnection(CONN, USER, PASS);
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Articulo WHERE id=?");
			pstmt.setInt(1, id);

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<Rubro> obtenerTodosLosRubros() {
		ArrayList<Rubro> lista = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(CONN, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Rubro");

			while(rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);

				Rubro r = new Rubro(id, nombre);
				lista.add(r);
			}

			stmt.close();
			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return lista;
	}	

	public Rubro obtenerRubroPorID(int id) {
		Rubro resultado = null;
		//buscar de la BD el rubro con ese id
		try {
			Connection conn = DriverManager.getConnection(CONN, USER, PASS);
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Rubro WHERE id=?");
			pstmt.setInt(1, id); 

			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				//int idR = rs.getInt(1);
				String nombre = rs.getString(2);
				resultado = new Rubro(id, nombre);
			}

			pstmt.close();
			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return resultado;
	}
}
