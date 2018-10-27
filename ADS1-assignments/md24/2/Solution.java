import java.util.Scanner;
/**
 *the class for storing the data of student.
 */
class Student {
    /**
     *the variable to store the rollnumber.
     */
    private String rollNumber;
    /**
     *the variable to store the name.
     */
    private String name;
    /**
     *the variable to store the marks.
     */
    private Double marks;
    /**
     *the constructor to initialize the student details.
     *
     * @param      roll         The roll number
     * @param      studentName  The student name
     * @param      total        The total
     */
    Student(final String roll,
            final String studentName, final String total) {
        rollNumber = roll;
        name = studentName;
        marks = Double.parseDouble(total);
    }
    /**
     *returns the rollNumber of student.
     *
     * @return     The roll.
     */
    public String getRoll() {
        return this.rollNumber;
    }
    /**
     *returns the name of student.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     *returns the total of the student.
     *
     * @return     The total.
     */
    public Double getTotal() {
        return this.marks;
    }
}
/**
 *the class to maintain the database.
 */
class DataBase {
    /**
     *the object to create the symbol table.
     */
    RedBlackBST<Double, Student> stObj;
    /**
     *the constructor to initlialize the object.
     */
    DataBase() {
        stObj = new RedBlackBST<Double, Student>();
    }
    /**
     *the method to add the values to the hashtable.
     *the average time complexity is 3-5*
     *under the uniform hashing assumption
     * @param      studentObj  The student object
     */
    public void addTo(final Student studentObj) {
        stObj.put(studentObj.getTotal(), studentObj);
    }
    /**
     *
     */
    public String getBetween(Double marksOne, Double marksTwo){
        String str = "";
        Double keyOne = stObj.ceiling(marksOne);
        Double keyTwo = stObj.floor(marksTwo);
        for(Double marks: stObj.keys(keyOne, keyTwo)){
            str += stObj.get(marks).getName() + "\n";
        }
        String strOne = str.substring(0, str.length() - 1);
        return strOne;
    }
    public void getLesser(Double mark){
        Double key = stObj.floor(mark);
        for(Double marks: stObj.keys(stObj.min(), key)){
            System.out.println(stObj.get(marks).getName());
        }
   }
    public void getGreater(Double mark){
        Double key = stObj.ceiling(mark);
        String str = "";
        for(Double marks: stObj.keys(key, stObj.max())){
            System.out.println(stObj.get(marks).getName());
        }
    }

}
/**
 *the class for main method.
 */
final class Solution {
    /**
     *an empty constructor.
     */
    private Solution() {
    }
    /**
     *the main method to read the input.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        DataBase dataObj = new DataBase();
        Student studentDetails;
        int students = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < students; i++) {
            String[] tokens = scan.nextLine().split(",");
            studentDetails = new Student(
                tokens[0], tokens[1], tokens[2]);
            dataObj.addTo(studentDetails);
        }
        int queries = scan.nextInt();
        scan.nextLine();
        while (queries > 0) {
            String[] check = scan.nextLine().split(" ");
            switch(check[0]){
                case "BE":
                System.out.println(dataObj.getBetween(Double.parseDouble(
                        check[1]), Double.parseDouble(check[2])));
                    break;
                case "LE":
                dataObj.getLesser(
                    Double.parseDouble(check[1]));
                    break;
                case "GE":
                    dataObj.getGreater(
                    Double.parseDouble(check[1]));
                    break;
                default: break;
            }
            queries--;
        }
    }
}
