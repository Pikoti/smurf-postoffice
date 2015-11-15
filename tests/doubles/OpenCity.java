package doubles;

import java.util.List;

import city.City;
import city.Inhabitant;

public class OpenCity extends City {

	
	public OpenCity(String name) {
		super(name);
	}

	/**
	 * Get the list of inhabitants of <code>this</code> city.
	 * @return the list of inhabitant of <code>this</code> city.
	 */
	public List<Inhabitant> getInhabitants() {
		return inhabitants;
	}
	
}
