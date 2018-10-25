import java.util.Scanner;
class RansomNote{
	SeparateChainingHashST<String, Integer> hashObj;
	RansomNote(){
		hashObj = new SeparateChainingHashST<String, Integer>();
	}
	public void addTo(String item){
		if(hashObj.contains(item)) {
			hashObj.put(item, hashObj.get(item)  + 1);
		} else{
			hashObj.put(item, 1);
		}
	}
	public String check(String[] array){
		for(int i = 0; i < array.length; i++){
			if(!hashObj.contains(array[i])) {
				return "No";
			}
			int counter = hashObj.get(array[i]) - 1;
			if(counter == 0){
				hashObj.delete(array[i]);
			}else{
				hashObj.put(array[i],counter);
			}
		}
		return "Yes";
	}


}
class Solution{
	Solution(){
	}
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int magCount = scan.nextInt();
		int ransomCount = scan.nextInt();
		String[] ransomWords = new String[ransomCount];
		RansomNote obj = new RansomNote();
		for(int i = 0; i < magCount; i++){
			String variable = scan.next();
			obj.addTo(variable);
		}
		for(int i = 0; i < ransomCount; i++){
			ransomWords[i] = scan.next();
		}
		System.out.println(obj.check(ransomWords));
	}
}
