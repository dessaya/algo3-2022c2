package invitaciones;

public class MailServerQueMandaMails implements MailServer {

	@Override
	public boolean ping() {
		// ....
		return false;
	}

	@Override
	public void enviarMail(String de, String a, String mensaje) {
		// ....
	}

}
