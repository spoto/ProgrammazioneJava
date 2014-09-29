package it.univr.tv;

public class Controller {
	private final Command[] keys = new Command[7];

	public Controller(Television tv) {
		keys[0] = new SetChannelCommand(tv, 1);
		keys[1] = new SetChannelCommand(tv, 2);
		keys[2] = new SetChannelCommand(tv, 3);
		keys[3] = new IncrementChannelCommand(tv);
		keys[4] = keys[5] = keys[6] = new EmptyCommand();
	}

	public void pressKey(int key) {
		if (key >= 0 && key <= 6)
			keys[key].execute();
		else
			throw new ArithmeticException("key deve essere fra 0 e 6");
	}

	public void programKey(int key, Command command) {
		if (key >= 0 && key <= 6)
			keys[key] = command;
		else
			throw new ArithmeticException("key deve essere fra 0 e 6");
	}
}
