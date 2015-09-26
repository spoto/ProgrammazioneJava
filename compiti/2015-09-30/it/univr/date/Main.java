package it.univr.date;

import it.univr.date.controller.Controller;
import it.univr.date.controller.ControllerImpl;
import it.univr.date.model.Model;
import it.univr.date.model.Time;
import it.univr.date.view.Swing12DateView;
import it.univr.date.view.SwingDateView;
import it.univr.date.view.TextDateView;

public class Main {

	public static void main(String[] args) {
		Model model = new Time();
		Controller controller = new ControllerImpl(model);
		model.linkToView(new TextDateView());
		model.linkToView(new SwingDateView(controller));
		model.linkToView(new Swing12DateView(controller));
	}
}