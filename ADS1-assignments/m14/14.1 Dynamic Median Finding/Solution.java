import java.util.Arrays;
import java.util.Scanner;
class DynamicMedian{
	MinPQ<Double> minObj = new MinPQ<Double>();
	MaxPQ<Double> maxObj = new MaxPQ<Double>();
	DynamicMedian(){
	}
	public void insertAtMin(double item){
		minObj.insert(item);
	}
	public void insertAtMax(double item){
		maxObj.insert(item);
	}
	public double getMin(){
	return minObj.min();
	}
	public double getMax() {
		return maxObj.max();
	}
	public double delMax(){
		return maxObj.delMax();
	}
	public double delMin(){
		return minObj.delMin();
	}
	public int getMinSize(){
		return minObj.size();
	}
	public int getMaxSize(){
		return maxObj.size();
	}
}
class Solution{
	Solution() {
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DynamicMedian obj = new DynamicMedian();
		long inputs = scan.nextInt();
		double element = scan.nextDouble();
		obj.insertAtMin(element);
		double median = element;
		for(long i = 0; i < inputs; i++) {
			double input = scan.nextDouble();
			if (input > median) {
				obj.insertAtMin(input);
			} else if (input < median) {
				obj.insertAtMax(input);
			} else {
				obj.insertAtMin(input);
			}
			if (obj.getMinSize() - obj.getMaxSize() > 1) {
				obj.insertAtMax(obj.delMin());
			}
			if ( obj.getMaxSize()- obj.getMinSize()  > 1) {
				obj.insertAtMin(obj.delMax());
			}
			if (Math.abs(obj.getMinSize() - obj.getMaxSize()) == 1) {
				if ( obj.getMinSize() > obj.getMaxSize()) {
					median = obj.getMin();
					System.out.println(median);
				} else {
					median = obj.getMax();
					System.out.println(median);
				}
			}
			if (obj.getMinSize()  == obj.getMaxSize() ) {
				double min = obj.getMin();
				double max = obj.getMax();
				median = (min + max) / 2.0;
				System.out.println(median);
			}
		}
	}
}
