import java.util.Scanner;
import java.lang.Comparable;
class MinHeap<K extends Comparable<K>>{
	MinHeap(){
	}
	public void isMinHeap(K[] array) {
		int last = array.length - 1;
		while (last > 1) {
			if (array[last].compareTo(array[last / 2]) >= 0) {
				last--;
			} else {
				System.out.println("false");
				return;
			}
		}
		System.out.println("true");
	}
}
class Solution{
	Solution(){
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		int inputs = Integer.parseInt(scan.nextLine());
		switch(str){
				case "String":
				for (int i = 0; i < inputs; i++) {
					String line = scan.nextLine();
					String[] tokens = line.split(",");
					String[] strArray = new String[tokens.length + 1];
					for(int j = 0; j < strArray.length - 1; j++) {
						strArray[j + 1] = tokens[j];
					}
					MinHeap<String> obj = new MinHeap<String>();
					obj.isMinHeap(strArray);
				}
				break;
				case "Integer":
				for (int i = 0; i < inputs; i++) {
					String line = scan.nextLine();
					String[] tokens = line.split(",");
					Integer[] intArray = new Integer[tokens.length + 1];
					for(int j = 0; j < intArray.length - 1; j++) {
						intArray[j + 1] = Integer.parseInt(tokens[j]);
					}
					MinHeap<Integer> obj = new MinHeap<Integer>();
					obj.isMinHeap(intArray);
				}
				break;
				case "Double":
				for (int i = 0; i < inputs; i++) {
					String line = scan.nextLine();
					String[] tokens = line.split(",");
					Double[] doubleArray = new Double[tokens.length + 1];
					for(int j = 0; j < doubleArray.length - 1;j++) {
						doubleArray[j + 1] = Double.parseDouble(tokens[j]);
					}
					MinHeap<Double> obj = new MinHeap<Double>();
					obj.isMinHeap(doubleArray);
				}
					break;
			    case "Float":
					for (int i = 0; i < inputs; i++) {
					String line = scan.nextLine();
					if(line.length() == 0) {
						System.out.println("false");
						break;
					}
					String[] tokens = line.split(",");
					Float[] floatArray = new Float[tokens.length + 1];
					for(int j = 0; j < floatArray.length - 1; j++) {
						floatArray[j + 1] = Float.parseFloat(tokens[j]);
					}
					MinHeap<Float> obj = new MinHeap<Float>();
					obj.isMinHeap(floatArray);
				}
				break;
				default: break;
			}
		}
	}
