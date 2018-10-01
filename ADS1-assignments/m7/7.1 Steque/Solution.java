import java.util.Scanner;
class Node {
	int data;
	Node next;
	Node(int e) {
		this.data = e;
		next = null;
	}
}
class Steque{
	Node head;
	Node tail;
	int size;
	Steque() {
		size = 0;
	}
	public void push(int element) {
		Node obj = new Node(element);
		if (size == 0) {
			head = obj;
			tail = obj;
		} else {
			obj.next = head;
			head = obj;
		}
		size++;
	}

	public void pop() {
		if (size == 0) {
			System.out.println("Steque is empty.");
			return;
		} else {
		Node temp = head;
		head = temp.next;
		size--;
		}
	}
	public void enqueue(int data)  {
		Node obj = new Node(data);
		if (size == 0) {
			tail = obj;
			head = obj;
			size++;

		} else {
			tail.next = obj;
			tail = obj;
			size++;
		}
		}
		public void print() {
		if (size == 0) {
			System.out.println("Steque is empty.");
		} else if (size > 0) {
			String str = "";
			Node temp = head;
			while ( temp.next != null) {
				str += temp.data + ", ";
				temp = temp.next;
			}
			str += temp.data;
			System.out.println(str);
		}
	}
		public void clear() {
			while (size > 0) {
				pop();
				size--;
			}
			System.out.println();
		}
	}


class Solution {
	Solution() {
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Steque object = new Steque();
		while (scan.hasNext()) {
			String line = scan.nextLine();
			if (line.length() == 0) {
				object.clear();
			} else if (line.length() > 0) {
			String[] tokens = line.split(" ");
			switch(tokens[0]) {
				case "push":
					object.push(Integer.parseInt(tokens[1]));
					object.print();
					break;
				case "pop":
					object.pop();
					object.print();
					break;
				case "enqueue":
					object.enqueue(Integer.parseInt(tokens[1]));
					object.print();
					break;
				default: break;
			}
		}
	}
}
}
