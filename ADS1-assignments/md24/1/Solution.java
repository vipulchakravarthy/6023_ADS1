import java.util.Scanner;
/**
 *the class for storing the data of student.
 */
class Student{
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
	final String studentName, final String total){
		rollNumber = roll;
		name = studentName;
		marks = Double.parseDouble(total);
	}
	/**
	 *returns the rollNumber of student
	 *
	 * @return     The roll.
	 */
	public String getRoll(){
		return this.rollNumber;
	}
	/**
	 *returns the name of student.
	 *
	 * @return     The name.
	 */
	public String getName(){
		return this.name;
	}
	/**
	 *returns the total of the student
	 *
	 * @return     The total.
	 */
	public Double getTotal(){
		return this.marks;
	}
}
/**
 *the class to maintain the database.
 */
class DataBase{
	/**
	 *the object to create the hash table.
	 */
	LinearProbingHashST<String, Student> hashObj;
	/**
	 *the constructor to initlialize the object.
	 */
	DataBase(){
		hashObj = new LinearProbingHashST<String, Student>();
	}
	/**
	 *the method to add the values to the hashtable.
	 *the average time complexity is 3-5*
	 *under the uniform hashing assumption
	 * @param      studentObj  The student object
	 */
	public void addTo(final Student studentObj){
		hashObj.put(studentObj.getRoll(), studentObj);
	}
	/**
	 *the method to add the values to the hashtable.
	 *the average time complexity is 3-5*
	 *under the uniform hashing assumption
	 *@param rollNumber the roll number of student
	 *@return the name of the student.
	 */
	public String getStudent(final String rollNumber){
		Student student = hashObj.get(rollNumber);
		if(student == null) {
			return "Student doesn't exists...";
		}
		return student.getName();
	}
	/**
	 *this method returns the total marks
	*the average time complexity is 3-5*
	 *under the uniform hashing assumption
	 * @param      rollNumber  The roll number of student
	 *
	 * @return     The total marks of students.
	 */
	public Double getTotalMarks(final String rollNumber){
		Student student = hashObj.get(rollNumber);
		if(student == null) {
			return 1.0;
		}
		return student.getTotal();
	}
}
/**
 *the class for main method.
 */
class Solution{
	/**
	 *an empty constructor.
	 */
	Solution(){
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
		for(int i = 0; i < students; i++){
			String[] tokens = scan.nextLine().split(",");
			studentDetails = new Student(tokens[0], tokens[1], tokens[2]);
			dataObj.addTo(studentDetails);
		}
		int queries = scan.nextInt();
		scan.nextLine();
		while(queries > 0){
			String[] check = scan.nextLine().split(" ");
			switch(check[2]){
				case "1":
					System.out.println(dataObj.getStudent(check[1]));
					break;
				case "2":
					Double result = dataObj.getTotalMarks(check[1]);
						if(result == 1.0){
							System.out.println("Student doesn't exists...");
						} else {
							System.out.println(result);
						}
					break;
				default:break;
			}
			queries--;
		}
	}
}
