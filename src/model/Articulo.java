package model;

public class Articulo {

	private int id;
	private String descripcion;
	private float precio;
	private Rubro rubro;

	public Articulo(int id, String descripcion, float precio, Rubro rubro) {
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.rubro = rubro;
	}

	public Articulo(String descripcion, float precio, Rubro rubro) {
		this.descripcion = descripcion;
		this.precio = precio;
		this.rubro = rubro;
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

	public Rubro getRubro() {
		return rubro;
	}

	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}

	@Override
	public String toString() {
		return "Articulo{" + "id=" + id + ", descripcion=" + descripcion + ", precio=" + precio + '}';
	}
}
