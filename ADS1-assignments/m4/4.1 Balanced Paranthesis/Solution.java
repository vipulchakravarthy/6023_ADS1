import java.util.Scanner;
// class Stack {
// 	private char[] stack;
// 	public int top;
// 	Stack(int length) {
// 		stack = new char[length];
// 		top = 0;
// 	}
// 	public void push(char c) {
// 		stack[top++] = c;
// 	}
// 	public char pop() {
// 		if (top!=0) {
// 		return stack[top--];
// 	} return ' ';
// }
// 	public boolean isEmpty() {
// 		if (top == 0) {
// 			return true;
// 		}
// 		return false;
// 	}
// }
class Solution {
	String response;
	Solution() {}
	public static void balParanthesis(String str) {
		String[] s = str.split("", str.length());
		String[] stack = new String[str.length()];
		int size = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i].equals("{") || s[i].equals("[")|| s[i].equals("(")) {
				stack[size++] = s[i];
			} else if (size > 0) {
				if (s[i].equals("}") && stack[size - 1].equals("{")) {
					size--;
				 } else if (s[i].equals("]") && stack[size - 1].equals("[")) {
					size--;
				 } else if (s[i].equals(")") && stack[size - 1].equals("(")) {
				 	size--;
				}
			}
		}
		if (size == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int range = scan.nextInt();
		for (int i = 0; i < range; i++) {
			balParanthesis(scan.next());
		}
	}
}
