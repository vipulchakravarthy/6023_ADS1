import java.util.Scanner;
import java.util.Arrays;
class ThreeSum {
	ThreeSum() {

	}
	public int calculate(final long[] array) {
		Arrays.sort(array);
		int count = 0;
		long first = 0;
		long next = 0;
		long last = 0;
		for (int i = 0; i < array.length; i++) {
			first = array[i];
			next = array[i + 1];
			last = array[array.length - 1];
			while (next < last) {
				if ((first + next + last) == 0) {
					count++;
					last--;
					next++;
				} else if ((first + next + last) < 0) {
					next++;
				} else {
					last--;
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
