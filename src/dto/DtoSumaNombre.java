package dto;

public class DtoSumaNombre {
	public float suma;
	public String nombre;

	public DtoSumaNombre(float suma, String nombre) {
		this.suma = suma;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "suma=" + suma + ", nombre=" + nombre + '}';
	}
}
