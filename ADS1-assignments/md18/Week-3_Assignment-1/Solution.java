import java.util.Scanner;
class Company implements Comparable<Company>{
	String companyName;
	Double percent;
	Company(String name, String cent){
		this.companyName = name;
		this.percent = Double.parseDouble(cent);
	}
	public String getName(){
		return this.companyName;

	}
	public Double getCent(){
		return this.percent;
	}
	public int compareTo(Company that){
		if(this.getCent() < that.getCent()){
			return -1;
		} else if(this.getCent() > that.getCent()) {
			return 1;
		} else {
			if (this.getName().compareTo(that.getName()) > 0){
				return 1;
			}else if (this.getName().compareTo(that.getName()) < 0){
				return -1;
			}
		return 0;
	}
}
}
class Stocks{
	MaxPQ<Company> maxObj;
	MinPQ<Company> minObj;
	BinarySearchST<String, Integer> maxST;
	BinarySearchST<String, Integer> minST;
	Stocks(){
		maxObj = new MaxPQ<Company>();
		minObj = new MinPQ<Company>();
		maxST = new BinarySearchST<String, Integer>();
		minST = new BinarySearchST<String, Integer>();
	}
	public void put(Company obj){
		maxObj.insert(obj);
		minObj.insert(obj);
	}
	public void getFreq(String type, String name){
		if(type.equals("maxST")){
			System.out.println(maxST.get(name));
		} else if(type.equals("minST")){
			System.out.println(minST.get(name));
		}
	}
	public void print(){
		for(int i = 0; i < 5; i++){
			Company obj = maxObj.delMax();
			System.out.println(obj.getName() + " " + obj.getCent());
			if(!(maxST.contains(obj.getName()))){
				maxST.put(obj.getName(), 1);
			} else {
				maxST.put(obj.getName(), maxST.get(obj.getName()) + 1);
			}
		}
		System.out.println();
		for(int i = 0; i < 5; i++){
			Company object = minObj.delMin();
			if(!(minST.contains(object.getName()))){
				minST.put(object.getName(), 1);
			} else {
				minST.put(object.getName(), minST.get(object.getName()) + 1);
			}
			System.out.println(object.getName() + " " + object.getCent());
		}
		System.out.println();
		}
}
class Solution{
	Solution(){
	}
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int range = scan.nextInt();
		Stocks stocks = new Stocks();
		Company obj;
		int hours = 6;
		scan.nextLine();
		while(hours > 0){
			Stocks stockObj = new Stocks();
			for (int  i = 0; i < range; i++){
				String[] tokens = scan.nextLine().split(",");
				obj = new Company(tokens[0], tokens[1]);
				stockObj.put(obj);
			}
			stockObj.print();
			hours--;
		}
		System.out.println();
		int queries = scan.nextInt();
		while(queries > 0) {
			String[] tokens = scan.nextLine().split(",");
			switch(tokens[0]){
				case "get":
					stocks.getFreq(tokens[1], tokens[2]);
					break;
				case "intersection":
					break;
				default: break;
			}
			queries--;
		}
	}
}
