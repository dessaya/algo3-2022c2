
public class Rectangulo implements Figura {

	private int a;
	private int b;

	public Rectangulo(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public double area() {
		return a * b;
	}

}
