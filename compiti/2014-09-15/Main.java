import it.univr.tokenizer.DoubleTokenization;
import it.univr.tokenizer.StringTokenization;
import it.univr.tokenizer.Tokenization;

public class Main {

	public static void main(String[] args) {
		Tokenization tok = new StringTokenization("Questa$e'&una&prova!", "$&");
		for (String s: tok)
			System.out.println(s);

		Tokenization tok2 = new DoubleTokenization(tok, "ou");
		for (String s: tok2)
			System.out.println(s);
	}
}
