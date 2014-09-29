package it.univr.date;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DatePicker extends JPanel {

	private final Picker day;
	private final Picker month;
	private final Picker year;

	public DatePicker(String title) {
		setLayout(new GridLayout(4, 1));

		add(new JLabel(title));

		add(day = new Picker("day", 1, 2) {

			@Override
			protected void onUpClicked() {
				Date current = getDate();
				current.increaseDay();
				setDate(current);
			}

			@Override
			protected void onDownClicked() {
				Date current = getDate();
				current.decreaseDay();
				setDate(current);
			}
		});

		add(month = new Picker("month", 1, 2) {

			@Override
			protected void onUpClicked() {
				Date current = getDate();
				current.increaseMonth();
				setDate(current);
			}

			@Override
			protected void onDownClicked() {
				Date current = getDate();
				current.decreaseMonth();
				setDate(current);
			}
		});

		add(year = new Picker("year", 2014, 4) {

			@Override
			protected void onUpClicked() {
				Date current = getDate();
				current.increaseYear();
				setDate(current);
			}

			@Override
			protected void onDownClicked() {
				Date current = getDate();
				current.decreaseYear();
				setDate(current);
			}
		});
	}

	public void setDate(Date date) {
		day.setValue(date.getDay());
		month.setValue(date.getMonth());
		year.setValue(date.getYear());
	}

	public Date getDate() {
		try {
			return new Date(day.getValue(), month.getValue(), year.getValue());
		}
		catch (IllegalDateException e1) {
			try {
				return new Date(1, 1, 2014);
			} catch (IllegalDateException e2) {
				return null; // impossibile
			}
		}
	}
}