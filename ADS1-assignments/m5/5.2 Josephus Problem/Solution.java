import java.util.Scanner;
/**
 *the class for applying circular queue.
 */
class CircularQueue {
    /**
     * the object for operations class.
     */
    private Operations obj;
    /** constructor to initialize object.
    */
    CircularQueue() {
        obj = new Operations();
    }
    /**
     *the method is to push the elements.
     *to queue.
     * @param      number  The number
     */
    public void push(final int number) {
        for (int i = 0; i < number; i++) {
            obj.insertEnd(i);
        }
    }
    /**
     * the method to perform circular.
     *queue
     * @param      number  The number
     * @param      length  The length
     */
    public void pop(final int number, final int length) {
        int[] arr = new int[length];
        Node temp = obj.head;
        int range = number;
        int counter = 0;
        int index = 0;
        while (obj.size != 0) {
            while (counter != range - 1) {
                obj.insertEnd(temp.data);
                temp = temp.next;
                obj.deleteStart();
                counter++;
            }
            arr[index++] = temp.data;
            temp = temp.next;
            counter = 0;
            obj.deleteStart();
        }
        for (int i = 0; i < length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[length - 1]);
    }
}
/**
 *the class for main method.
 */
final class Solution {
    /**
     *an empty constructor.
     */
    private Solution() {
    }
    /**
     *the main method to give user input.
     *
     * @param  args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        CircularQueue obj = new CircularQueue();
        int lines = scan.nextInt();
        scan.nextLine();
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] tokens = line.split(" ");
            obj.push(Integer.parseInt(tokens[0]));
            obj.pop(Integer.parseInt(tokens[1]),
                    Integer.parseInt(tokens[0]));
        }
    }
}
