import java.util.Scanner;
/**
 *the class to store the book.
 *details.
 */
class Book implements Comparable<Book> {
    /**
     *the book name.
     */
    private String bookName;
    /**
     *the variable to author name.
     */
    private String authorName;
    /**
     *the variable to store book price.
     */
    private String bookPrice;
    /**
     *the variable to store quantity.
     */
    private int quantity;
    /**
     *the constructor to initialize variables.
     *
     * @param      name    The name
     * @param      author  The author
     * @param      price   The price
     */
    Book(final String name,
     final String author, final String price) {
        this.bookName = name;
        this.authorName = author;
        this.bookPrice = price;
    }
    /**
     * return the book name.
     *
     * @return     The book.
     */
    public String getBook() {
        return bookName;
    }
    /**
     * the compareTo method is to
     * compare the object with other.
     *
     * @param      that  other object.
     *
     * @return value which gives the compared value.
     */
    public int compareTo(final Book that) {
        return -1;
    }
}
/**
 *the class is to perform the binary search tree.
 * @param      <T>      { parameter_description }
 * @param      <Value>  The value
 */
class BinarySearchT<T
    extends Comparable<T>, Value> {
    /**
     * the class is for maintaining left and right element.
     * storing the key and value pair.
     */
    class Node {
        /**
         *the key variable to store the book obj.
         */
        private Book key;
        /**
         *the variable to store the value.
         */
        private Value value;
        /**
         *the method to store the left node.
         */
        private Node left;
        /**
         *the method to store the right node.
         */
        private Node right;
        /**
         * the constructor is to initialize.
         *
         * @param  keys  is of Book type.
         * @param  values  The value
         */
        Node(final Book keys,
         final Value values) {
            this.key = keys;
            this.value = values;
        }
    }
    /**
     * the root is of node type.
     */
    private Node root;
    /**
     *the constructor is intialize.
     */
    BinarySearchT() {
        root = null;
    }
    /**
     *the method is to insert.
     * element in BST.
     *the time complexity is N.
     *it should go through the complete.
     *tree to insert an element.
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Book key,
     final Value value) {
        root = put(root, key, value);
    }
    /**
     *the override method for recursive process.
     *
     * @param      temp   node to store the root.
     * @param      key    The key
     * @param      value  The value
     *
     * @return root value.
     */
    private Node put(final Node temp,
        final Book key, final Value value) {
        if (temp == null) {
            return new Node(key, value);
        }
        int comp = key.getBook().compareTo(
            temp.key.getBook());
        if (comp < 0) {
            temp.left = put(temp.left, key, value);
        } else if (comp > 0) {
            temp.right = put(temp.right, key, value);
        } else if (comp == 0) {
            temp.value = value;
        }
        return temp;
    }
    /**
     *the method is to get the value of.
     *corresponding.
     *tree.
     *the time complexity is N.
     *it should go through the complete.
     *tree to get value of an element.
     * @param      key   The key
     *
     * @return the value of respective key.
     */
    public Value get(final Book key) {
        Node temp = root;
        while (temp != null) {
            int comp = key.getBook().compareTo(
                temp.key.getBook());
            if (comp < 0) {
                temp = temp.left;
            } else if (comp > 0) {
                temp = temp.right;
            } else if (comp == 0) {
                return temp.value;
            }
        }
        return null;
    }
}
/**
 *the class for main function.
 */
final class Solution {
    /**
     *an empty constructor.
     */
    private Solution() {
    }
    /**
     *this is the main function for reading.
     *input
     * @param     args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        final int three = 3;
        final int four = 4;
        BinarySearchT<Book, Integer> object
        = new BinarySearchT<Book, Integer>();
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] tokens = line.split(",");
            switch (tokens[0]) {
            case "put":
                Book obj = new Book(tokens[1],
                                    tokens[2], tokens[three]);
                object.put(obj, Integer.parseInt(tokens[four]));
                break;
            case "get":
                Book getObj = new Book(tokens[1],
                                       tokens[2], tokens[three]);
                System.out.println(object.get(getObj));
                break;
            default: break;
            }
        }
    }
}
