import java.util.Scanner;
import java.util.Arrays;
/**
 * the class which contains the.
 * main method two combine
 *  two arrays
 */
final class Solution {
	/** an empty constructor.
	*/
	private Solution() {
	}
	/** this method changes the.
	*string to integer array.
	 *@param Str string
	*/
	public static int[] integerArray(final String str) {
		return Arrays.stream(str.split(","))
		.mapToInt(Integer::parseInt).toArray();
	}
	/** the main method is to read the.
	*input and print the output.
	 *@param args string
	 */
	public static void main(final String args[]) {
		Scanner scan = new Scanner(System.in);
		int[] arrayOne = new int[scan.nextInt()];
		int[] arrayTwo = new int[scan.nextInt()];
		if (arrayOne.length != 0) {
		arrayOne = integerArray(scan.next());
		}
		arrayTwo = integerArray(scan.next());
		int[] result = new int[arrayOne.length + arrayTwo.length];
		int start = 0;
		int begin = 0;
		int i = 0;
		while ((start < arrayOne.length && begin < arrayTwo.length)) {
			if (arrayOne[start] < arrayTwo[begin]) {
				result[i] = arrayOne[start];
				start++;
			} else {
				result[i] = arrayTwo[begin];
				begin++;
			}
			i++;
		}
		while (begin < arrayTwo.length) {
			result[i] = arrayTwo[begin];
			begin++;
			i++;
		}
		while (start < arrayOne.length) {
			result[i] = arrayOne[start];
			start++;
		}
		System.out.println(Arrays.toString(
		result).replace("[", "").replace("]", "").replace(" ", ""));
		}
	}

