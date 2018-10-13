import java.util.Scanner;
import java.util.ArrayList;
class Company{
	private String name;
	private double percent;
	Company(){
	}
	Company(String name, String percent){
		this.name = name;
		this.percent = Double.parseDouble(percent);
	}
	public String getName(){
		return this.name;
	}
	public double getCent(){
		return this.percent;
	}
}
class StockOrder{
	MaxPQ<Double> maxObj;
	MinPQ<Double> minObj;
	ArrayList<Company> list;
	StockOrder(){
		maxObj = new MaxPQ<Double>();
		minObj = new MinPQ<Double>();
		list = new ArrayList<Company>();
	}
	public void put(Company object){
		list.add(object);
		maxObj.insert(object.getCent());
		minObj.insert(object.getCent());
	}
	public void print(){
		for(int j = 0; j < 5; j++){
			Double temp = maxObj.delMax();
			String name = "";
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getCent() == temp){
					name = list.get(i).getName();
					list.remove(i);
					break;
				}
			}
			System.out.println(name +" " + temp);
		}
		System.out.println();
		for(int j = 0; j < 5; j++){
			Double tempMin = minObj.delMin();
			String nameMin = "";
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getCent() == tempMin){
					nameMin = list.get(i).getName();
					list.remove(i);
					break;
				}
			}
			System.out.println(nameMin +" " + tempMin);
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
		Company comDetails;
		int range = scan.nextInt();
		int hours = 6;
		scan.nextLine();
		while(hours > 0){
			for(int i = 0; i < range; i++) {
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				comDetails = new Company(tokens[0], tokens[1]);
				obj.put(comDetails);
			}
			obj.print();
			hours--;
		}
		int queries = scan.nextInt();
	}
}
