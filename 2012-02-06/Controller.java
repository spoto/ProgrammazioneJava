package it.univr.television;

import java.util.Stack;

public class Controller {
	private final Television television;
	private final Command[] commands = new Command[7];
	private final Stack<Command> undos = new Stack<Command>();

	public Controller(Television television) {
		this.television = television;

		// inizializziamo i tasti con dei comandi:
		commands[0] = new SetChannelCommand(1);
		commands[1] = new SetChannelCommand(2);
		commands[2] = new SetChannelCommand(5);
		commands[3] = new Command() {

			@Override
			public void execute() {
				Controller.this.television.setChannel(Controller.this.television.getChannel() + 1);
			}
		};

		commands[4] = new EmptyCommand();
		commands[5] = new EmptyCommand();
		commands[6] = new EmptyCommand();
	}

	public void pressKey(int number) {
		undos.push(new SetChannelCommand(television.getChannel()));
		commands[number].execute();
	}

	public void programKey(int number, Command command) {
		commands[number] = command;
	}

	public boolean undo() {
		if (!undos.isEmpty()) {
			Command last = undos.pop();
			last.execute();
			return true;
		}
		else
			return false;
	}

	// va bene anche mettere queste classi come esterne, ma
	// facendole interne si semplifica molto il lavoro
	private class SetChannelCommand implements Command {

		private final int channel;

		private SetChannelCommand(int channel) {
			this.channel = channel;
		}

		@Override
		public void execute() {
			television.setChannel(channel);			
		}
	}

	// va bene anche mettere queste classi come esterne, ma
	// facendole interne si semplifica molto il lavoro
	private class EmptyCommand implements Command {

		@Override
		public void execute() {}
	}
}