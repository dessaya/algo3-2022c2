package ej1;

public class Carrera {
	private final Materia[] materiasObligatorias;
	private final Materia[] materiasOptativas;
	private final String codigo;
	private final int creditosNecesarios;

	public Carrera(String codigo, Materia[] materiasObligatorias, Materia[] materiasOptativas, int creditosNecesarios) {
		this.materiasObligatorias = materiasObligatorias;
		this.materiasOptativas = materiasOptativas;
		this.codigo = codigo;
		this.creditosNecesarios = creditosNecesarios;
	}
}
