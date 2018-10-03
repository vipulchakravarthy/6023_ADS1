import java.util.Arrays;
import java.util.Scanner;
class Insertion{
	private String[] array;
	Insertion(String[] arr) {
		this.array = arr;
	}
	public void swap(String[] array, int one, int two) {
		String temp = array[one];
		array[one] = array[two];
		array[two] = temp;
	}
	 public boolean lesser(String a, String b) {
         return a.compareTo(b) < 0;
    }
	public void insertionSort(String[] array, int low, int high) {
        for (int i = low; i < high; i++) {
            for (int j = i; j > low && lesser(array[j], array[j - 1]); j--) {
                swap(array , j, j - 1);
            }
    	}
	}
	}
class MergeSort{
	MergeSort(){}
    public boolean isSorted(String[] a, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            if (lesser(a[i], a[i - 1])) {
          		return false;
      		}
    }
    return true;
	}
    public boolean lesser(String a, String b) {
         if (a.compareTo(b) < 0) {
         	return true;
    	} else {
    		return false;
    	}
    }
	public void sort(String[] array, String[] aux, int low, int high) {
		final int cutoff = 7;
		if (high - low <= cutoff) {
			System.out.println("Insertion sort method invoked...");
			Insertion obj = new Insertion(array);
			obj.insertionSort(array, low, high);
			return;
		}
		int mid = low + (high - low) / 2;
		sort(array, aux, low, mid);
		sort(array, aux, mid + 1, high);
        if (!lesser(array[mid+1], array[mid])) {
            System.arraycopy(array, low, aux, low, high - low + 1);
            System.out.println("Array is already sorted. So, skipped the call to merge...");
            return;
        }
		merge(array, aux, low, mid, high);
	}
	public void merge(String[] array, String[] aux, int low, int mid, int high){
		assert isSorted(array, low, mid);
		assert isSorted(array, mid + 1, high);
		for (int i = 0; i <=high; i++) {
			aux[i] = array[i];
		}
		int start = low;
		int begin = mid + 1;
		for (int i = 0; i <= high; i++) {
			if (start > mid) {
				aux[i] = array[begin++];
			} else if (begin > high) {
				aux[i] = array[start++];
			} else if(lesser(array[begin], array[start])) {
				aux[i] = array[begin++];
			} else {
				aux[i] = array[start++];
			}
		}
	}
}
class Solution{
	Solution() {

	}
/*    public static int[] integerArray(final String str) {
        return Arrays.stream(str.split(","))
        .mapToInt(Integer::parseInt).toArray();
    }*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()) {
			MergeSort object = new MergeSort();
			String[] array = scan.nextLine().split(",");
			String[] aux = new String[array.length];
			object.sort(array, aux, 0, array.length - 1);
			System.out.println(Arrays.toString(array));
			System.out.println();
		}
	}
}
