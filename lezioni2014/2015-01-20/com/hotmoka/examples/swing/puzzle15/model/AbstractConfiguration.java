package com.hotmoka.examples.swing.puzzle15.model;

public abstract class AbstractConfiguration implements Configuration {

	@Override
	public String toString() {
		String result = "";
		for (int y = 0; y < 4; y++)
			result += String.format("%2d %2d %2d %2d\n", at(0, y), at(1, y), at(2, y), at(3, y));

		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Configuration) {
			Configuration otherAsConfiguration = (Configuration) other;
			for (int y = 0; y < 4; y++)
				for (int x = 0; x < 4; x++)
					if (at(x, y) != otherAsConfiguration.at(x, y))
						return false;

			return true;
		}
		else
			return false;
	}

	@Override
	public int hashCode() {
		return at(0,0) ^ (at(0,1) << 2) ^ (at(0,2) << 4) ^ (at(0,3) << 6)
			^ (at(1,0) << 8) ^ (at(1,1) << 10) ^ (at(1,2) << 12) ^ (at(1,3) << 14)
			^ (at(2,0) << 16) ^ (at(2,1) << 18) ^ (at(2,2) << 20) ^ (at(2,3) << 22)
			^ (at(3,0) << 24) ^ (at(3,1) << 26) ^ (at(3,2) << 28) ^ (at(3,3) << 30);
	}
}