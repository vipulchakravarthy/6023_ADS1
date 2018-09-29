import java.util.Scanner;
class AddLargeNumbers {
    static LinkedList obj;
    public static LinkedList numberToDigits(final String number) {
    	obj = new LinkedList();
    	String[] tokens = number.split("", number.length());
    	for (int i = 0; i < tokens.length; i++) {
    		obj.insertEnd(Integer.parseInt(tokens[i]));
    	}
       	return obj;
    }
    public static String digitsToNumber(final LinkedList list) {
    	String str = "";
    	while (list.size != 0) {
    		str += list.deleteStart();
    	}
    	return str;
    }
    public static LinkedList addLargeNumbers(final LinkedList list1, final LinkedList list2) {
    	obj = new LinkedList();
    	int sum = 0;
    	while (list1.size != 0 && list2.size != 0) {
    		int temp = list1.deleteEnd() + list2.deleteEnd();
    		obj.insertStart(temp);
    	}
    	return obj;
    }
}

public class Solution {
    public static void main(final String[] args) {
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
