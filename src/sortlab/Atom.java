package sortlab;

public class Atom implements Comparable<Atom>{

	protected Boolean id;
	protected String name;
	
	public Atom(boolean id,String name) {
		this.id = id;
		this.name = name;
	}

	public boolean getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public int hashCode() {
		return name.hashCode();
	}

	public boolean equals(Object obj) {
		return (obj instanceof Atom) && (name.equals(((Atom) obj).getName())) 
				&& id.equals(((Atom) obj).getId());
	}
	
	
	//return id.compareTo(a.getId()); 
	public int compareTo(Atom a) {	 
		return name.compareTo(a.getName());
	}
	
}

