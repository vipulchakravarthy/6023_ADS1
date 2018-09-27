import java.util.Scanner;
class Stack {
	private char[] stack;
	public int top;
	Stack(int length) {
		stack = new char[length];
		top = 0;
	}
	public void push(char c) {
		stack[top++] = c;
	}
	public char pop() {
		if (top!=0) {
		return stack[top-1];
	} return ' ';
}
	public boolean isEmpty() {
		if (top == 0) {
			return true;
		}
		return false;
	}
}
class Solution {
	String response;
	Solution() {}
	public static void balParanthesis(String s) {
		Stack stackObj = new Stack(s.length());
		char result = ' ';
		int flag = 0;
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) == '{') || (s.charAt(i) == '[') || (s.charAt(i) == '(')) {
				stackObj.push(s.charAt(i));
			} else {
				 result = stackObj.pop();
				 if (result == ' ') {
				 	flag = 1;
				 	break;
				 }
				 if (result == '{' && s.charAt(i) == '}') {
				 	continue;
				 } else if (result == '[' && s.charAt(i) == ']') {
					continue;
				 } else if (result == '(' && s.charAt(i) == ')') {
				 	continue;
				 } else {
				 	flag = 1;
				 	break;
				 }
			}
			}
		if (stackObj.top == 0 && flag == 0) {
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
