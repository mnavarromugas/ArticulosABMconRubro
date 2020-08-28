package gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Articulo;

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

				Articulo a = new Articulo(id, descripcion, precio);
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
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Articulo VALUES (?,?)");
			pstmt.setString(1, nuevo.getDescripcion());
			pstmt.setFloat(2, nuevo.getPrecio());

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
			//modificarArticulo(a);
		}
	}
}
