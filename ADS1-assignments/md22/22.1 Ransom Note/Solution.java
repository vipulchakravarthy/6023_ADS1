import java.util.Scanner;
/**
 *the class for ransomNote.
 */
class RansomNote {
    /**
     *the hashObj is for building a symbol table.
     *
     */
    private SeparateChainingHashST<String,
     Integer> hashObj;
    /**
     *the constructor is to initialize the.
     *hash table object.
     */
    RansomNote() {
        hashObj = new SeparateChainingHashST<String,
        Integer>();
    }
    /**
     *the method is to put the element into.
     *hashTable
     *time complexity is O(logN)
     *N is the number of elements to be inserted.
     * @param      item  The item to be inserted in table.
     */
    public void addTo(final String item) {
        if (hashObj.contains(item)) {
            hashObj.put(item, hashObj.get(item)  + 1);
        } else {
            hashObj.put(item, 1);
        }
    }
    /**
     *this method is to check whether.
     *the ransom note can be made from the
     *magazine words or not.
     *time complexity for this method is
     *O(logN)
     * @param      word one of the word in ransom
     *words.
     * @return String whether the word is there or
     * not. if it is there return Y.
     * or else N.
     */
    public String check(final String word) {
        if (!hashObj.contains(word)) {
            return "N";
        }
        int counter = hashObj.get(word) - 1;
        if (counter == 0) {
            hashObj.delete(word);
        } else {
            hashObj.put(word, counter);
        }
        return "Y";
    }
}
/**
 *the class is to read the input from user.
 */
final class Solution {
    /**
     *an empty constructor.
     */
    private Solution() {
    }
    /**
     *the main for reading input.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int magCount = scan.nextInt();
        int ransomCount = scan.nextInt();
        String[] ransomWords = new String[ransomCount];
        RansomNote obj = new RansomNote();
        for (int i = 0; i < magCount; i++) {
            String variable = scan.next();
            obj.addTo(variable);
        }
        int flag = 0;
        for (int i = 0; i < ransomCount; i++) {
            String result = obj.check(scan.next());
            if (result == "N") {
                System.out.println("No");
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("Yes");
        }
    }
}
