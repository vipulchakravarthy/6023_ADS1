import java.util.Scanner;
class BinarySearchST<Key extends Comparable<Key>, Value>{
	private Key[] keys;
	private Value[] values;
	private int size;
	private final int capacity = 1;
	BinarySearchST(){
		keys = (Key[]) new Comparable[2];
		values = (Value[]) new Object[2];
		size = 0;
	}
	private void resize(int capacity) {
        assert capacity >= size;
        Key[]   tempKey = (Key[])   new Comparable[capacity];
        Value[] tempValue = (Value[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            tempKey[i] = keys[i];
            tempValue[i] = values[i];
        }
        values = tempValue;
        keys = tempKey;
	}
	public int size() {
		return size;
	}
    public Value get(Key key) {
        int rank = rank(key);
        if (rank < size && (keys[rank].compareTo(key) == 0)){
        	 return values[rank];
        }
        return null;
    }
	public void put(Key key, Value value) {
		if(value == null) {
			delete(key);
			return;
		}
		int rank = rank(key);
        if (rank < size && keys[rank].compareTo(key) == 0) {
            values[rank] = value;
            return;
        }
		if(size == keys.length) {
			resize(2 * keys.length);
		}
		for (int j = size; j > rank; j--) {
			keys[j] = keys[j - 1];
			values[j] = values[j - 1];
		}
		keys[rank] = key;
		values[rank] = value;
		size++;
	}
	public int rank(Key key){
		int low = 0;
		int high = size - 1;
		while(low <= high) {
			int mid = low + (high - low) / 2;
			int comp = key.compareTo(keys[mid]);
			if (comp < 0){
				high = mid - 1;
			} else if(comp > 0){
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return low;
	}
	public Key max(){
		if(isEmpty()) {
		}
		return keys[size - 1];
	}
	public Key min(){
		return keys[0];
	}
	public Key floor(Key key){
		int rank = rank(key);
		if(rank == 0) {
			return null;
		}
		if(rank < size && key.compareTo(keys[rank]) == 0) {
			return keys[rank];
		} else {
			return keys[rank - 1];
		}
	}
	public void deleteMin(){
		delete(min());
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public boolean contains(Key key){
		return get(key) != null;
	}
	public void delete(Key key) {
		int rank = rank(key);
		if( rank == size || (keys[rank].compareTo(key) != 0)) {
			return;
		}
		for(int j = rank; j < size - 1; j++) {
			keys[j] = keys[j + 1];
			values[j] = values[j + 1];
		}
		size--;
		keys[size] = null;
		values[size] = null;
		if (size > 0 && size == keys.length/4) {
			resize(keys.length/2);
		}
	}
	public void keys(){
		for(int i = 0; i < size; i++){
			System.out.println(keys[i] + " " + values[i]);
		}
	}
}
class Solution{
	Solution(){
	}
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		BinarySearchST<String, Integer> obj
		= new BinarySearchST<String, Integer>();
		String line = scan.nextLine();
		String[] tokens = line.split(" ");
		for(int i = 0; i < tokens.length; i++){
			obj.put(tokens[i], i);
		}
		while(scan.hasNext()){
			String inputs = scan.nextLine();
			String[] check = inputs.split(" ");
			switch(check[0]) {
				case "max":
					System.out.println(obj.max());
					break;
				case "floor":
					System.out.println(obj.floor(check[1]));
					break;
				case "rank":
					System.out.println(obj.rank(check[1]));
					break;
				case "deleteMin":
					obj.deleteMin();
					break;
				case "get":
					System.out.println(obj.get(check[1]));
					break;
				case "keys":
					obj.keys();
					break;
				case "contains":
					System.out.println(obj.contains(check[1]));
					break;
				default: break;
			}
		}
	}
}
