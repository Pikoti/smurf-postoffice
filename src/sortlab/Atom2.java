
package sortlab;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

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

	public int compare(Atom2 o1, Atom2 o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Comparator<Atom2> reversed() {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Atom2> thenComparing(Comparator<? super Atom2> other) {
		// TODO Auto-generated method stub
		return null;
	}

	public <U> Comparator<Atom2> thenComparing(
			Function<? super Atom2, ? extends U> keyExtractor,
			Comparator<? super U> keyComparator) {
		// TODO Auto-generated method stub
		return null;
	}

	public <U extends Comparable<? super U>> Comparator<Atom2> thenComparing(
			Function<? super Atom2, ? extends U> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Atom2> thenComparingInt(
			ToIntFunction<? super Atom2> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Atom2> thenComparingLong(
			ToLongFunction<? super Atom2> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Atom2> thenComparingDouble(
			ToDoubleFunction<? super Atom2> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> nullsFirst(Comparator<? super T> comparator) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> nullsLast(Comparator<? super T> comparator) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T, U> Comparator<T> comparing(
			Function<? super T, ? extends U> keyExtractor,
			Comparator<? super U> keyComparator) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
			Function<? super T, ? extends U> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> comparingInt(
			ToIntFunction<? super T> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> comparingLong(
			ToLongFunction<? super T> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> comparingDouble(
			ToDoubleFunction<? super T> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	} 
}
