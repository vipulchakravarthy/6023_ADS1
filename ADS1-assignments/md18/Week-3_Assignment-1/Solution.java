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
class Solution{
	Solution(){
	}
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int range = scan.nextInt();
		BinarySearchST<String, Integer> maxST = new BinarySearchST<String, Integer>();
		BinarySearchST<String, Integer> minST = new BinarySearchST<String, Integer>();
		Company stockObj;
		int hours = 6;
		scan.nextLine();
		for (int i = 0; i < hours; i++){
		MaxPQ<Company> maxObj = new MaxPQ<Company>(); ;
		MinPQ<Company> minObj =  new MinPQ<Company>();
			for (int  j = 0; j < range; j++){
				String[] tokens = scan.nextLine().split(",");
				stockObj = new Company(tokens[0], tokens[1]);
				maxObj.insert(stockObj);
				minObj.insert(stockObj);
			}
			for(int k = 0; k < 5; k++){
				Company obj = maxObj.delMax();
				if(maxST.contains(obj.getName())){
					int value = maxST.get(obj.getName());
					maxST.put(obj.getName(), ++value);
				} else {
					maxST.put(obj.getName(), 1);
				}
				System.out.println(obj.getName() + " " + obj.getCent());
			}
			System.out.println();
		for(int l = 0; l < 5; l++){
			Company object = minObj.delMin();
			if(minST.contains(object.getName())){
				int valueMin = minST.get(object.getName());
				minST.put(object.getName(), ++valueMin);
			} else {
				minST.put(object.getName(), 1);
			}
			System.out.println(object.getName() + " " + object.getCent());
		}
		System.out.println();
		}
		int queries = scan.nextInt();
		while(queries > 0) {
			String[] tokens = scan.nextLine().split(",");
			switch(tokens[0]){
				case "get":
					String type = tokens[1];
					String name = tokens[2];
					if(type.equals("maxST")){
						if(!(maxST.contains(name))) {
							System.out.println("0");
						} else {
						System.out.println(maxST.get(name));
						}
					} else if(type.equals("minST")){
						if(!(minST.contains(name))) {
							System.out.println("0");
						} else {
						System.out.println(minST.get(name));
						}
						break;
			}
			}
			queries--;
		}
	}
}
