import java.util.Scanner;
import java.util.Arrays;
class Student{
	private String rollNumber;
	private String name;
	private Double marks;
	Student(String roll, String studentName, String total){
		rollNumber = roll;
		name = studentName;
		marks = Double.parseDouble(total);
	}
	public String getRoll(){
		return this.rollNumber;
	}
	public String getName(){
		return this.name;
	}
	public Double getTotal(){
		return this.marks;
	}
}
class DataBase{
	LinearProbingHashST<String, Student> hashObj;
	DataBase(){
		hashObj = new LinearProbingHashST<String, Student>();
	}
	public void addTo(Student studentObj){
		hashObj.put(studentObj.getRoll(), studentObj);
	}
	public String getStudent(String rollNumber){
		Student student = hashObj.get(rollNumber);
		if(student == null) {
			return "Student doesn't exists...";
		}
		return student.getName();
	}
	public Double getTotalMarks(String rollNumber){
		Student student = hashObj.get(rollNumber);
		if(student == null) {
			return 1.0;
		}
		return student.getTotal();
	}

}
class Solution{
	Solution(){
	}
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
