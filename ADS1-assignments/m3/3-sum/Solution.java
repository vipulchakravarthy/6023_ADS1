import java.util.Scanner;
import java.util.Arrays;
/**
 *the three sum class is.
 *to calculate the count.
 */
class ThreeSum {
	/**
	 * the empty contructor.
	 */
	ThreeSum() {

	}
	/**
	 * the method to calcualte the.
	 * number of times the three elements
	 * make the sum as zero.
	 * @param      array  The array
	 * @return  count integer variable
	 */
	public int calculate(final long[] array) {
		Arrays.sort(array);
		int count = 0;
		long first = 0;
		int next = 0;
		int last = 0;
		for (int i = 0; i < array.length - 2; i++) {
			first = array[i];
			next = i + 1;
			last = array.length - 1;
			while (next < last) {
				long termTwo = array[next];
				long termThree = array[last];
				if ((first + termTwo + termThree) == 0) {
					count++;
					last--;
					next++;
				} else if ((first + termTwo + termThree) > 0) {
					last--;
				} else {
					next++;
				}
			}
		}
		return count;
}
}
/**
 * the solution class for main method.
 */
final class Solution {
	private Solution() {

	}
	/**
	 * the main method to.
	 * take the input from user.
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		long[] array = new long[length];
		ThreeSum obj = new ThreeSum();
		for (int i = 0; i < length; i++) {
			array[i] = scan.nextInt();
		}
		System.out.println(obj.calculate(array));
	}
}
