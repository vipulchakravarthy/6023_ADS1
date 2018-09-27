import java.util.Scanner;
/**
 *the class for main method and.
 * perform the balanced paranthesis.
 */
final class Solution {
    /**
     * the empty constructor.
     */
    private Solution() {
    }
    /**
     * this method is to.
     * check whether the string is
     * with balanced paranthesis or not
     * @param      str   The string
     */
    public static void balParanthesis(final String str) {
        String[] s = str.split("", str.length());
        String[] stack = new String[str.length()];
        int size = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("{") || s[i].equals("[") || s[i].equals("(")) {
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
/**
 * the main method is.
 * to read the input.
 *
 * @param  args  The arguments
 */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int range = scan.nextInt();
        for (int i = 0; i < range; i++) {
            balParanthesis(scan.next());
        }
    }
}
