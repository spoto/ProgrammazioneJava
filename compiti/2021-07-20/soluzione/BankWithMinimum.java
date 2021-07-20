package it.univr.bank;

public class BankWithMinimum extends SimpleBank {

	@Override
	public void deposit(String to, double amount) {
		if (to != null && !exists(to) && amount < 100.0)
			throw new IllegalArgumentException("servono almeno 100 euro sul conto");

		super.deposit(to, amount);
	}

	@Override
	public void withdraw(String from, double amount) throws BankException {
		if (exists(from) && balanceOf(from) - amount < 100.0)
			throw new IllegalArgumentException("bisogna lasciare almeno 100 euro sul conto");

		super.withdraw(from, amount);
	}

	@Override
	public void transfer(String from, String to, double amount) throws BankException {
		if (exists(from) && balanceOf(from) - amount < 100.0)
			throw new IllegalArgumentException("bisogna lasciare almeno 100 euro sul conto");

		if (to != null && !exists(to) && amount < 100.0)
			throw new IllegalArgumentException("servono almeno 100 euro sul conto");

		super.transfer(from, to, amount);
	}
}