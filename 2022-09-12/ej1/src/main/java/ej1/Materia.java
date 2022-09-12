package ej1;

public class Materia {
	private final String codigo;
	private final String nombre;
	private final int creditos;
	
	public Materia(String codigo, String nombre, int creditos) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.creditos = creditos;
	}

	public int getCreditos() {
		return creditos;
	}
}
