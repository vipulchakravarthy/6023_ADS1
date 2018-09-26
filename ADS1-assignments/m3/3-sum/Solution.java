import java.util.Scanner;
class ThreeSum {
	ThreeSum() {

	}
	public int calculate(int[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				for (int k = j + 1; k < array.length; j++) {
					if (array[i] + array[j] + array[k] == 0) {
						count++;
					}
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
		int[] array = new int[length];
		ThreeSum obj = new ThreeSum();
		for (int i = 0; i < length; i++) {
			array[i] = scan.nextInt();
		}
		System.out.println(obj.calculate(array));
	}
}
