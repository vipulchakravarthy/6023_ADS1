import java.util.Scanner;
class Node{
	int data;
	Node next;
	Node(final int element) {
		data = element;
		next = null;
	}
	public int getData() {
		return data;
	}
	public Node getNext(){
		return next;
	}
	public void setNext(final Node obj) {
		next = obj;
	}
}
class LinkedList{
	Node head;
	int counter;
	Node tail;
	int position;
	int size;
	Node temp;
	Node before;
	Node after;
	LinkedList() {
		position = 0;
		size = 0;
		counter = 1;
		temp = head;
	}
	public void insertAt(int index, int element) throws Exception {
		if ( index < 0 || index > size) {
			throw new Exception("Can't insert at this position.");
		}
		Node obj = new Node(element);
		if (size == 0){
			head = obj;
			temp = head;
			size++;
			return;
		}
		if (index == 0) {
			obj.setNext(head);
			head = obj;
			temp = head;
			size++;
			return;
		} else if(index == counter) {
			obj.setNext(temp.getNext());
			temp.setNext(obj);
			temp = head;
			counter = 1;
			size++;
			return;
		}
		temp = temp.getNext();
		counter++;
		insertAt(index , element);
	}
	public void reverse() throws Exception{
		after = temp.getNext();
		temp.setNext(before);
		before = temp;
		if (size == 0) {
			throw new Exception("No elements to reverse.");
		}
		if (after == null) {
			head = temp;
			before = null;
			return;
		}
		temp = after;
		reverse();
		}

	public String print() {
		String str = "";
		Node temp = head;
		while (temp.getNext() != null) {
			str += temp.getData() + ", ";
			temp = temp.getNext();
		}
		str += temp.getData();
		temp = head;
		return str;
	}
}
class Solution{
	Solution() {}
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList object = new LinkedList();
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
				case "insertAt":
				try {
					object.insertAt(Integer.parseInt(tokens[1]),
						Integer.parseInt(tokens[2]));
					System.out.println(object.print());
				} catch(Exception e) {
						System.out.println(e.getMessage());
				}
				break;
				case "reverse":
					try{
						object.reverse();
					System.out.println(object.print());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				default: break;
			}
		}
	}
}
