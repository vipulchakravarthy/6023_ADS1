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
			if (this.getName().compareTo(that.getName()) == 1){
				return -1;
			}else if (this.getName().compareTo(that.getName()) == -1){
				return 1;
			}
		return 0;
	}
}
}
class Stocks{
	MaxPQ<Company> maxObj;
	MinPQ<Company> minObj;
	Stocks(){
		maxObj = new MaxPQ<Company>();
		minObj = new MinPQ<Company>();
	}
	public void put(Company obj){
		maxObj.insert(obj);
		minObj.insert(obj);
	}
	public void print(){
		for(int i = 0; i < 5; i++){
			Company obj = maxObj.delMax();
			System.out.println(obj.getName() + " " + obj.getCent());
		}
		System.out.println();
		for(int i = 0; i < 5; i++){
			Company object = minObj.delMin();
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
		int queries = scan.nextInt();
	}
}
