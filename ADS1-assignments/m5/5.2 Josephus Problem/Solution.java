import java.util.Scanner;
class CircularQueue {
	Operations obj;
	CircularQueue() {
		obj = new Operations();
	}
	public void push(int number) {
		for (int i = 0; i <= number; i++) {
			obj.insertEnd(i);
		}
	}
	public void pop(int number, int length) {
		System.out.println(length);
		int[] arr = new int[length];
		Node temp = obj.head;
		int range = number;
		int counter = 0;
		int element = 0;
		while (obj.size != 0) {
			while (counter != range - 1) {
				obj.insertEnd(temp.data);
				temp = temp.next;
				obj.deleteStart();
				counter++;
			}
		arr[element++] = temp.data;
		counter = 0;
		temp = temp.next;
		obj.deleteStart();
		}
		arr[element++] = temp.data;
		for (int i = 0; i < length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
class Solution {
	Solution() {
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CircularQueue obj = new CircularQueue();
		int lines = scan.nextInt();
		scan.nextLine();
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(" ");
			obj.push(Integer.parseInt(tokens[0]));
			obj.pop(Integer.parseInt(tokens[1]),
				Integer.parseInt(tokens[0]));
		}
	}
}
