import java.util.Scanner;

class Book{
	String bookName;
	String authorName;
	String bookPrice;
	int quantity;
	Book(String name, String author, String price, String value){
		 this.bookName = name;
		 this.authorName = author;
		 this.bookPrice = price;
		 this.quantity = Integer.parseInt(value);
	}
	public String getBook(){
		return bookName;
	}
	public String getAuthor(){
		return authorName;
	}
	public String getPrice(){
		return bookPrice;
	}
	public int quantity(){
		return quantity;
	}
}
class BinarySearchT<Key extends Comparable<Key>, Value>{
		 class Node{
		 Key key;
		 Value value;
		Node left;
		 Node right;
		public Node(Key key, Value value){
			this.key = key;
			this.value = value;
		}
	}
	private Node root;
	BinarySearchT(){
		root = null;
	}

	public void put(Key key, Value value){

		root = put(root, key, value);

	}
	private Node put(Node temp, Key key, Value value){
		// System.out.println(key.toString() +""+ value.toString()+""+root);
		if(temp == null) {
			return new Node(key, value);

		}
		int comp = key.compareTo(temp.key);
		if(comp < 0) {
			temp.left = put(temp.left, key, value);
		} else if(comp > 0) {
			temp.right = put(temp.right, key, value);
		} else if(comp == 0) {
			temp.value = value;
		}
		return temp;
	}
	public Value get(Key key) {
		Node temp = root;
		while(temp != null) {
			int comp = key.compareTo(temp.key);
			if(comp < 0) {
				temp = temp.left;
			} else if(comp > 0) {
				temp = temp.right;
			} else if (comp == 0) {
				return temp.value;
			}
		}
		return null;
	}
}
class Solution{
	Solution(){
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BinarySearchT<String, Integer> object = new BinarySearchT<String, Integer>();
		while(scan.hasNext()){
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			switch(tokens[0]) {
				case "put":
					Book obj = new Book(tokens[1],
					 tokens[2], tokens[3], tokens[4]);
					object.put(tokens[1], Integer.parseInt(tokens[4]));
					break;
				case "get":
					System.out.println(object.get(tokens[1]));
					break;
				default: break;
			}
		}
	}
}
