package it.univr.rent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Agency {
	private final String name;
	// i due campi seguenti si potrebbero fondere in un'unica SortedMap<Model, Integer>
	private final SortedSet<Model> fleet = new TreeSet<>();
	private final Map<Model, Integer> rentings = new HashMap<>();

	public Agency(String name, Model... fleet) {
		if (fleet.length == 0)
			throw new IllegalArgumentException("An agency must have at least a model to rent");

		this.name = name;

		for (Model model: fleet) {
			this.fleet.add(model);
			this.rentings.put(model, 0);
		}
	}

	public Set<Model> modelsAvailableForLicense(License license) {
		Set<Model> result = new HashSet<>();
		for (Model model: fleet)
			if (model.canBeDrivenWith(license))
				result.add(model);
		
		return result;
	}

	public void rent(Model model, License license, int days) {
		if (!model.canBeDrivenWith(license))
			throw new IllegalLicenseException();

		if (!fleet.contains(model))
			throw new ModelNotAvailableException();

		rentings.put(model, rentings.get(model) + days);
	}

	public Model mostRented() {
		Model result = null;
		for (Model model: fleet)
			if (result == null || rentings.get(model) > rentings.get(result))
				result = model;

		return result;
	}

	public String toString() {
		String result = "Agency " + name + ". Available models:";
		int length = result.length();
		result += "\n";

		while (result.length() <= length * 2)
			result += "-";

		result += "\n";

		for (Model model: fleet)
			result += model.getName() + "\t" + model.pricePerDay() + " euros per day\n";

		return result;
	}
}