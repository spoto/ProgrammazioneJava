package it.univr.tv;

public class Main {
	public static void main(String[] args) {
		Television tv = new Television();
		Controller ctrl = new Controller(tv);
		ctrl.pressKey(2);
		System.out.println(tv);
		ctrl.pressKey(3);
		System.out.println(tv);
		ctrl.pressKey(3);
		System.out.println(tv);
		ctrl.pressKey(7);
	}
}
