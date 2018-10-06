import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
class Student{
	private String name;
	private String birth;
	private int subOne;
	private int subTwo;
	private int subThree;
	private int total;
	private String category;
	Student(final String student,
		final String birth, final String subOne, final String subTwo, final String subThree, final String total, final String category) {
		this.name = student;
		this.birth = birth;
		this.subOne = Integer.parseInt(subOne);
		this.subTwo = Integer.parseInt(subTwo);
		this.subThree = Integer.parseInt(subThree);
		this.total = Integer.parseInt(total);
		this.category = category;
	}
	public String getName() {
		return this.name;
	}
	public int getSubONe() {
		return this.subOne;
	}
	public int getSubTwo() {
		return this.subTwo;
	}
	public int getSubThree() {
		return this.subThree;
	}
	public int getTotal() {
		return this.total;
	}
	public String getCategory() {
		return this.category;
	}
}
class Database{
	private ArrayList<Student> list;
	Database() {
		list = new ArrayList<Student>();
	}
	public void addData(final Student obj) {
		list.add(obj);
	}
    public int compareTo(
        final Student studentOne, final Student studentTwo) {
        if (studentOne.getTotal() < studentTwo.getTotal()) {
            return  -1;
        } else if (studentOne.getTotal() > studentTwo.getTotal()) {
            return 1;
        } else {
            if (studentOne.getSubThree() < studentTwo.getSubThree()) {
                return -1;
            } else if (studentOne.getSubThree() > studentTwo.getSubThree()) {
                return 1;
            } else {
                if (studentOne.getSubTwo() < studentTwo.getSubTwo()) {
                    return -1;
                } else if (studentOne.getSubTwo() > studentTwo.getSubTwo()) {
                    return 1;
                }
            }
        }
        return 0;
 }
    public void sorting() {
        int max = 0;
        int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            max = i;
            for (int j = i + 1; j < list.size(); j++) {
                flag = compareTo(list.get(max), list.get(j));
                if (flag == -1) {
                    max = j;
                }
            }
            Collections.swap(list, i, max);
        }
    }
    public void print() {
        for (int i = 0; i < list.size(); i++) {
        	System.out.println(list.get(i).getName() + "," + list.get(i).getTotal() + "," + list.get(i).getCategory());
        }
        System.out.println();
    }
  	public void allotment(int vacancies, int openSeats, int bcSeats, int scSeats, int stSeats) {
  		ArrayList<Student> alloted = new ArrayList<Student>();
  		for(int i = 0; i < list.size(); i++) {
  			while(openSeats > 0) {
  				alloted.add(list.get(i));
  				openSeats--;
  			}
  		// 	while(bcSeats > 0) {
  		// 		if (list.get(i).getCategory().equals("BC")) {
  		// 			alloted.add(list.get(i));
  		// 			bcSeats--;
  		// 		}
  		// 	}
  		// 	while(scSeats > 0) {
  		// 		if (list.get(i).getCategory().equals("SC")) {
  		// 			alloted.add(list.get(i));
  		// 			scSeats--;
  		// 		}
  		// 	}
  		// 	while(stSeats > 0) {
    // 			if (list.get(i).getCategory().equals("ST")) {
  		// 			alloted.add(list.get(i));
  		// 			stSeats--;
  		// 		}
  		// 	}
  		// }
  		}
  		for(int i = 0; i < alloted.size(); i++){
  		System.out.println(alloted.get(i).getName() + "," + alloted.get(i).getTotal() + "," + alloted.get(i).getCategory());
  		}
  	}
}
class Solution{
	Solution(){
	}
	public static void main(final String[] args) {
		Student obj;
		Scanner scan = new Scanner(System.in);
		Database object = new Database();
		int totalQualified = scan.nextInt();
		int vacancies = scan.nextInt();
		int openSeats = scan.nextInt();
		int bcSeats = scan.nextInt();
		int scSeats = scan.nextInt();
		int stSeats = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < totalQualified; i++) {
			String line  =  scan.nextLine();
			String[] tokens = line.split(",");
			obj = new Student(
				tokens[0], tokens[1], tokens[2],
				tokens[3], tokens[4], tokens[5], tokens[6]);
			object.addData(obj);
		}
		object.sorting();
		object.print();
		object.allotment(vacancies, openSeats, bcSeats, scSeats, stSeats);
	}
}
