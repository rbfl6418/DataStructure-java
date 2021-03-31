package list.linkedlist.implementation;

public class LinkedList {
	//ù��° ��带 ����Ű�� �ʵ�
	private Node head;
	private Node tail;
	//private int size = 0;
	public int size;
	
	public void test() {
		int a = 0;
		System.out.println(a);
	}
	
	//Node�� �̳�Ŭ������ �����Ѵ�.
	private class Node{
		//�����Ͱ� ����� �ʵ�
		private Object data;
		//���� ��带 ����Ű�� �ʵ�
		private Node next;
		//�����ڸ� �̿��ؼ� Node��ü�� ������ �� �ʱ�ȭ��Ų��.
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		//����� ������ ���� ����ؼ� Ȯ���غ� �� �ִ� ��ɤ�
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
			//����Ʈ�� ��尡 ���ٸ� tail.next�� ���� �������� �ʱ� ������
			//ù��° ��带 �߰��ϴ� �޼ҵ带 ����Ѵ�.
			addFirst(input);
		}else {
		//������ ����� ���� ���� ������ ��带 �����մϴ�.
		tail.next = newNode;
		//������ ��带 �����մϴ�.
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
			//k�� 0�̶�� ù��° ���� �߰��ϴ� ���̱� ������ addFirst�� ����Ѵ�.
			addFirst(input);
		}else {
			Node prevNode = node(k-1);
			//k��° ��带 prevNode�� �����Ѵ�.
			Node nextNode = prevNode.next;
			Node newNode = new Node(input);
			prevNode.next = newNode;
			newNode.next = nextNode;
			size++;
			//���ο� ����� ���� ��尡 ���ٸ� ���ο� ��尡 ������ ����̹Ƿ� tail�� ����
			if(newNode.next == null) {
				tail = newNode;
			}
		}
	}
	public String toString() {
		//��尡 ���ٸ� []�� ����
		if(head == null) {
			return "[]";
		}
		Node temp = head;
		String str = "[";
		//���� ��尡 ���� ������ �ݺ����� ����
		//������ ���� ���� ��尡 ���� ������ �Ʒ��� ���������� ���ܵȴ�.
		while(temp.next != null) {
			str += temp.data + ", ";
			temp = temp.next; //���� ���� �̵�
		}
		str += temp.data; //������(tail)�� ��
		return str+"]";		
	}
	public Object removeFirst() {
		//�ڹ��� �⺻���� collection�����ӿ�ũ�� remove�� ���� ��
		//������ Node�� ������ �ִ� ���� ��ȯ���ش�.
		
		//ù��° ��带 temp�� �����ϰ� head�� ���� �ι�° ���� �����Ѵ�.
		Node temp = head;
		head = head.next;
		//�����͸� �����ϱ� ���� ������ ���� �ӽ� ������ ��´�.
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
		//������ ����� index �� : size-1
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
		//Ž�� ����� �Ǵ� ��带 temp�� �����Ѵ�
		Node temp = head;
		int index = 0;
		while(temp.data != data) {
			temp = temp.next; //���� ���
			index++;
			if(temp == null) {
				//temp�� ���� null�̶�� ���� �� �̻� Ž�� ����� ���ٴ� ���� �ǹ��Ѵ�.
				return -1; //�˻��� �����Ŵ
			}
		}
		//Ž�� ����� ã�Ҵٸ� ����� �ε��� ���� �����Ѵ�.
		return index;
	}
	public ListIterator listIterator() {
		return new ListIterator();
	}
	//�̳� Ŭ����
	public class ListIterator{
		private Node next;
		private Node lastReturned;
		private int nextIndex;
		//������
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
