import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
class Solution {
	Solution() {
	}
	public static int[] integerArray(String str) {
		return Arrays.stream(str.split(","))
		.mapToInt(Integer::parseInt).toArray();
	}
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int[] arrayOne = new int[scan.nextInt()];
		int[] arrayTwo = new int[scan.nextInt()];
		if (arrayOne.length != 0) {
		arrayOne = integerArray(scan.nextLine());
		}
		if (arrayTwo.length != 0) {
		arrayTwo = integerArray(scan.nextLine());
		}
		int total = arrayOne.length + arrayTwo.length;
		int[] result = new int[total];
		System.arraycopy(arrayOne, 0, result, 0, arrayOne.length);
		System.arraycopy(arrayTwo, 0, result, arrayOne.length, arrayTwo.length);
		Arrays.sort(result);
		System.out.println(result);
		}
	}
