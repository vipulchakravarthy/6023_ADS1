import java.util.Arrays;
class Solution {
	Solution() {
	}
	public static void main(String[] args) {
		int[] array = {2, 2, 2, 2};
		int count = 0;
		int total = 0;
		int i = 0;
		Arrays.sort(array);
		while(i < array.length - 1) {
			if (array[i] == array[i + 1]) {
				count++;
			}
			if (array[i] != array[i + 1] || i == array.length - 2) {
				total += ((count + 1) * count) / 2;
			} i++;
		}
		System.out.println(total);
	}
}
