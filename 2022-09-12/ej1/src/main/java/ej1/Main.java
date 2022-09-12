package ej1;

public class Main {

	public static void main(String[] args) {
		Materia algo1 = new Materia("75.40", "Algoritmos I", 6);
		Materia fisica2 = new Materia("62.03", "Fisica II", 8);
		Materia quimica = new Materia("32.14", "Quimica", 6);
		
		Carrera info = new Carrera(
				"4",
				new Materia[] { algo1, fisica2 },
				new Materia[] { quimica },
				16
		);
		
		Alumno pepito = new Alumno(152387);
		
		boolean ok = pepito.inscribir(info);
		if (!ok) {
			System.out.println("No me puedo inscribir :(");
			return;
		}
		
		ok = pepito.aprobar(algo1);
		if (!ok) {
			System.out.println("Algo salió mal :(");
			return;
		}
		
		String estadoCarrera = pepito.getEstadoCarrera(info);
		System.out.println(estadoCarrera);
	}
}
