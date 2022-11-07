package invitaciones;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;

public class TestInvitaciones {
	@Test
	public void testEnviarDaErrorSiElServerEstaCaido() {
		// arrange
		var i = new Invitaciones();
		var s = new MailServer() {
			@Override
			public boolean ping() {
				return false;
			}
			
			@Override
			public void enviarMail(String de, String a, String mensaje) {
				fail("no debería ser llamado");
			}
		};
		
		// act
		var r = new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				i.enviar(s, "pepe@gmail.com", "Pepe");
			}
		};
		
		// assert
		assertThrows(RuntimeException.class, r);
	}

	@Test
	public void testSiPingDaTrueSeInvocaAEnviarMail() {
		// arrange
		var i = new Invitaciones();
				
		var s = new MailServer() {
			boolean mailEnviado = false;
			String mensaje;
			String remitente;
			String destinatario;

			@Override
			public boolean ping() {
				return true;
			}
			
			@Override
			public void enviarMail(String de, String a, String mensaje) {
				mailEnviado = true;
				this.mensaje = mensaje;
				remitente = de;
				destinatario = a;
			}
		};
		
		// act
		i.enviar(s, "pepe@gmail.com", "Pepe");
		
		// assert
		assertTrue(s.mailEnviado);
		assertEquals("Pepe, te invito a mi fiesta!", s.mensaje);
		assertEquals("invitaciones@example.com", s.remitente);
		assertEquals("pepe@gmail.com", s.destinatario);
	}
}
