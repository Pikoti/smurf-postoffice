
package sortlab;

import java.util.Comparator;

public class Atom2 implements Comparator<Atom2>{

	protected Boolean id;
	protected String name;
	
	public Atom2(Boolean id,String name) {
		this.id = id;
		this.name = name;
	}

	public Boolean getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public int hashCode() {
		return name.hashCode();
	}

	public boolean equals(Object obj) {
		return (obj instanceof Atom2) && (this.name.equals(((Atom2) obj).getName())) 
				&& this.id.equals(((Atom2) obj).getId());
	}
	
	public int compareTo(Atom2 a) {	 
		return name.compareTo(a.getName());
	}
	
	public static Comparator<Atom2> AtomComparator = new Comparator <Atom2>() {
		public int compare(Atom2 a, Atom2 b) {
			return a.getId().compareTo(b.getId());
		}
	}; 
}
