package it.univr.date.view;

public class TextDateView implements View {

	@Override
	public void onTimeChanged(int hours, int minutes, int seconds) {
		System.out.printf("%d:%02d:%02d\n", hours, minutes, seconds);
	}
}