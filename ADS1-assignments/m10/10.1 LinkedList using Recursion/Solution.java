import java.util.Scanner;
/**
 *the Node class is to store.
 *every element data.
 */
class Node {
    /**
     * the data variable is.
     * to store element info.
     * with private specifier.
     */
    private int data;
    /**
     *the next variable is to store.
     *address of next element.
     */
    private Node next;
    /**
     *the constructor to initialize the.
     *data.
     * @param element data which is to be.
     * added to linked list
     */
    Node(final int element) {
        data = element;
        next = null;
    }
    /**
     * this is to get the element.
     * @return  The data part.
     * of particular node.
     */
    public int getData() {
        return data;
    }
    /**
     *this is to get the address.
     * @return     The address.
     * at that node
     */
    public Node getNext() {
        return next;
    }
    /**
     * this is to set the address.
     *
     * @param      obj   The object
     */
    public void setNext(final Node obj) {
        next = obj;
    }
}
/**
 * the linked list class to store all.
 * elements
 */
class LinkedList {
    /**
     * the head node with private.
     */
    private Node head;
    /**
     * the counter with private.
     */
    private int counter;
    /**
     * the size of linked list with private.
     */
    private int size;
    /**
     *the temp node for moving the.
     *pointer
     */
    private Node temp;
    /**
     *previous element.
     */
    private Node before;
    /**
     * next element.
     */
    private Node after;
    /**
     *the constructor to initialize.
     */
    LinkedList() {
        size = 0;
        counter = 1;
        temp = head;
    }
/**
 * the insertAt method makes the.
 * element to insert at particular position
 * the time complexity will be O(N)
 * N is the size of the linked list
 * @param      index      The index
 * @param      element    The element
 *
 * @throws     Exception  { exception_description }
 */
    public void insertAt(final int index,
     final int element) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("Can't insert at this position.");
        }
        Node obj = new Node(element);
        if (size == 0) {
            head = obj;
            temp = head;
            size++;
            return;
        }
        if (index == 0) {
            obj.setNext(head);
            head = obj;
            temp = head;
            size++;
            return;
        } else if (index == counter) {
            obj.setNext(temp.getNext());
            temp.setNext(obj);
            temp = head;
            counter = 1;
            size++;
            return;
        }
        temp = temp.getNext();
        counter++;
        insertAt(index, element);
    }
    /**
     * the reverses the complete linked list.
     *
     * @throws     Exception  { exception_description }
     */
    public void reverse() throws Exception {
        if (size == 0) {
            throw new Exception("No elements to reverse.");
        }
        after = temp.getNext();
        temp.setNext(before);
        before = temp;
        if (after == null) {
            head = temp;
            before = null;
            return;
        }
        temp = after;
        reverse();
    }
    /**
     * this method is to display all.
     * elements
     * @return string format of linked list
     */
    public String print() {
        String str = "";
        temp = head;
        while (temp.getNext() != null) {
            str += temp.getData() + ", ";
            temp = temp.getNext();
        }
        str += temp.getData();
        temp = head;
        return str;
    }
}
/**
 *this is for main class.
 */
final class Solution {
    /**
     *empty constructor.
     */
    private Solution() { }
    /**
     *this is the main method for reading inputs.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList object = new LinkedList();
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
            case "insertAt":
                try {
                    object.insertAt(
                        Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2]));
                    System.out.println(object.print());
                } catch (Exception e) {
                System.out.println(e.getMessage());
                }
                break;
            case "reverse":
                try {
                    object.reverse();
                    System.out.println(object.print());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            default: break;
            }
        }
    }
}
