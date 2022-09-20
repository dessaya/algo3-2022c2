
public class Circulo implements Figura {

	private int radio;

	public Circulo(int radio) {
		this.radio = radio;
	}

	@Override
	public double area() {
		return this.radio * this.radio * 3.14;
	}

}
