package it.univr.hairbnb;

import java.util.ArrayList;
import java.util.List;

public class Room {
	private final String description;
	private final int people;
	private final int pricePerDay;
	private final List<Review> reviews = new ArrayList<>();

	public Room(String description, int people, int pricePerDay) {
		this.description = description;
		this.people = people;
		this.pricePerDay = pricePerDay;
	}

	public void addReview(Review review) {
		reviews.add(review);
	}

	@Override
	public String toString() {
		String result = String.format("%s (average stars: %.2f)\n  people: %d\n  price per day: %d\n", description, averageStars(), people, pricePerDay);

		for (Review review: reviews)
			result += "\n" + review;

		return result;
	}

	public int getPeople() {
		return people;
	}

	public int getPriceForDay() {
		return pricePerDay;
	}

	public double averageStars() {
		if (reviews.isEmpty())
			return 0.0;

		int sum = 0;
		for (Review review: reviews)
			sum += review.howManyStars();

		return ((double) sum) / reviews.size();
	}
}