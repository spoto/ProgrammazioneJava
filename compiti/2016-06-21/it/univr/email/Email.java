package it.univr.email;

import java.util.Set;

public interface Email {
	Mailbox getSender();
	Set<Mailbox> getRecipients();
	String getSubject();
	String getBody();
	String toString();
}