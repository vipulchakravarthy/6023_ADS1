import java.util.Arrays;
import java.util.ArrayList;
/**
 * the class is for performing
 * binarysearch symbol table.
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchST
<Key extends Comparable<Key>, Value> {
    /**
     * the keys array.
     */
    private Key[] keys;
    /**
     *the values array.
     */
    private Value[] values;
    /**
     *the size of the key value pair.
     */
    private int size;
    /**
     * this is the capacity of array.
     */
    private final int capacity = 1;
    /**
     *the constructor to initialize.
     */
    BinarySearchST() {
        keys = (Key[]) new Comparable[2];
        values = (Value[]) new Object[2];
        size = 0;
    }
    /**
     *the method is to resize the array.
     *when it is full.
     */
    private void resize() {
        keys = Arrays.copyOf(keys, size + 1);
        values = Arrays.copyOf(values, size + 1);
    }
    /**
     * it returns the size of array.
     *
     * @return  size
     */
    public int size() {
        return size;
    }
    public ArrayList<Key> getKeys() {
        ArrayList<Key> ar = new ArrayList<>(Arrays.asList(keys));
        return ar;
    }
    /**
     * this method gives the values.
     *of given key.
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Value get(final Key key) {
        int rank = rank(key);
        if (rank < size && (keys[rank].compareTo(key) == 0)) {
            return values[rank];
        }
        return null;
    }
    /**
     * this method is to insert the key and values.
     *
     * @param      key    The key to be inserted
     * @param      value  The value to be inserted
     * the time complexity is O(logN).
     * because it will check only upto value.
     */
    public void put(final Key key, final Value value) {
        if (value == null) {
            delete(key);
            return;
        }
        int rank = rank(key);
        if (rank < size && keys[rank].compareTo(key) == 0) {
            values[rank] = value;
            return;
        }
        if (size == keys.length) {
            resize();
        }
        for (int j = size; j > rank; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[rank] = key;
        values[rank] = value;
        size++;
    }
    /**
     * this gives the rank of the key.
     *
     * @param      key   The key
     *
     * @return rank of given key.
     * the time complexity is logN
     * it will not check through out.
     * the array. it will do binary search.
     */
    public int rank(final Key key) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comp = key.compareTo(keys[mid]);
            if (comp < 0) {
                high = mid - 1;
            } else if (comp > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
    /**
     *this method gives the max element.
     *
     * @return maximum element of array.
     */
    public Key max() {
        return keys[size - 1];
    }
    /**
     * this method gives the min element.
     *
     * @return  minimum element.
     */
    public Key min() {
        return keys[0];
    }
    /**
     *this method is give the floor value of.
     *key
     *the time complexity is logN.
     * @param      key   The key
     *
     * @return    floor value
     */
    public Key floor(final Key key) {
        int rank = rank(key);
        if (rank == 0) {
            return null;
        }
        if (rank < size && key.compareTo(keys[rank]) == 0) {
            return keys[rank];
        } else {
            return keys[rank - 1];
        }
    }
    /**
     *this method delete minimum element.
     *the time complexity is N.
     *in the worst case it iterates through out array.
     */
    public void deleteMin() {
        delete(min());
    }
    public void deleteMax() {
        delete(max());
    }
    /**
     * whether the array is empty or not.
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * whether the given key contains or not.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final Key key) {
        return get(key) != null;
    }
    /**
     * this method is to delete the element.
     *
     * @param      key   The key
     */
    public void delete(final Key key) {
        int rank = rank(key);
        if (rank == size || (keys[rank].compareTo(key) != 0)) {
            return;
        }
        for (int j = rank; j < size - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        size--;
        keys[size] = null;
        values[size] = null;
    }
    /**
     *this method is to print the all key - value.
     *pairs.
     *the time complexity is N.
     */
    public void keys() {
        for (int i = 0; i < size; i++) {
            System.out.println(keys[i] + " " + values[i]);
        }
    }
}
