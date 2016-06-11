package it.univr.email;

public class Main {

	public static void main(String[] args) throws UnknownEmailException {
		Server gmail = new Server();
		Mailbox fausto = new Mailbox(gmail, "fausto.spoto@gmail.com");
		Mailbox scarlett = new Mailbox(gmail, "scarlett.johansson@gmail.com");
		Mailbox jennifer = new Mailbox(gmail, "jennifer.lawrence@gmail.com");
		Mailbox tim = new Mailbox(gmail, "tim.cook@gmail.com");

		// fausto -> { scarlett, jennifer }
		Email e1 = fausto.post("new programming language", "I will soon move to Ruby!", scarlett, jennifer);

		// scarlett -> { fausto, jennifer }
		Email e2 = scarlett.replyToAll(e1, "I think Python is much better!");

		// jennifer -> tim
		Email e3 = jennifer.forward(e2, "Hey Tim, look what these people are saying!", tim);

		// tim -> jennifer
		tim.replyToAll(e3, "Thank you Jennifer!\nI will investigate this issue better");

		System.out.println(jennifer);
	}
}