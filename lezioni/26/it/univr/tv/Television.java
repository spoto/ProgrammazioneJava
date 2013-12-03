package it.univr.tv;

public class Television {
	private int channel;
	
	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getChannel() {
		return channel;
	}

	public String toString() {
		switch (channel) {
		case 1: return "rave uno";
		case 2: return "rave due";
		case 3: return "rave tre";
		case 4: return "tele squatto";
		case 5: return "tele cinto";
		default: return "canale sconosciuto";
		}
	}
}
