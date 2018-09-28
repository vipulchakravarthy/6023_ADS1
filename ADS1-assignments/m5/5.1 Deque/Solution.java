import java.util.Scanner;
/**
 * the class deque to perform all the.
 * operations on stack
 */
class Deque {
    /**the queueObj is for.
    *implement queue operations.
    */
    Operations queueObj;
    /**
     * the constructor to initialize.
     */
    Deque() {
        queueObj = new Operations();
    }
    /**
     * to decide whether linked list is.
     * empty or not.
     *
     * @return   True if empty, False otherwise.
     */
    public boolean isEmpty() {
        if (queueObj.size == 0) {
            return true;
        }
        return false;
    }
    /**
     * this method is to return size.
     *
     * @return size of linkedlist
     */
    public int size() {
        return queueObj.size;
    }
    /**
     *insert the element at start.
     *
     * @param int item to be added
     */
    public void pushLeft(int item) {
        queueObj.insertStart(item);
        print();
    }
    /**
     *insert the element at end.
     *
     * @param int item to be added
     */
    public void pushRight(int item) {
        queueObj.insertEnd(item);
        print();
    }
    /**
     *delete the element at start.
     *
     * @param int item to be deleted
     */
    public void popLeft() {
        if (queueObj.size == 0) {
            System.out.println("Deck is empty");
            return;
        }
        queueObj.deleteStart();
        print();
    }
    /**
     *delete the element at end.
     *
     * @param int item to be deleted
     */
    public void popRight() {
        if (queueObj.size == 0) {
            System.out.println("Deck is empty");
            return;
        }
        queueObj.deleteEnd();
        print();
    }
/**
 * to print the linked list.
 */
    public void print() {
        System.out.println(queueObj.print());
    }
}
/**
 * the class for main method.
 */
public class Solution {
    /**
     * empty constructor.
     */
    Solution() {
    }
    /**
     * the main method to.
     * consider the input from user.
     * @param   args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque obj = new Deque();
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case "isEmpty":
                    System.out.println(obj.isEmpty());
                    break;
                case "size":
                    System.out.println(obj.size());
                    break;
                case "pushLeft":
                    obj.pushLeft(Integer.parseInt(
                        tokens[1]));
                    break;
                case "pushRight":
                    obj.pushRight(Integer.parseInt(
                        tokens[1]));
                    break;
                case "popLeft":
                    obj.popLeft();
                    break;
                case "popRight":
                    obj.popRight();
                    break;
                default : break;
            }

        }

    }
}
