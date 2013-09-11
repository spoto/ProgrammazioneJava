package it.univr.television;

public class Television {

	private final static int WIDTH = 30;

	private int channel;
	
	public Television() {
		channel = 1;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getChannel() {
		return channel;
	}

	@Override
	public String toString() {
		String name = nameOfChannel();
		String result = "";

		for (int counter = 0; counter < WIDTH; counter++)
			result += "*";
		result += "\n";

		result += "* ";
		int spazi = (WIDTH - name.length() - 4) / 2;
		for (int counter = 0; counter < spazi; counter++)
			result += " ";
		result += name;
		for (int counter = 0; counter < spazi; counter++)
			result += " ";
		result += " *\n";

		for (int counter = 0; counter < WIDTH; counter++)
			result += "*";
		result += "\n";

		return result;
	}

	private String nameOfChannel() {
		switch (channel) {
		case 1: return "rave uno";
		case 2: return "rave due";
		case 3: return "rave tre";
		case 4: return "canale squatto";
		case 5: return "canale cinto";
		default: return "canale sconosciuto";
		}
	}
}