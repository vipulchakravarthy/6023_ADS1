import java.util.Scanner;
/**
 * the class is to perform.
 * the quick sort
 */
class Quick {
    /**
     *the cutoff variable with.
     * private specifier.
     */
    private int cutoff;
    /**
     * the constructor is to initialize.
     *
     * @param  cutof  The cutof
     */
    Quick(final int cutof) {
        this.cutoff = cutof;
    }
    /**
     * to check a is lesser than b or not.
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     *
     * @return  if a < b is return true or else
     * false
     */
    public boolean lesser(
        final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
    /**
     * the swap method is to exchange the elements in.
     * array.
     *
     * @param      array  The array
     * @param      i  the index to be swapped
     * @param      j  the index to be swapped
     */
    public void swap(
        final Comparable[] array, final int i, final int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    /**
     * the insertion sort is to be done.
     * if the array partition is lessthan cutoff.
     * then we have to call insertion sort.
     *time complexity will be N^2
     * @param      array  The array
     * @param      low    The low
     * @param      high   The high
     */
    public void insertionSort(
        final Comparable[] array, final int low, final int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && lesser(array[j], array[j - 1]); j--) {
                swap(array, j, j - 1);
            }
        }
    }
    /**
     * the sort method will sort the data.
     * the sort method will have time complexity
     * of O(NlogN)
     * @param      array  The array
     * @param      low    The low
     * @param      high   The high
     */
    public void sort(
        final Comparable[] array, final int low, final int high) {
        if (high - low + 1  <=  cutoff) {
            insertionSort(array, low, high);
            System.out.println("insertionSort called");
            return;
        }
        int j = partition(array, low, high);
        sort(array, low, j - 1);
        sort(array, j + 1, high);
    }
    /**
     *
     *this method is to partition the.
     *array for sorting.
     * the time complexiety will be O(NlogN)
     * @param      array  The array
     * @param      low    The low
     * @param      high   The high
     *
     * @return  pivot element.
     */
    public int partition(
        final Comparable[] array, final int low, final int high) {
        int start = low;
        int end = high + 1;
        Comparable pivot = array[low];
        while (true) {
            while (lesser(array[++start], pivot)) {
                if (start == high) {
                    break;
                }
            }
            while (lesser(pivot, array[--end])) {
                if (end == low) {
                    break;
                }
            }
            if (start >= end) {
                break;
            }
            swap(array, start, end);
        }
        swap(array, low, end);
        System.out.println(print(array));
        return end;
    }
    /**
     *this is to display the data in sorted order.
     *the time complexiety is O(N)
     *N is the size of array.
     * @param      arr   The arr
     *
     * @return string of data
     */
    public String print(final Comparable[] arr) {
        String str = "[";
        int i;
        for (i = 0; i < arr.length - 1; i++) {
            str += arr[i] + ", ";
        }
        str += arr[i] + "]";
        return str;
    }
}
/**
 *this class is for main.
 */
final class Solution {
    /**
     *this is an empty constructor.
     */
    private Solution() {
    }
    /**
     *this is for reading input.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputs = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < inputs; i++) {
            int cutoff = scan.nextInt();
            scan.nextLine();
            if (cutoff == 0) {
                System.out.println("[]");
            } else {
                String[] array = scan.nextLine().split(" ");
                Quick obj = new Quick(cutoff);
                obj.sort(array, 0, array.length - 1);
                System.out.println(obj.print(array));
            }
        }
    }
}
