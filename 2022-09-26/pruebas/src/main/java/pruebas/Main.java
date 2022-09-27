package pruebas;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean esPrimo(int n) {
		if (n < 0) {
			throw new RuntimeException();
		}
		if (n == 1 || n == 0) {
			return false;
		}
		for (int i = 2; i < n / Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
	
}
