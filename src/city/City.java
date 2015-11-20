package city;

import java.util.ArrayList;
import java.util.List;

/**
 * I am a city of inhabitants.
 */

public class City {

	protected String name;
	protected Postbox postbox;
	protected List<Inhabitant> inhabitants;

	
	public City(String name) {
		this.name = name;
		this.inhabitants = new ArrayList<Inhabitant>();
		this.postbox = new Postbox();
	}
	
	/**
	 * Get the postbox of the city.
	 * @return postbox of the city.
	 */
	public Postbox getPostbox(){
		return this.postbox;
	}
	
	/**
	 * Add an inhabitant to the city.
	 * @param inhabitant the inhabitant to add.
	 */
	public void addInhabitant(Inhabitant inhabitant) {
		inhabitants.add(inhabitant);
	}
	
	/**
	 * Get an inhabitant of the city
	 */
	public Inhabitant getInhabitant(int index) {
		return inhabitants.get(index);
	}
	
	/**
	 * Get number of inhabitants in the city
	 * @return number of inhabitants in <code>this</code> city
	 */
	public int getNumberInhabitants() {
		return inhabitants.size();
	}
}
