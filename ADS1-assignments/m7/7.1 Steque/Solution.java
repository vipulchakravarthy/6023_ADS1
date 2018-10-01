import java.util.Scanner;
/**
 *the Node class is to store.
 *every element data.
 */
class Node {
    private  int data;
    private  Node next;
    Node(int e) {
        this.data = e;
        next = null;
    }
    public void setAddress(Node obj) {
        next = obj;
    }
    public int getData() {
        return this.data;
    }
    public Node getAddress() {
        return this.next;
    }
}
/**
 * Steque is to perform.
 * stack ended queue operation.
 */
class Steque {
    /**
     * the head node with private.
     */
    private Node head;
    /**
     *the tail node with private.
     */
    private Node tail;
    /**
     *the size variable to give.
     *the size of an steque.
     */
    private int size;
    /**
     *the constructor to initialize.
     * object.
     */
    Steque() {
        size = 0;
    }
    /**
     *to insert the element at start.
     *the time complexiety will be O(1).
     * @param      element  The element
     */
    public void push(final int element) {
        Node obj = new Node(element);
        if (size == 0) {
            head = obj;
            tail = obj;
        } else {
            obj.setAddress(head);
            head = obj;
        }
        size++;
    }
    /**
    *to delete the element at start.
    *the time complexiety will be O(1).
    */
    public void pop() {
        if (size > 0) {
            Node temp = head;
            head = temp.getAddress();
            size--;
        } else {
            return;
        }
    }
    /**
     *to insert the element at end.
     *the time complexiety will be O(N).
     *here N is size of steque.
     * @param      data  The data
     */
    public void enqueue(final int data)  {
        Node obj = new Node(data);
        if (size == 0) {
            tail = obj;
            head = obj;
            size++;

        } else {
            tail.setAddress(obj);
            tail = obj;
            size++;
        }
    }
    /**
     *this is to print the steque.
     *time complexiety will be O(N)
     */
    public void print() {
        if (size == 0) {
            System.out.println("Steque is empty.");
        } else if (size > 0) {
            String str = "";
            Node temp = head;
            while ( temp.getAddress() != null) {
                str += temp.getData() + ", ";
                temp = temp.getAddress();
            }
            str += temp.getData();
            System.out.println(str);
        }
    }
    /**
     *this is to clear the steque.
     *time complexiety will be O(N).
     */
    public void clear() {
        while (size > 0) {
            pop();
            size--;
        }
        System.out.println();
    }
}
/**
 * this is the solution class.
 * to take the input.
 */
class Solution {
    /**
     *this is empty constructor.
     */
    Solution() {
    }
    /**
     * the main method is to take.
     *input and call steque operation.
     * @param  args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Steque object = new Steque();
        while (scan.hasNext()) {
            String line = scan.nextLine();
            if (line.length() == 0) {
                object.clear();
            } else if (line.length() > 0) {
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                case "push":
                    object.push(
                        Integer.parseInt(tokens[1]));
                    object.print();
                    break;
                case "pop":
                    object.pop();
                    object.print();
                    break;
                case "enqueue":
                    object.enqueue(
                        Integer.parseInt(tokens[1]));
                    object.print();
                    break;
                default: break;
                }
            }
        }
    }
}
