package it.univr.pizzeria;

public class Order {
	private final Pizza[] pizzas;

	public Order(Pizza... pizzas) {
		this.pizzas = pizzas;
	}

	@Override
	public String toString() {
		String result = "----------------------\n";

		for (Pizza pizza: pizzas)
			result += pizza + " (" + pizza.getPrice() + " euros)\n";

		result += "----------------------\n";
		result += "Total price: " + getPrice() + " euros";

		return result;
	}

	public int getPrice() {
		int price = 0;
		for (Pizza pizza: pizzas)
			price += pizza.getPrice();
		
		return price;
	}
}