package ut04servicios;

/*
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.config.ConfigLoader;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
*/

public class Enviador {
	public static void main(String[] args) {
		// Most essentials together (but almost everything is optional):
		
		/* Código que envía
		Email email = EmailBuilder.startingBlank()
		          .to("Jorge", "jorge.duenas.lerin@gmail.com")
		          .to("Kayler", "kayler.borges@educa.madrid.org")
		          .from("Jorge", "jorge.duenas@educa.madrid.org")
		          .withReplyTo("Jorge", "jorge.duenas@educa.madrid.org")
		          .withSubject("Proyecto Spamtoso")
		          .withHTMLText("<h1>Hola!!</h1><p>¿Qué tal?</p>")
		          .withPlainText("Hola! ¿Qué tal?")
		          .buildEmail();

		Mailer mailer = MailerBuilder
		          .withSMTPServer("smtp.educa.madrid.org", 587, "alumno.falso", "SECRETO")
		          .withTransportStrategy(TransportStrategy.SMTP_TLS)
		          .clearEmailValidator() // turns off email validation
		          .buildMailer();

		mailer.sendMail(email);
		*/
	}
}