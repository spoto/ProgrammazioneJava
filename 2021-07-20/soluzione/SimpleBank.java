package it.univr.bank;

import java.util.HashMap;
import java.util.Map;

public class SimpleBank implements Bank {

	private final Map<String, Double> accounts = new HashMap<>();

	@Override
	public double balanceOf(String account) throws BankException {
		if (account == null)
			throw new IllegalArgumentException();

		if (!exists(account))
			throw new BankException();

		return accounts.get(account);
	}

	@Override
	public void deposit(String to, double amount) {
		if (to == null || amount < 0)
			throw new IllegalArgumentException();

		accounts.put(to, accounts.getOrDefault(to, 0.0) + amount);
	}

	@Override
	public void withdraw(String from, double amount) throws BankException {
		if (from == null || amount < 0)
			throw new IllegalArgumentException();
		
		if (!exists(from) || balanceOf(from) < amount)
			throw new BankException();

		accounts.put(from, accounts.get(from) - amount);
	}

	@Override
	public void transfer(String from, String to, double amount) throws BankException {
		if (from == null || to == null || amount < 0)
			throw new IllegalArgumentException();

		if (!exists(from) || balanceOf(from) < amount)
			throw new BankException();

		accounts.put(from, accounts.get(from) - amount);
		accounts.put(to, accounts.getOrDefault(to, 0.0) + amount);
	}

	protected final boolean exists(String account) {
		return accounts.containsKey(account);
	}
}