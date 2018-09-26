import java.util.Scanner;
import java.util.Arrays;
class ThreeSum {
	ThreeSum() {

	}
	public int calculate(long[] array) {
		Arrays.sort(array);
		int count = 0;
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
					k = Arrays.binarySearch(array, -(array[i]+ array[j]));
					if(k > j) {
						count++;
					}
			}
		}
		return count;
}
}
final class Solution {
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
