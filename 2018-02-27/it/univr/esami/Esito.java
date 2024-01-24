package it.univr.esami;

public enum Esito {
	RITIRATO("rit"), INSUFFICIENTE("ins"), DICIOTTO("18"), DICIANNOVE("19"),
	VENTI("20"), VENTUNO("21"), VENTIDUE("22"), VENTITRE("23"), VENTIQUATTRO("24"),
	VENTICINQUE("25"), VENTISEI("26"), VENTISETTE("27"), VENTOTTO("28"),
	VENTINOVE("29"), TRENTA("30"), TRENTAELODE("30L");

	private final String name;

	private Esito(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}