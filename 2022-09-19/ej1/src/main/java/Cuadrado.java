
public class Cuadrado implements Figura {
	private int lado;

	public Cuadrado(int lado) {
		this.lado = lado;
	}

	@Override
	public double area() {
		return lado * lado;
	}

}
