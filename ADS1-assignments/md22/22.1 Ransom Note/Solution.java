import java.util.Scanner;
/**
 *the class for ransomNote
 */
class RansomNote{
	/**
	 *the hashObj is for building a symbol table.
	 *
	 */
	SeparateChainingHashST<String, Integer> hashObj;
	/**
	 *the constructor is to initialize the.
	 *hash table object.
	 */
	RansomNote(){
		hashObj = new SeparateChainingHashST<String,
		 Integer>();
	}
	/**
	 *the method is to put the element into.
	 *hashTable
	 *time complexity is O(logN)
	 *
	 * @param      item  The item
	 */
	public void addTo(final String item){
		if(hashObj.contains(item)) {
			hashObj.put(item, hashObj.get(item)  + 1);
		} else{
			hashObj.put(item, 1);
		}
	}
	public String check(final String word){
			if(!hashObj.contains(word)) {
				return "N";
			}
			int counter = hashObj.get(word) - 1;
			if(counter == 0){
				hashObj.delete(word);
			}else{
				hashObj.put(word,counter);
			}
			return "Y";
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
		int flag = 0;
		for(int i = 0; i < ransomCount; i++){
			String result = obj.check(scan.next());
			if(result == "N"){
				System.out.println("No");
				flag = 1;
				break;
			}
		}
		if(flag == 0) {
		System.out.println("Yes");
		}
}
}
