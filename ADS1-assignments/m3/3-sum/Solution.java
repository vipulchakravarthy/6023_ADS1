import java.util.Scanner;
import java.util.Arrays;
class ThreeSum {
	ThreeSum() {

	}
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
