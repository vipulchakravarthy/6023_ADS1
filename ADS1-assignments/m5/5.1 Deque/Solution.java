import java.util.Scanner;
class Deque {
	Operations queueObj;
	Deque() {
		queueObj = new Operations();
	}
	public boolean isEmpty() {
		if (queueObj.size == 0) {
			return true;
		}
		return false;
	}
	public int size() {
		return queueObj.size;
	}
	public void pushLeft(int item) {
		queueObj.insertStart(item);
		print();
	}
	public void pushRight(int item) {
		queueObj.insertEnd(item);
		print();
	}
	public void popLeft() {
		if (queueObj.size == 0) {
			System.out.println("Deck is empty");
			return;
		}
		queueObj.deleteStart();
		print();
	}
	public void popRight() {
		if (queueObj.size == 0) {
			System.out.println("Deck is empty");
			return;
		}
		queueObj.deleteEnd();
		print();
	}
	public void print() {
		System.out.println(queueObj.print());
	}
}

public class Solution {
	Solution() {
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Deque obj = new Deque();
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(" ");
			switch(tokens[0]) {
				case "isEmpty":
					System.out.println(obj.isEmpty());
					break;
				case "size":
					System.out.println(obj.size());
					break;
				case "pushLeft":
					obj.pushLeft(Integer.parseInt(tokens[1]));
					break;
				case "pushRight":
					obj.pushRight(Integer.parseInt(tokens[1]));
					break;
				case "popLeft":
					obj.popLeft();
					break;
				case "popRight":
					obj.popRight();
					break;
				default : break;
			}

		}

	}
}
