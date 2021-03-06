import java.util.Scanner;
/**
 * the class to do addition of.
 * two large number.
 */
final class AddLargeNumbers {
    /**
     * object for linked list class.
     */
    private static LinkedList obj;
    /**
     * object for linkedlist class.
     */
    private static LinkedList stack;
    /**
     * an empty constructor.
     */
    private AddLargeNumbers() {
    }
    /**
     * the method to convert the.
     *string into linked list
     * @param number number given
     *
     * @return linked list
     */
    public static LinkedList numberToDigits(final String number) {
        obj = new LinkedList();
        String[] tokens = number.split("", number.length());
        for (int i = 0; i < tokens.length; i++) {
            obj.insertEnd(Integer.parseInt(tokens[i]));
        }
        return obj;
    }
    /**
     * the method is to convert.
     * digits to number
     * @param  list  The list
     *
     * @return  str String which contains number
     */
    public static String digitsToNumber(
        final LinkedList list) {
        String str = "";
        while (list.size != 0) {
            str += list.deleteStart();
        }
        return str;
    }
    /**
     * the method is to perform.
     *addition of two large numbers
     * @param   list1  The list 1
     * @param   list2  The list 2
     *
     * @return   stack after sum of two
     * numbers.
     */
    public static LinkedList addLargeNumbers(
        final LinkedList list1, final LinkedList list2) {
        stack = new LinkedList();
        final int ten = 10;
        int temp = 0;
        int temp1 = 0;
        int temp2 = 0;
        int diff = 0;
        if (list1.size > list2.size) {
            diff = list1.size - list2.size;
            for (int i = 0; i < diff; i++) {
                list2.insertStart(0);
            }
        }
        if (list2.size > list1.size) {
            diff = list2.size - list1.size;
            for (int i = 0; i < diff; i++) {
                list1.insertStart(0);
            }
        }
        while (list1.size != 0 && list2.size != 0) {
               temp = list1.deleteEnd()
                       + list2.deleteEnd() + temp1;
                if (temp < ten) {
                    stack.insertStart(temp);
                    temp1 = 0;
                } else {
                    temp2 = temp % ten;
                    stack.insertStart(temp2);
                    temp = temp / ten;
                    temp1 = temp;
                }
            }
            if (temp1 > 0) {
            stack.insertStart(temp1);
            }
        return stack;
    }
}
/**
 * the class for main method.
 */
public final class Solution {
    /**
     * an empty constructor.
     */
    private Solution() {
    }
    /**
     * the main to perform operation.
     *
     * @param  args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers
                                 .numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers
                                 .numberToDigits(q);
            System.out.println(
                AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(
                AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedList result = AddLargeNumbers
                                .addLargeNumbers(pDigits, qDigits);
            System.out.println(
                AddLargeNumbers.digitsToNumber(result));
            break;
        default : break;
        }
    }
}

