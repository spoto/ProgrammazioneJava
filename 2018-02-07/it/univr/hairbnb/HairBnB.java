package it.univr.hairbnb;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class HairBnB {
	public Set<Room> rooms = new HashSet<>();
	
	public void addRooms(Room... rooms) {
		for (Room room: rooms)
			this.rooms.add(room);
	}

	public Set<Room> availableFor(int minPeople, int maxPrice) {
		Set<Room> result = new HashSet<>();
		for (Room room: rooms)
			if (room.getPeople() >= minPeople && room.getPriceForDay() <= maxPrice)
				result.add(room);

		if (result.isEmpty())
			throw new NoRoomAvailableException();

		return result;
	}

	public SortedSet<Room> sortedAvailableFor(int minPeople, int maxPrice, Comparator<Room> comparator) {
		// creiamo un insieme ordinato rispetto al comparatore fornito
		SortedSet<Room> result = new TreeSet<>(comparator);

		// aggiungiamo tutte le stanze compatibili con la richiesta
		result.addAll(availableFor(minPeople, maxPrice));

		return result;
	}
}