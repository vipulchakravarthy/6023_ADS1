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
		print();
	}

	public void pop() {
		Node temp = head;
		head = temp.next;
		size--;
		print();
		}
	public void enqueue(int data)  {
		Node obj = new Node(data);
		if (size == 0) {
			tail = obj;
			head = obj;
		} else {
			tail.next = obj;
			tail = obj;
			size--;
		}
		print();
		}
		public void print() {
			String str = "";
			Node temp = head;
			while ( temp.next != null) {
				str += temp.data + ",";
				temp = temp.next;
			}
			str += temp.data;
			System.out.println(str);
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
			String[] tokens = line.split(" ");
			switch(tokens[0]) {
				case "push":
					object.push(Integer.parseInt(tokens[1]));
					break;
				case "pop":
					object.pop();
					break;
				case "enqueue":
					object.enqueue(Integer.parseInt(tokens[1]));
					break;
				default: break;
			}
		}
	}

}
