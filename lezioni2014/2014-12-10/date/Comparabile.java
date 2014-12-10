package date;

public interface Comparabile {

	/**
	 * 
	 * @param altro
	 * @return < 0 se viene prima this
	 *         > 0 se viene prima altro
	 *         == 0 se this è uguale ad altro
	 */
	public int confrontaCon(Comparabile altro);
}
