import java.util.Scanner;
class StockOrder{
	BST<Double, String> bstMaxObj;
	BST<Double, String> bstMinObj;
	StockOrder(){
		bstMaxObj = new BST<Double, String>();
		bstMinObj = new BST<Double, String>();
	}
	public void put(String name, String percent){
		bstMaxObj.put(Double.parseDouble(percent), name);
		bstMinObj.put(Double.parseDouble(percent), name);
	}
	public void print(){
		for (int i = 0; i < 5; i++) {
			Double tempMax = bstMaxObj.max();
			String nameMax = bstMaxObj.get(tempMax);
			bstMaxObj.deleteMax();
			System.out.println(nameMax + " "+ tempMax);
		}
		System.out.println();
		for (int i = 0; i < 5; i++) {
			Double tempMin = bstMinObj.min();
			String nameMin = bstMinObj.get(tempMin);
			bstMinObj.deleteMin();
			System.out.println(nameMin + " "+ tempMin);
		}
		System.out.println();
	}

}
class Solution{
	Solution(){
	}
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		StockOrder obj = new StockOrder();
		int range = scan.nextInt();
		int hours = 6;
		scan.nextLine();
		while(hours > 0){
			for(int i = 0; i < range; i++) {
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				obj.put(tokens[0], tokens[1]);
			}
			obj.print();
			hours--;
		}
		int queries = scan.nextInt();
	}
}
