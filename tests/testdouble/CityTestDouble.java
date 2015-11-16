package testdouble;

import java.util.ArrayList;
import java.util.List;

import city.City;
import city.Inhabitant;

public class CityTestDouble extends City {

	
	public CityTestDouble(String name) {
		super(name);
		this.inhabitants = new ArrayList<Inhabitant>();
		this.postbox = new OpenPostbox();
	}

	/**
	 * Get the list of inhabitants of <code>this</code> city.
	 * @return the list of inhabitants of <code>this</code> city.
	 */
	public List<Inhabitant> getInhabitants() {
		return inhabitants;
	}
	
}
