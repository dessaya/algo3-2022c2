package invitaciones;

public class Invitaciones {
	public void enviar(MailServer s, String emailInvitado, String nombreInvitado) {
		if (!s.ping()) {
			throw new RuntimeException("el server está caido");
		}
		var mensaje = nombreInvitado + ", te invito a mi fiesta!";
		s.enviarMail("invitaciones@example.com", emailInvitado, mensaje);
	}
}
