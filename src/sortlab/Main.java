package sortlab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Atom atom1 = new Atom(true,"b");
		Atom atom2 = new Atom(false,"a");
		Atom atom3 = new Atom(true,"aa");
		Atom atom4 = new Atom(true,"a");
		List<Atom> list = new ArrayList<Atom>();
		list.add(atom1);
		list.add(atom2);
		list.add(atom3);
		list.add(atom4);	
		
		/*Unsorted list*/
		
		System.out.println("Before Sorting");
		for (Atom atom: list){
			System.out.println(atom.getId());
		}
		for (Atom atom: list){
			System.out.println(atom.getName());
		}
		
		/*sort*/
		Collections.sort(list);
		
		/*Sorted List*/

		System.out.println("After Sorting");
		for (Atom atom: list){
			System.out.println(atom.getId());
		}
		for (Atom atom: list){
			System.out.println(atom.getName());
		}
	}

}