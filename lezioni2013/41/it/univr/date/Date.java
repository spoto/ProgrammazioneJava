package it.univr.date;

public class Date {

	private int day;
	private int month;
	private int year;
			
	private static int[] numberOfDays = {
		31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
	};

	public Date(int day, int month, int year) throws IllegalDateException {
		this.day = day;
		this.month = month;
		this.year = year;

		checkDate();
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return day + "/" + month + "/" + year;                        
	}

	public void increaseYear() {
		year++;
	}

	public void decreaseYear() {
		year--;
	}

	public void increaseMonth() {
		month++;
		if (month == 13)
			month = 1;

		findLatestValidDay();
	}

	public void decreaseMonth() {
		month--;
		if (month == 0)
			month = 12;

		findLatestValidDay();
	}

	public void increaseDay() {
		day++;
		if (!isValid())
			day = 1;
	}

	public void decreaseDay() {
		day--;
		if (day == 0) {
			day = 31;
			findLatestValidDay();
		}
	}

	private void findLatestValidDay() {
		while (!isValid())
			day--;
	}

	private void checkDate() throws IllegalDateException {
		if (!isValid())
			throw new IllegalDateException();
	}

	private boolean isValid() {
		int daysInMonth;

		if (isLeapYear() && month == 2)
			daysInMonth = 29;
		else
			daysInMonth = numberOfDays[month - 1];

		return !(year < 1900 || month < 1 || month > 12 || day < 1 || day > daysInMonth);
	}

	/**
	 * Determina se l'anno indicato è bisestile.
	 */

	private boolean isLeapYear() {
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	}
}