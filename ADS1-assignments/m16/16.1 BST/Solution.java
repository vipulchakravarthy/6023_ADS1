import java.util.Scanner;

class Book implements Comparable<Book>{
	String bookName;
	String authorName;
	String bookPrice;
	int quantity;
	Book(String name, String author, String price){
		 this.bookName = name;
		 this.authorName = author;
		 this.bookPrice = price;
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
	public int compareTo(Book that){
		return -1;
	}
}
class BinarySearchT<T extends Comparable<T>, Value>{
		 class Node{
		 Book key;
		 Value value;
		Node left;
		 Node right;
		public Node(Book key, Value value){
			this.key = key;
			this.value = value;
		}
	}
	private Node root;
	BinarySearchT(){
		root = null;
	}
	public void put(Book key, Value value){
		root = put(root, key, value);
	}
	private Node put(Node temp, Book key, Value value){
		if(temp == null) {
			return new Node(key, value);

		}
		int comp = key.getBook().compareTo(temp.key.getBook());
		if(comp < 0) {
			temp.left = put(temp.left, key, value);
		} else if(comp > 0) {
			temp.right = put(temp.right, key, value);
		} else if(comp == 0) {
			temp.value = value;
		}
		return temp;
	}
	public Value get(Book key) {
		Node temp = root;
		while(temp != null) {
			int comp = key.getBook().compareTo(temp.key.getBook());
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
		BinarySearchT<Book, Integer> object = new BinarySearchT<Book, Integer>();
		while(scan.hasNext()){
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			switch(tokens[0]) {
				case "put":
					Book obj = new Book(tokens[1],
					 tokens[2], tokens[3]);
					object.put(obj, Integer.parseInt(tokens[4]));
					break;
				case "get":
					Book getObj = new Book(tokens[1],
						tokens[2], tokens[3]);
					System.out.println(object.get(getObj));
					break;
				default: break;
			}
		}
	}
}
