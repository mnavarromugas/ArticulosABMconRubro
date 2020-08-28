package model;

public class Rubro {
	private int id;
	private String nombre;

	public Rubro(String nombre) {
		this.nombre = nombre;
		this.id = -1;
	}

	public Rubro(int id, String nombre) {
		this.nombre = nombre;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}
}
