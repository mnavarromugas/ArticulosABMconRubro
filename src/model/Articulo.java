package model;

public class Articulo {
	private int id;
	private String descripcion;
	private float precio;

	public Articulo(int id, String descripcion, float precio) {
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Articulo(String descripcion, float precio) {
		this.descripcion = descripcion;
		this.precio = precio;
		this.id = -1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Articulo{" + "id=" + id + ", descripcion=" + descripcion + ", precio=" + precio + '}';
	}
}
