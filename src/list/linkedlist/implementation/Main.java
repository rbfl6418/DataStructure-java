package list.linkedlist.implementation;

public class Main {

	public static void main(String[] args) {
		LinkedList numbers = new LinkedList(); //new를 통해  LinkedList클래스를 인스턴스화 시킨다.
		/*
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		LinkedList.ListIterator i = numbers.listIterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		*/
		numbers.test();
		System.out.println(numbers.size);
	}
}
