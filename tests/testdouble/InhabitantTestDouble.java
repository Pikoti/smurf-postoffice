package testdouble;

import city.Inhabitant;

public class InhabitantTestDouble extends Inhabitant {

	protected int numberOfLetterSent;
	
	public InhabitantTestDouble(String name) {
		super(name);
		this.numberOfLetterSent = 0;
	}
	
	public int getNbLetterSent() {
		return this.numberOfLetterSent;
	}
}
