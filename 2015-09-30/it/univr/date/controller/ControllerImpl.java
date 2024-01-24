package it.univr.date.controller;

import it.univr.date.model.Model;

import java.util.Calendar;

public class ControllerImpl implements Controller {

	private final Model model;

	public ControllerImpl(Model model) {
		this.model = model;
		// alla creazione del controller,
		// il modello viene settato al tempo corrente
		onResetTime();
	}

	@Override
	public void onIncreaseHours() {
		model.set((model.getHours() + 1) % 24, model.getMinutes(), model.getSeconds());
	}

	@Override
	public void onDecreaseHours() {
		model.set(model.getHours() == 0 ? 23 : (model.getHours() - 1), model.getMinutes(), model.getSeconds());
	}

	@Override
	public void onIncreaseMinutes() {
		model.set(model.getHours(), (model.getMinutes() + 1) % 60, model.getSeconds());
	}

	@Override
	public void onDecreaseMinutes() {
		model.set(model.getHours(), model.getMinutes() == 0 ? 59 : (model.getMinutes() - 1), model.getSeconds());
	}

	@Override
	public void onIncreaseSeconds() {
		model.set(model.getHours(), model.getMinutes(), (model.getSeconds() + 1) % 60);
	}

	@Override
	public void onDecreaseSeconds() {
		model.set(model.getHours(), model.getMinutes(), model.getSeconds() == 0 ? 59 : (model.getSeconds() - 1));
	}

	@Override
	public void onResetTime() {
		Calendar calendar = Calendar.getInstance();
		model.set(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
	}
}