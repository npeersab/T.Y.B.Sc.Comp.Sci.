package setA.que2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Colors {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("red");
		list.add("blue");
		list.add("yellow");
		list.add("orange");
		
		System.out.println("Elements in list:");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
		
		System.out.println("\nElements in reverse order:");
		ListIterator<String> listIterator = list.listIterator(4);
		while (listIterator.hasPrevious())
			System.out.println(listIterator.previous());
		
		LinkedList<String> list2 = new LinkedList<String>();
		
		list2.add("pink");
		list2.add("green");
		
		list.addAll(2, list2);
		
		iterator = list.iterator();
		System.out.println("\nList after adding elements:");
		while (iterator.hasNext())
			System.out.println(iterator.next());
	}
}
