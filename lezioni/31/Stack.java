/**
 * Uno stack di date
 */

public interface Stack {
	public void push(Data data);
	public Data pop() throws EmptyStackException;
	public boolean isEmpty();
}
