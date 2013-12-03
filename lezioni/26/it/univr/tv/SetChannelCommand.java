package it.univr.tv;

public class SetChannelCommand extends Command {

	private final Television tv;
	private final int channel;

	public SetChannelCommand(Television tv, int channel) {
		this.tv = tv;
		this.channel = channel;
	}

	@Override
	public void execute() {
		tv.setChannel(channel);
	}

}
