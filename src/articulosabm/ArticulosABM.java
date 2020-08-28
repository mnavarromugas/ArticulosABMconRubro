package articulosabm;

import ventanas.VentanaTodosLosArticulos;

public class ArticulosABM {

	public static void main(String[] args) {
		// Borrar
		/*
		GestorDB g = new GestorDB();

		g.agregarArticulo(new Articulo("pastilla de freno", 300));

		
		ArrayList<Articulo> lista = g.obtenerTodosLosArticulos();
		for (Articulo articulo : lista) {
			System.out.println(articulo);
		}
*/
		VentanaTodosLosArticulos v = new VentanaTodosLosArticulos();
		v.setVisible(true);
	}
	
}
