import java.util.Scanner;
import java.util.Arrays;
class Solution {
	Solution() {
	}
	public static int[] integerArray(String str) {
		if (str.equals("")) return null;
		return Arrays.stream(str.split(","))
		.mapToInt(Integer::parseInt).toArray();
	}
	public static void main(String args[]) {
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
		Arrays.sort(result);
		System.out.println(Arrays.toString(result).replace("[", "").replace("]", "").replace(" ", ""));
		}
	}
