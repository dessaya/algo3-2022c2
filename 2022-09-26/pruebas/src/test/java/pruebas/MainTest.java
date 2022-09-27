package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;

public class MainTest {

	@Test
	public void test11EsPrimo() {
		// 1. ~setup~ (no hace falta en este caso)
		// 2. ejercitar
		boolean p = Main.esPrimo(11);
		// 3. verificar
		assertTrue(p);
	}

	@Test
	public void test20NoEsPrimo() {
		boolean p = Main.esPrimo(20);
		assertFalse(p);
	}

	@Test
	public void testUnoNoEsPrimo() {
		boolean p = Main.esPrimo(1);
		assertFalse(p);		
	}

	@Test
	public void testDosEsPrimo() {
		boolean p = Main.esPrimo(2);
		assertTrue(p);		
	}

	@Test
	public void testCeroNoEsPrimo() {
		boolean p = Main.esPrimo(0);
		assertFalse(p);		
	}

	@Test
	public void testNegativoDaError() {
		var runnable = new ThrowingRunnable() {
			public void run() throws Throwable {
				Main.esPrimo(-1);
			}
		};
		assertThrows(RuntimeException.class, runnable);
	}
}
