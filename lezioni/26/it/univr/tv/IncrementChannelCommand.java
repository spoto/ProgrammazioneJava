package it.univr.tv;

public class IncrementChannelCommand extends Command {

	private final Television tv;

	public IncrementChannelCommand(Television tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		tv.setChannel(tv.getChannel() + 1);
	}

}
