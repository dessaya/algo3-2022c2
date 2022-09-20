import java.util.ArrayList;

public class ListaDuplicante<T> extends ArrayList<T> {

	private static final long serialVersionUID = 124312321L; // eliminar advertencia
	
	@Override
	public boolean add(T elemento) {
		super.add(elemento);
		super.add(elemento);
		return true;
	}
}
