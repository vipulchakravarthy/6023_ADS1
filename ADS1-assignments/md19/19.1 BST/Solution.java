import java.util.Scanner;
class Book implements Comparable<Book>{
	private String bookName;
	private String authorName;
	private double price;
	Book(final String book,
	 final String author, final String cost){
		bookName = book;
		authorName = author;
		price = Double.parseDouble(cost);
	}
	public String getBook(){
		return this.bookName;
	}
	public int compareTo(Book that){
		return -1;
	}
	public String toString(){
		return this.bookName + ", " + this.authorName
		+ ", " + this.price;
	}
}
class BST<Key extends Comparable<Key>, Value> {
	private Node root;
	private class Node{
		private Node left;
		private Node right;
		private Book key;
		private Value value;
		private int size;
		public Node(Book keys, Value val, int length){
			key = keys;
			value = val;
			size = length;
		}
	}
	BST(){
	}
	public int size(){
		return size(root);
	}
	private int size(Node tempRoot){
		if(tempRoot == null){
		 return 0;
		}
		return tempRoot.size;
	}
	public void put(Book key, Value value){
		root = put(root,key, value);
	}
	private Node put(Node tempRoot, Book key, Value value) {
		if(tempRoot == null){
			return new Node(key, value, 1);
		}
		int cmp = key.getBook().compareTo(tempRoot.key.getBook());
		if(cmp < 0){
		  tempRoot.left = put(tempRoot.left, key, value);
		} else if(cmp > 0){
			tempRoot.right = put(tempRoot.right, key, value);
		} else{
			tempRoot.value = value;
		}
	    tempRoot.size = 1+ size(tempRoot.left) + size(tempRoot.right);
	    return tempRoot;
	}
	public Value get(Book key){
		return get(root, key);
	}
    // Node temp = root;
    //     while (temp != null) {
    //         int comp = key.getBook().compareTo(
    //             temp.key.getBook());
    //         if (comp < 0) {
    //             temp = temp.left;
    //         } else if (comp > 0) {
    //             temp = temp.right;
    //         } else if (comp == 0) {
    //             return temp.value;
    //         }
    //     }
    //     return null;
    // }
	private Value get(Node tempRoot, Book key) {
		if(tempRoot == null) {
			return null;
		}
		int cmp = key.getBook().compareTo(tempRoot.key.getBook());
		if(cmp < 0){
			return get(tempRoot.left, key);
		} else if(cmp > 0){
			return get(tempRoot.right, key);
		} else {
			return tempRoot.value;
		}
	}
	public Book min(){
		return min(root).key;
	}
	private Node min(Node tempRoot){
		if(tempRoot.left == null) {
			return tempRoot;
		} else {
		return	min(tempRoot.left);
		}
	}
	public Book max(){
		return max(root).key;
	}
	private Node max(Node tempRoot){
		if(tempRoot.right == null) {
			return tempRoot;
		} else {
			return max(tempRoot.right);
		}
	}
	public Book floor(Book key){
		Node floorKey = floor(root,key);
		if(floorKey == null){
			return null;
		}
		return floorKey.key;
	}
	private Node floor(Node tempRoot, Book key){
		if(tempRoot == null) {
			return null;
		}
		int cmp = key.getBook().compareTo(
			tempRoot.key.getBook());
		if(cmp == 0){
			return tempRoot;
		} else if(cmp < 0){
			return floor(tempRoot.left,key);
		}
		Node temp = floor(tempRoot.right, key);
		if(temp != null) {
			return temp;
		} else{
			return tempRoot;
		}
	}
	public Book ceiling(Book key){
		Node ceilKey = ceiling(root, key);
		if(ceilKey == null) {
			return null;
		}
		return ceilKey.key;
	}
	private Node ceiling(Node tempRoot, Book key){
		if(tempRoot == null) {
			return null;
		}
		int cmp = key.getBook().compareTo(
			tempRoot.key.getBook());
		if(cmp == 0){
			return tempRoot;
		} else if(cmp < 0){
			Node temp = ceiling(tempRoot.left,key);
			if(temp != null) {
				return temp;
			} else{
				return tempRoot;
			}
		}
		return ceiling(tempRoot.right,key);
	}
	public Book select(int index){
		Node temp = select(root,index);
		return temp.key;
	}
	private Node select(Node tempRoot, int index){
		if(tempRoot == null){
			return null;
		}
		int length = size(tempRoot.left);
		if(length > index){
			return select(tempRoot.left,index);
		} else if(length < index){
			return select(tempRoot.right, index - length - 1);
		} else {
			return tempRoot;
		}
	}

}
final class Solution{
	Solution(){
	}
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		BST<Book, Integer> object =
			new BST<Book, Integer>();
		while(scan.hasNext()){
			String[] tokens = scan.nextLine().split(",");
			switch(tokens[0]){
				case"put":
					Book obj = new Book(tokens[1], tokens[2], tokens[3]);
					object.put(obj, Integer.parseInt(tokens[4]));
					break;
				case "get":
					Book getObj = new Book(tokens[1], tokens[2], tokens[3]);
					System.out.println(object.get(getObj));
					break;
				case "max":
					System.out.println(object.max());
					break;
				case "min":
					System.out.println(object.min());
					break;
				case "select":
					System.out.println(object.select(
						Integer.parseInt(tokens[1])));
					break;
				case "floor":
					Book floorObj = new Book(tokens[1], tokens[2], tokens[3]);
					System.out.println(object.floor(floorObj));
					break;
				case "ceiling":
					Book ceilObj = new Book(tokens[1], tokens[2], tokens[3]);
					System.out.println(object.ceiling(ceilObj));
					break;
				default: break;
			}
		}
	}
}
