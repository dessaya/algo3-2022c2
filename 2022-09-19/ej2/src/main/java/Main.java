
public class Main {

	public static void main(String[] args) {
		var lista = new ListaDuplicante<Integer>();
		
		lista.add(3);
		lista.add(8);
		lista.remove(0);
		System.out.println(lista); // [3, 3, 8, 8]

		var lista2 = new ListaDuplicante2<Integer>();
		
		lista2.add(3);
		lista2.add(8);
		lista2.remove(0);
		System.out.println(lista2); // [3, 3, 8, 8]
	}
}
