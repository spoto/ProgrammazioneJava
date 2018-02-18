package it.univr.hairbnb;

import java.util.Comparator;
import java.util.SortedSet;

public class Main {
	public static void main(String[] args) {
		Room room1 = new Room("Room with view in Borgo Roma", 2, 30);
		Room room2 = new Room("Nice flat in Chievo", 4, 70);
		Room room3 = new Room("Historic room in Verona", 1, 80);

		room1.addReview(new Review("Albert Einstein", "I loved the room, large and with view on the hospital", Review.Stars.FOUR));
		room1.addReview(new Review("Liz Taylor", "Ugly place, full of hair", Review.Stars.ONE));
		room2.addReview(new Review("Vasco Rossi", "Really lovely", Review.Stars.FIVE));

		HairBnB bnb = new HairBnB();
		bnb.addRooms(room1, room2, room3);

		SortedSet<Room> queryByPrice = bnb.sortedAvailableFor(1, 70, new Comparator<Room>() {

			@Override
			public int compare(Room r1, Room r2) {
				return r1.getPriceForDay() - r2.getPriceForDay();
			}
		});

		// oppure in Java 8:
		// queryByPrice = bnb.sortedAvailableFor(1, 70, Comparator.comparing(Room::getPriceForDay));

		SortedSet<Room> queryByStars = bnb.sortedAvailableFor(1, 70, new Comparator<Room>() {

			@Override
			public int compare(Room r1, Room r2) {
				double diff = r1.averageStars() - r2.averageStars();
				if (diff < 0)
					return 1;
				else if (diff > 0)
					return -1;
				else
					return 0;
			}
		});

		// oppure in Java 8:
		// queryByStars = bnb.sortedAvailableFor(1, 70, (r1, r2) -> Double.compare(r2.averageStars(), r1.averageStars()));
	}
}