package sortlab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {

	public static void main(String[] args) {
		
		Atom2 atom1 = new Atom2(true,"b");
		Atom2 atom2 = new Atom2(false,"a");
		Atom2 atom3 = new Atom2(true,"aa");
		Atom2 atom4 = new Atom2(true,"a");
		List<Atom2> list = new ArrayList<Atom2>();
		list.add(atom1);
		list.add(atom2);
		list.add(atom3);
		list.add(atom4);	
		
		/*Unsorted list*/
		
		System.out.println("Before Sorting");
		for (Atom2 atom: list){
			System.out.println(atom.getId());
		}
		for (Atom2 atom: list){
			System.out.println(atom.getName());
		}
		
		/*sort*/
		//Collections.sort(list));
		
		/*Sorted List*/

		System.out.println("After Sorting");
		for (Atom2 atom: list){
			System.out.println(atom.getId());
		}
		for (Atom2 atom: list){
			System.out.println(atom.getName());
		}
	}
}
