package it.univr.email;

import java.util.HashSet;
import java.util.Set;

public class Mailbox {
	private final String user;
	private final Server server;

	public Mailbox(Server server, String user) {
		this.server = server;
		this.user = user;
	}

	public Set<Email> getEmails() {
		return server.getEmailsTo(this);
	}

	private class SimpleEmail implements Email {
		private final Mailbox sender;
		private final Set<Mailbox> recipients = new HashSet<>();
		private final String subject;
		private final String body;
		
		private SimpleEmail(String subject, String body, Mailbox sender, Mailbox... recipients) {
			this.sender = sender;
			this.subject = subject;
			this.body = body;
			
			for (Mailbox recipient: recipients)
				this.recipients.add(recipient);
		}

		public Mailbox getSender() {
			return sender;
		}

		public final Set<Mailbox> getRecipients() {
			return recipients;
		}

		public final String getSubject() {
			return subject;
		}

		public final String getBody() {
			return body;
		}

		@Override
		public String toString() {
			String result = "   From: " + sender.user;

			result += "\n     To: ";
			boolean first = true;
			for (Mailbox recipient: recipients) {
				if (first)
					first = false;
				else
					result += ", ";

				result += recipient.user;
			}

			result += "\nSubject: " + getSubject() + "\n\n";
			
			for (String row: body.split("\n"))
				result += row + "\n";

			return result;
		}
	}

	public Email post(String subject, String body, Mailbox... recipients) {
		Email email = new SimpleEmail(subject, body, this, recipients);
		server.post(email);

		return email;
	}
		
	private class Reply extends SimpleEmail {
		private final Email replied;
		
		private Reply(Email replied, String body) {
			super("RE: " + replied.getSubject(), body, Mailbox.this, recipients(replied));

			this.replied = replied;
		}

		@Override
		public String toString() {
			String result = super.toString() + "\n";
			
			for (String row: replied.toString().split("\n"))
				result += "> " + row + "\n";

			return result;
		}
	}
	
	private Mailbox[] recipients(Email replied) {
		Set<Mailbox> recipients = new HashSet<>(replied.getRecipients());
		recipients.remove(this);
		recipients.add(replied.getSender());
	
		return recipients.toArray(new Mailbox[recipients.size()]);
	}

	public Email replyToAll(Email email, String body) throws UnknownEmailException {
		if (email.getRecipients().contains(this)) {
			Email reply = new Reply(email, body);
			server.post(reply);
			
			return reply;
		}
		else
			throw new UnknownEmailException("Cannot reply to an email not inside the mailbox");
	}

	private class Forward extends SimpleEmail {
		private final Email forwarded;
		
		private Forward(Email forwarded, String body, Mailbox recipient) {
			super("FWD: " + forwarded.getSubject(), body, Mailbox.this, recipient);

			this.forwarded = forwarded;
		}

		@Override
		public String toString() {
			String result = super.toString() + "\n";
			
			for (String row: forwarded.toString().split("\n"))
				result += "> " + row + "\n";

			return result;
		}
	}

	public Email forward(Email email, String body, Mailbox recipient) throws UnknownEmailException {
		if (email.getRecipients().contains(this)) {
			Email forward = new Forward(email, body, recipient);
			server.post(forward);

			return forward;
		}
		else
			throw new UnknownEmailException("Cannot forward an email not inside the mailbox");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Mailbox of ").append(user).append(":\n");
		for (Email email: getEmails())
			sb.append("---------------------------------------\n").append(email.toString());

		return sb.toString();
	}
}