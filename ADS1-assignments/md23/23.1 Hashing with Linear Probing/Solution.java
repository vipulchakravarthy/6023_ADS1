import java.util.Scanner;
import java.io.File;
class LinearProbing<Key, Value> {
	/**
	 *the variable for initial capacity.
	 */
	private static final  int capacity = 4;
	/**
	 *the array for storing keys.
	 */
	private Key[] keys;
	/**
	 *the array for storing values.
	 */
	private Value[] values;
	/**
	 *number of key-value pairs in table.
	 */
	private int keyValuePairs;
	/**
	 *size of the table.
	 */
	private int length;
	/**
	 *constructor to initialize the array.
	 *length.
	 */
	public LinearProbing() {
		this(capacity);
	}
	/**
	 *another constructor to initialize all.
	 * keys array and value array
	 * @param      capacity  The capacity
	 */
	LinearProbing(final int capacity) {
		length = capacity;
		keyValuePairs = 0;
		keys = (Key[]) new Object[length];
		values = (Value[]) new Object[length];
	}
	/**
	 *this method returns the hash value.
	 * @param      key   The key
	 *
	 * @return hash value of particular key.
	 */
	private int hash(final Key key) {
		return ((11 * key.hashCode()) % length);
	}
	/**
	 *this returns whether the key is present.
	 *in hash table or not.
	 * @param      key  to be checked.
	 *
	 * @return  whether the key is present
	 * or not.
	 */
	public boolean contains(final Key key) {
		return get(key) != null;
	}
	/**
	 *this method resizes the array.
	 *whenever the array is half filled the  we.
	 *double the array size. and whenever the
	 *array is just 12.5% filled then we reduce
	 *the size of array.
	 * @param     capacity  The capacity
	 */
	public void resize(final int capacity) {
		LinearProbing<Key, Value> temp
		    = new LinearProbing<Key, Value>(capacity);
		for (int i = 0; i < length; i++) {
			if (keys[i] != null) {
				temp.put(keys[i], values[i]);
			}
		}
		keys = temp.keys;
		values = temp.values;
		length = temp.length;
	}
	/**
	 *this method is to put the
	 * element in table.
	 * time complexity is O(N)
	 *
	 * @param   key    The key
	 * @param   value  The value
	 */
	public void put(final Key key, final Value value) {
		if (keyValuePairs >= (length / 2)) {
			resize(2 * length);
		}
		int i;
		for (i = hash(key); keys[i] != null; i = (i + 1) % length) {
			if (keys[i].equals(key)) {
				values[i] = value;
				return;
			}
		}
		keys[i] = key;
		values[i] = value;
		keyValuePairs++;
	}
	/**
	 *the method is to search for the key.
	 *time complexity is O(N)
	 * @param      key   The key
	 *
	 * @return it returns the value of
	 * particular key.
	 */
	public Value get(final Key key) {
		int i;
		for (i = hash(key); keys[i] != null; i = (i + 1) % length) {
			if (keys[i].equals(key)) {
				return values[i];
			}
		}
		return null;
	}
	/**
	 *the method is to delete the key
	 *from the table.
	 *time complexity is O(N)
	 * @param      key   The key
	 */
	public void delete(final Key key) {
		if (!contains(key)) return;
		int i;
		for (i = hash(key); !keys[i].equals(key); i = (i + 1) % length) {
		}
		keys[i] = null;
		values[i] = null;
		i = (i + 1) % length;
		while (keys[i] != null) {
			Key tempKey = keys[i];
			Value tempValue = values[i];
			keyValuePairs--;
			keys[i] = null;
			values[i] = null;
			put(tempKey, tempValue);
			i = (i + 1) % length;
		}
		keyValuePairs--;
		if (keyValuePairs >= 0 && keyValuePairs <= length / 8) {
			resize(length / 2);
		}
	}
	/**
	 *method is to add the key- value pair to the.
	 *queue to print the elements.
	 * @return  queue which is filled with key-value.
	 */
	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<Key>();
		for (int i = 0; i < length; i++) {
			if (keys[i] != null) {
				queue.enqueue(keys[i]);
			}
		}
		return queue;
	}
	/**
	 *this method is to give all key value pairs.
	 *time complexity is O(N)
	 */
	public void display() {
		String str = "{";
		if (keyValuePairs == 0) {
			System.out.println("{}");
			return;
		}
		for (Key key : keys()) {
			str += key + ":" + get(key) + ", ";
		}
		String strOne = str.substring(0, str.length() - 2) + "}";
		System.out.println(strOne);
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
	 *the main method to take input.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		LinearProbing<String, Integer> object
		    = new LinearProbing<String, Integer>();
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			switch (tokens[0]) {
			case "put":
				object.put(tokens[1], Integer.parseInt(tokens[2]));
				break;
			case "get":
				System.out.println(object.get(tokens[1]));
				break;
			case "delete":
				object.delete(tokens[1]);
				break;
			case "display":
				object.display();
				break;
			default: break;
			}
		}
	}
}
