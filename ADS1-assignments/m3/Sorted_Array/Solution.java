import java.util.Scanner;
import java.util.Arrays;
/**
 * the class which contains the.
 * main method two combine
 *  two arrays
 */
class Solution {
	/** an empty constructor.
	*/
	Solution() {
	}
	/** this method changes the.
	*string to integer array.
	*/
	public static int[] integerArray(final String str) {
		return Arrays.stream(str.split(","))
		.mapToInt(Integer::parseInt).toArray();
	}
	/** the main method is to read the.
	*input and print the output.
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
		System.arraycopy(arrayOne, 0, result, 0, arrayOne.length);
		System.arraycopy(arrayTwo, 0, result, arrayOne.length, arrayTwo.length);
		// Arrays.sort(result);
		int temp = 0;
		for (int i = 0; i < result.length; i++) {
			for (int j = 1; j < result.length; j++) {
				if (result[i] > result[j]) {
					temp = result[i];
					result[i] = result[j];
					result[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(result).replace("[", "").replace("]", "").replace(" ", ""));
		}
	}

