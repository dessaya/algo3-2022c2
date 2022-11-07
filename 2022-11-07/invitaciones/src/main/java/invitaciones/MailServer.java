package invitaciones;

public interface MailServer {
	boolean ping();
	void enviarMail(String de, String a, String mensaje);
}
