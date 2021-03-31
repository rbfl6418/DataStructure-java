package list.linkedlist.implementation;

public class LinkedList {
	//첫번째 노드를 가리키는 필드
	private Node head;
	private Node tail;
	//private int size = 0;
	public int size;
	
	public void test() {
		int a = 0;
		System.out.println(a);
	}
	
	//Node는 이너클래스로 정의한다.
	private class Node{
		//데이터가 저장될 필드
		private Object data;
		//다음 노드를 가리키는 필드
		private Node next;
		//생성자를 이용해서 Node객체가 생성될 때 초기화시킨다.
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		//노드의 내용을 쉽게 출력해서 확인해볼 수 있는 기능ㅇ
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;
		head = newNode;
		size++;
		if(head.next == null) {
			tail = head;
		}
	}
	public void addLast(Object input) {
		Node newNode = new Node(input);
		if(size == 0) {
			//리스트의 노드가 없다면 tail.next의 값이 존재하지 않기 때문에
			//첫번째 노드를 추가하는 메소드를 사용한다.
			addFirst(input);
		}else {
		//마지막 노드의 다음 노드로 생성한 노드를 지정합니다.
		tail.next = newNode;
		//마지막 노드를 갱신합니다.
		tail = newNode;
		size++;
		}
	}
	Node node(int index) {
		Node x = head;
		for (int i = 0; i < index; i++) {
			x = x.next;
		}
		return x;
	}
	public void add(int k, Object input) {
		if(k == 0) {
			//k가 0이라면 첫번째 노드ㅔ 추가하는 것이기 때문에 addFirst를 사용한다.
			addFirst(input);
		}else {
			Node prevNode = node(k-1);
			//k번째 노드를 prevNode로 지정한다.
			Node nextNode = prevNode.next;
			Node newNode = new Node(input);
			prevNode.next = newNode;
			newNode.next = nextNode;
			size++;
			//새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이므로 tail로 지정
			if(newNode.next == null) {
				tail = newNode;
			}
		}
	}
	public String toString() {
		//노드가 없다면 []를 리턴
		if(head == null) {
			return "[]";
		}
		Node temp = head;
		String str = "[";
		//다음 노드가 없을 때까지 반복문을 실행
		//마지막 노드는 다음 노드가 없기 때문에 아래의 구문에서는 제외된다.
		while(temp.next != null) {
			str += temp.data + ", ";
			temp = temp.next; //다음 노드로 이동
		}
		str += temp.data; //마지막(tail)의 값
		return str+"]";		
	}
	public Object removeFirst() {
		//자바의 기본적인 collection프레임워크는 remove를 했을 때
		//삭제된 Node가 가지고 있던 값을 반환해준다.
		
		//첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경한다.
		Node temp = head;
		head = head.next;
		//데이터를 삭제하기 전에 리턴할 값을 임시 번수에 담는다.
		Object returnData = temp.data;
		temp = null;
		size--;
		return returnData;
	}
	public Object remove(int k) {
		if(k == 0) {
			return removeFirst();
		}else {
			Node prevNode = node(k-1);
			Node todoDeleted = prevNode.next;
			prevNode.next = prevNode.next.next;
			Object returnData = todoDeleted .data; 
			if(todoDeleted == tail) {
				tail = prevNode;
			}
			todoDeleted = null;
			size--;
			return returnData;
		}
		
	}
	public Object removeLast() {
		//마지막 노드의 index 값 : size-1
		return remove(size-1);
	}
	public int size() {
		return size;
	}
	public Object get(int k) {
		Node temp = node(k);
		return temp.data;
	}
	public int indexOf(Object data) {
		//탐색 대상이 되는 노드를 temp로 지정한다
		Node temp = head;
		int index = 0;
		while(temp.data != data) {
			temp = temp.next; //다음 노드
			index++;
			if(temp == null) {
				//temp의 값이 null이라는 것은 더 이상 탐색 대상이 없다는 것을 의미한다.
				return -1; //검색을 종료시킴
			}
		}
		//탐색 대상을 찾았다면 대상의 인덱스 값을 리턴한다.
		return index;
	}
	public ListIterator listIterator() {
		return new ListIterator();
	}
	//이너 클래스
	public class ListIterator{
		private Node next;
		private Node lastReturned;
		private int nextIndex;
		//생성자
		ListIterator(){
			next = head;
		}
		
		public Object next() {
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.data;
		}
		
		public boolean hasNext() {
			return nextIndex < size();
		}
	}
}
