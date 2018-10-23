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
    private double price;
    /**
     *constructor to initialize the object.
     * @param      book    The name of book
     * @param      author  The author
     * @param      cost    The cost
     */
    Book(final String book,
         final String author, final String cost) {
        bookName = book;
        authorName = author;
        price = Double.parseDouble(cost);
    }
    /**
     *the method to get the book name.
     *
     * @return     The book name.
     */
    public String getBook() {
        return this.bookName;
    }
    /**
     *the compare to method to compare.
     *two books.
     * @param that another object.
     *
     * @return -1 value.
     */
    public int compareTo(final Book that) {
        return -1;
    }
    /**
     *the string method to print the book name.
     *author name.
     * @return     String representation of the object.
     */
    public String toString() {
        return this.bookName + ", " + this.authorName
               + ", " + this.price;
    }
}
/**
 *the class is to perform the binary search tree.
 * @param      <Key>   here key is of book type.
 * @param      <Value>  The value is of integer type
 */
class BST<Key extends Comparable<Key>, Value> {
    /**
     * the variable is to store the root of tree.
     */
    private Node root;
    /**
     * the class is for maintaining left and right element.
     * storing the key and value pair.
     */
    private class Node {
        /**
         *the method to store the left node.
         */
        private Node left;
        /**
         *the method to store the right node.
         */
        private Node right;
        /**
         *the key variable to store the book obj.
         */
        private Book key;
        /**
         *the variable to store the value.
         */
        private Value value;
        /**
         *the variable stores the size of the node.
         */
        private int size;
        /**
         *the constructor to initialize the key.
         *and value.
         * @param      keys    The keys
         * @param      val     The value
         * @param      length  The length
         */
        Node(final Book keys,
             final Value val, final int length) {
            key = keys;
            value = val;
            size = length;
        }
    }
    /**
     *an empty constructor.
     */
    BST() {
    }
    /**
     *the method is to find the size of tree.
     *
     * @return size of the tree.
     */
    public int size() {
        return size(root);
    }
    /**
     * the size method to find the size of tree.
     *
     * @param      tempRoot  the root varible.
     *
     * @return  size of tree.
     */
    private int size(final Node tempRoot) {
        if (tempRoot == null) {
            return 0;
        }
        return tempRoot.size;
    }
    /**
     *the put function is to perform the.
     *insert an element into tree.
     * @param  key  is of book type
     * @param value  The value
     * time complexiety of this method is.
     * h
     * h is the height of the tree.
     */
    public void put(final Book key,
                    final Value value) {
        root = put(root, key, value);
    }
    /**
     *the put function is to perform the.
     *insert an element into tree.
     * time complexiety of this method is.
     * h
     * h is height of tree.
     * @param      tempRoot  The temporary root
     * @param      key  which is of book type
     * @param      value  is to store the quantity
     *
     * @return  root of the tree.
     */
    private Node put(final Node tempRoot,
                     final Book key, final Value value) {
        if (tempRoot == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.getBook().
                  compareTo(tempRoot.key.getBook());
        if (cmp < 0) {
            tempRoot.left = put(
                                tempRoot.left, key, value);
        } else if (cmp > 0) {
            tempRoot.right = put(
                                 tempRoot.right, key, value);
        } else {
            tempRoot.value = value;
        }
        tempRoot.size = 1 + size(tempRoot.left)
                        + size(tempRoot.right);
        return tempRoot;
    }
    /**
     *the method is to get the value of.
     *corresponding.
     *tree.
     *the time complexity is h.
     *h is height of tree.
     *it should go through the complete.
     *tree to get value of an element.
     * @param      key   The key is of book
     * type.
     * @return the value of respective key.
     */
    public Value get(final Book key) {
        return get(root, key);
    }
    /**
     *the method is to get the value of.
     *corresponding.
     *tree.
     *the time complexity is h.
     *h is height of tree.
     *it should go through the complete.
     *tree to get value of an element.
     * @param      key   The key is of book
     * type.
     * @param   tempRoot  The temporary root
     * @return the value of respective key.
     */
    private Value get(final Node tempRoot,
                      final Book key) {
        if (tempRoot == null) {
            return null;
        }
        int cmp = key.getBook().compareTo(
                      tempRoot.key.getBook());
        if (cmp < 0) {
            return get(tempRoot.left, key);
        } else if (cmp > 0) {
            return get(tempRoot.right, key);
        } else {
            return tempRoot.value;
        }
    }
    /**
     *this method is to return the minimum.
     *value of tree.
     * @return minimum element in tree.
     */
    public Book min() {
        return min(root).key;
    }
    /**
     *this method is to return the minimum.
     *value of tree.
     *
     * @param      tempRoot  root variable of
     *tree.
     * @return  minimum node in tree.
     */
    private Node min(final Node tempRoot) {
        if (tempRoot.left == null) {
            return tempRoot;
        } else {
            return  min(tempRoot.left);
        }
    }
    /**
     *this method is to return the maximum.
     *value of tree.
     * @return maximum element in tree.
     */
    public Book max() {
        return max(root).key;
    }
    /**
     *this method is to return the minimum.
     *value of tree.
     *
     * @param   tempRoot  root variable of
     *tree.
     * @return  maximum node in tree.
     */
    private Node max(final Node tempRoot) {
        if (tempRoot.right == null) {
            return tempRoot;
        } else {
            return max(tempRoot.right);
        }
    }
    /**
     *this method returns the.
     *less than or equal to given key.
     *of tree
     *the time complexity is h
     *h is height of tree
     * @param      key   The key which is
     *of book type
     * @return floor element.
     *returns the.
     *less than or equal to given key.
     */
    public Book floor(final Book key) {
        Node floorKey = floor(root, key);
        if (floorKey == null) {
            return null;
        }
        return floorKey.key;
    }
    /**
     *this method returns the.
     *less than or equal to given key.
     *of tree
     *the time complexity is h
     *h is height of tree
     * @param   key   The key which is
     *of book type
     *@param tempRoot  root variable of
     *tree.
     * @return floor element.
     *returns the.
     *less than or equal to given key.
     */
    private Node floor(final Node tempRoot,
                       final Book key) {
        if (tempRoot == null) {
            return null;
        }
        int cmp = key.getBook().compareTo(
                      tempRoot.key.getBook());
        if (cmp == 0) {
            return tempRoot;
        } else if (cmp < 0) {
            return floor(tempRoot.left, key);
        }
        Node temp = floor(tempRoot.right, key);
        if (temp != null) {
            return temp;
        } else {
            return tempRoot;
        }
    }
    /**
     *this method returns the.
     *greater than or equal to given key.
     *of tree
     *the time complexity is h
     *h is height of tree
     * @param      key   The key which is
     *of book type
     * @return ceiling element.
     *returns the.
     *greater than or equal to given key.
     */
    public Book ceiling(final Book key) {
        Node ceilKey = ceiling(root, key);
        if (ceilKey == null) {
            return null;
        }
        return ceilKey.key;
    }
    /**
     *this method returns the.
     *greater than or equal to given key.
     *of tree
     *the time complexity is h
     *h is the height of tree
     * @param      key   The key which is
     *of book type
     *@param tempRoot  root variable of
     *tree.
     * @return ceiling element.
     *returns the.
     *greater than or equal to given key.
     */
    private Node ceiling(final Node tempRoot,
                         final Book key) {
        if (tempRoot == null) {
            return null;
        }
        int cmp = key.getBook().compareTo(
                      tempRoot.key.getBook());
        if (cmp == 0) {
            return tempRoot;
        } else if (cmp < 0) {
            Node temp = ceiling(tempRoot.left, key);
            if (temp != null) {
                return temp;
            } else {
                return tempRoot;
            }
        }
        return ceiling(tempRoot.right, key);
    }
    /**
     * the select method gives the smallest
     * k-1th.
     *element k is the given value.
     * @param      index  The given value.
     * @return key info which is required.
     */
    public Book select(final int index) {
        Node temp = select(root, index);
        return temp.key;
    }
    /**
     * the select method gives the smallest
     * k-1th.
     *element k is the given value.
     * @param      tempRoot  The temporary root
     * @param      index     The index
     *
     * @return node which has the k-1th smallest
     * value.
     * the time complexiety of this method is
     * O(logN)
     * N is the number of nodes.
     */
    private Node select(final Node tempRoot,
                        final int index) {
        if (tempRoot == null) {
            return null;
        }
        int length = size(tempRoot.left);
        if (length > index) {
            return select(tempRoot.left, index);
        } else if (length < index) {
            return select(tempRoot.right, index - length - 1);
        } else {
            return tempRoot;
        }
    }
    /**
     *the method is to delete the minimum.
     *element in tree.
     *time complexity is O(h)
     *h is the height of tree
     */
    public void deleteMin() {
        root = deleteMin(root);
    }
    /**
    *the method is to delete the minimum.
     *element in tree.
     *time complexity is O(h)
     *h is the height of tree
     * @param tempRoot  The temporary root
     *
     * @return root of tree.
     */
    private Node deleteMin(Node tempRoot) {
        if (tempRoot.left == null) {
            return tempRoot.right;
        }
        tempRoot.left = deleteMin(tempRoot.left);
        tempRoot.size = 1 + size(tempRoot.right)
                        + size(tempRoot.left);
        return tempRoot;
    }
    /**
     *the method is to delete the maxmum.
     *element in tree.
     *time complexity is O(h)
     *h is the height of tree
     */
    public void deleteMax() {
        root = deleteMax(root);
    }
    /**
    *the method is to delete the maxmum.
     *element in tree.
     *time complexity is O(h)
     *h is the height of tree
     * @param tempRoot  The temporary root
     *
     * @return root of tree.
     */
    private Node deleteMax(Node tempRoot) {
        if (tempRoot.right == null) {
            return tempRoot.left;
        }
        tempRoot.right = deleteMax(tempRoot.right);
        tempRoot.size = 1 + size(tempRoot.right)
                        + size(tempRoot.left);
        return tempRoot;
    }
    /**
     *the method is to delete the given key.
     *time complexity is O(h)
     *h is the height of tree
     * @param      key   The key to be deleted
     */
    public void delete(Book key) {
        root = delete(root, key);
    }
    /**
    *the method is to delete the given key.
     *time complexity is O(h)
     *h is the height of tree
     *
     * @param   tempRoot  The temporary root
     * @param   key  the key which is to be deleted
     *
     * @return root of the tree after delete operation.
     */
    private Node delete(Node tempRoot, Book key) {
        if (tempRoot == null) {
            return null;
        }
        int cmp = key.getBook().compareTo(
                      tempRoot.key.getBook());
        if (cmp < 0) {
            tempRoot.left = delete(tempRoot.left, key);
        } else if (cmp > 0) {
            tempRoot.right = delete(tempRoot.right, key);
        } else {
            if (tempRoot.right == null) {
                return tempRoot.left;
            } else if (tempRoot.left == null) {
                return tempRoot.right;
            }
            Node temp = tempRoot;
            tempRoot = min(tempRoot.right);
            tempRoot.right = deleteMin(temp.right);
            tempRoot.left = temp.left;
        }
        tempRoot.size = 1 + size(tempRoot.right)
                        + size(tempRoot.left);
        return tempRoot;
    }
}
/**
 *the class is for main method.
 */
final class Solution {
    /**
     *an empty constructor.
     */
    private Solution() {
    }
    /**
     *main method is for
     *reading input.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        final int three = 3;
        final int four = 4;
        BST<Book, Integer> object =
            new BST<Book, Integer>();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
            case"put":
                Book obj = new Book(
                    tokens[1], tokens[2], tokens[three]);
                object.put(obj, Integer.parseInt(
                               tokens[four]));
                break;
            case "get":
                Book getObj = new Book(
                    tokens[1], tokens[2], tokens[three]);
                System.out.println(object.get(getObj));
                break;
            case "max":
                System.out.println(object.max());
                break;
            case "min":
                System.out.println(object.min());
                break;
            case "select":
                System.out.println(
                    object.select(Integer.parseInt(tokens[1])));
                break;
            case "floor":
                Book floorObj = new Book(
                    tokens[1], tokens[2], tokens[three]);
                System.out.println(object.floor(floorObj));
                break;
            case "ceiling":
                Book ceilObj = new Book(
                    tokens[1], tokens[2], tokens[three]);
                System.out.println(object.ceiling(ceilObj));
            case "delete":
                Book delObj = new Book(
                    tokens[1], tokens[2], tokens[three]);
                object.delete(delObj);
                break;
            case "deleteMin":
                object.deleteMin();
                break;
            case "deleteMax":
                object.deleteMax();
                break;
            default: break;
            }
        }
    }
}
