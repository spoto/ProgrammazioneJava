package it.univr.date;

public class Date {
	private final int day;
	private final int month;
	private final int year;
	private int country;
	private static final int IT_COUNTRY = 0;
	private static final int UK_COUNTRY = 1;

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;

		checkValidity();
	}

	public Date(int g, int m) {
		this(g, m, 2008);
	}

	public Date(int g) {
		this(g, 1);
	}

	public Date() {
		this(13, 1, 1973);
	}

	private void checkValidity() {
		// controllo che this sia una data valida
		if (year < 1900 || month < 1 || month > 12
				|| day < 1 || day > daysInMonth(month, year))
			System.out.println("data invalida");
	}

	private int daysInMonth(int month, int year) {
		switch (month) {
		case 2:
			return isLeapYear(year) ? 29 : 28;
		case 4: case 6: case 9: case 11:
			return 30;
		default:
			return 31;
		}
	}

	private boolean isLeapYear(int year) {
		return year % 4 == 0 &&
			(year % 100 != 0 || year % 400 == 0);
	}

	public String toString() {
		if (country == 0)
			return toStringIT();
		else
			return toStringUK();
	}
	
	private String toStringUK() {
		switch (month) {
		case 1:
			return "January " + day + ", " + year;
		case 2:
			return "February " + day + ", " + year;
		case 3:
			return "March " + day + ", " + year;
		case 4:
			return "April " + day + ", " + year;
		case 5:
			return "May " + day + ", " + year;
		case 6:
			return "June " + day + ", " + year;
		case 7:
			return "July " + day + ", " + year;
		case 8:
			return "August " + day + ", " + year;
		case 9:
			return "September " + day + ", " + year;
		case 10:
			return "October " + day + ", " + year;
		case 11:
			return "November " + day + ", " + year;
		default:
			return "December " + day + ", " + year;
		}
	}

	private String toStringIT() {
		switch (month) {
		case 1:
			return day + " gennaio " + year;
		case 2:
			return day + " febbraio " + year;
		case 3:
			return day + " marzo " + year;
		case 4:
			return day + " aprile " + year;
		case 5:
			return day + " maggio " + year;
		case 6:
			return day + " giugno " + year;
		case 7:
			return day + " luglio " + year;
		case 8:
			return day + " agosto " + year;
		case 9:
			return day + " settembre " + year;
		case 10:
			return day + " ottobre " + year;
		case 11:
			return day + " novembre " + year;
		default:
			return day + " dicembre " + year;
		}
	}

	// determina se this viene prima di other
	public boolean precede(Date other) {
		if (this.year < other.year)
			return true;
		else if (this.year > other.year)
			return false;
		else if (this.month < other.month)
			return true;
		else if (this.month > other.month)
			return false;
		else if (this.day < other.day)
			return true;
		else
			return false;
	}

	// giorni passati tra 1/1/1900 e this
	public int passatiDallInizio() {
		int result = 0;
		for (int y = 1900; y < this.year; y++)
			if (isLeapYear(y))
				result += 366;
			else
				result += 365;

		result += passatiDallInizioDellAnno();

		return result;
	}
	
	public int passatiDallInizioDellAnno() {
		int result = 0;
		
		for (int m = 1; m < this.month; m++)
			result += daysInMonth(m, year);

		result += day;

		return result;
	}

	public void setUK() {
		this.country = UK_COUNTRY;
	}

	public void setIT() {
		this.country = IT_COUNTRY;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	





}
