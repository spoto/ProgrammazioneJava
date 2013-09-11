package it.univr.television;

public class Test {

	public static void main(String[] args) {
		final Television television = new Television();
		System.out.println(television);
		television.setChannel(4);
		System.out.println(television);

		Controller controller = new Controller(television);

		System.out.println("premo il tasto 3");
		controller.pressKey(3);
		System.out.println(television);

		System.out.println("premo il tasto 6");
		controller.pressKey(6);
		System.out.println(television);

		System.out.println("premo il tasto 0");
		controller.pressKey(0);
		System.out.println(television);

		System.out.println("riprogrammo il tasto 6");
		controller.programKey(6, new Command() {

			@Override
			public void execute() {
				television.setChannel(television.getChannel() - 1);
			}
		});

		// premiamolo!
		System.out.println("premo il tasto 6");
		controller.pressKey(6);
		System.out.println(television);

		while (controller.undo()) {
			System.out.println("undo");
			System.out.println(television);
		}
	}
}