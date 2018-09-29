import java.util.Scanner;
class AddLargeNumbers {

    public static LinkedList numberToDigits(String number) {
    	LinkedList obj = new LinkedList();
    	String[] tokens = number.split("", number.length());
    	for (int i = 0; i < tokens.length; i++) {
    		obj.insertEnd(Integer.parseInt(tokens[i]));
    	}
    	System.out.println(obj.print());
       	return obj;
    }

    public static String digitsToNumber(LinkedList list) {
    	LinkedList obj = new LinkedList();
    	String str = "";
    	while (obj.size != 0) {
    		str += obj.deleteStart();
    	}
    	return str;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
    	return null;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }

}
