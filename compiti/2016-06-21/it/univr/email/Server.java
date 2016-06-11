package it.univr.email;

import java.util.HashSet;
import java.util.Set;

public class Server {
	private final Set<Email> emails = new HashSet<>();

	public void post(Email email) {
		this.emails.add(email);
	}

	public Set<Email> getEmailsTo(Mailbox recipient) {
		Set<Email> result = new HashSet<>();
		for (Email email: emails)
			if (email.getRecipients().contains(recipient))
				result.add(email);

		return result;
	}
}