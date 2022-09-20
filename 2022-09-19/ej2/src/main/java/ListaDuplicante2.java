import java.util.ArrayList;

public class ListaDuplicante2<T> {
	private ArrayList<T> arrayList;
	
	public ListaDuplicante2() {
		arrayList = new ArrayList<>();
	}

	public void add(T elemento) {
		arrayList.add(elemento);
		arrayList.add(elemento);
	}
	
	@Override
	public String toString() {
		return arrayList.toString();
	}

	public void remove(int i) {
		arrayList.remove(i);
	}

}
