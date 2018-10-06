import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
/**
 *this class stores the student info.
 */
class Student {
	/**
	 *name of the student.
	 */
	private String name;
	/**
	 *DOB of the student.
	 */
	private String birth;
	/**
	 *mark1 of the student.
	 */
	private int subOne;
	/**
	 *mark2 of the student.
	 */
	private int subTwo;
	/**
	 *mark3 of the student.
	 */
	private int subThree;
	/**
	 *total marks.
	 */
	private int total;
	/**
	 *category of the student.
	 */
	private String category;
	/**
	 * to initialize the data od student.
	 *
	 * @param      student   The student
	 * @param      birth     The birth
	 * @param      subOne    The sub one
	 * @param      subTwo    The sub two
	 * @param      subThree  The sub three
	 * @param      total     The total
	 * @param      category  The category
	 */
	Student(final String student,
	        final String birth, final String subOne,
	        final String subTwo, final String subThree,
	        final String total, final String category) {
		this.name = student;
		this.birth = birth;
		this.subOne = Integer.parseInt(subOne);
		this.subTwo = Integer.parseInt(subTwo);
		this.subThree = Integer.parseInt(subThree);
		this.total = Integer.parseInt(total);
		this.category = category;
	}
	/**
	 * Gets the name.
	 *
	 * @return     The name.
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Gets the subone marks.
	 *
	 * @return     The sub o ne.
	 */
	public int getSubONe() {
		return this.subOne;
	}
	/**
	 * Gets the sub two marks.
	 *
	 * @return     The sub two.
	 */
	public int getSubTwo() {
		return this.subTwo;
	}
	/**
	 * Gets the sub three marks.
	 *
	 * @return     The sub three.
	 */
	public int getSubThree() {
		return this.subThree;
	}
	/**
	 * Gets the total.
	 *
	 * @return     The total.
	 */
	public int getTotal() {
		return this.total;
	}
	/**
	 * Gets the category.
	 *
	 * @return     The category.
	 */
	public String getCategory() {
		return this.category;
	}
	/**
	 * Gets the age.
	 *
	 * @return     The age.
	 */
	public int getAge() {
		String[] age = this.birth.split("-");
		int month = Integer.parseInt(age[1]);
		return month;
	}
}
/**
 * Class for database.
 */
class Database {
	/**
	 * arraylist of objects to store.
	 * all students as objects.
	 */
	private ArrayList<Student> list;
	/**
	 * to initialize the object.
	 */
	Database() {
		list = new ArrayList<Student>();
	}
	/**
	 *to add the object.
	 *
	 * @param      obj   The object
	 * is student here.
	 */
	public void addData(final Student obj) {
		list.add(obj);
	}
	/**
	 * this method compares in the descending.
	 * order of merit for two students
	 *
	 * @param      studentOne  The student one
	 * @param      studentTwo  The student two
	 *
	 * @return if it is lesser returns -1
	 * or else 1
	 */
	public int compareTo(
	    final Student studentOne,
	    final Student studentTwo) {
		if (studentOne.getTotal()
			< studentTwo.getTotal()) {
			return  -1;
		} else if (studentOne.getTotal()
			> studentTwo.getTotal()) {
			return 1;
		} else {
			if (studentOne.getSubThree()
				< studentTwo.getSubThree()) {
				return -1;
			} else if (studentOne.getSubThree()
				> studentTwo.getSubThree()) {
				return 1;
			} else {
				if (studentOne.getSubTwo()
					< studentTwo.getSubTwo()) {
					return -1;
				} else if (studentOne.getSubTwo()
					> studentTwo.getSubTwo()) {
					return 1;
				} else {
					if (studentOne.getAge()
						> studentTwo.getAge()) {
						return 1;
					} else if (studentOne.getAge()
						< studentTwo.getAge()) {
						return -1;
					}
				}
			}
		}
		return 0;
	}
	/**
	 *the method is to sort the objects.
	 *the time complexity will be N^2/ 2
	 *because every time it iterates through
	 *out the array.
	 */
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
	/**
	 *it prints the arrayList.
	 */
	public void print() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName()
				+ "," + list.get(i).getTotal()
				+ "," + list.get(i).getCategory());
		}
		System.out.println();
	}
	/**
	 * the method is for allotment of candidates.
	 *
	 * @param      vacancies  The vacancies
	 * @param      openSeats  The open seats
	 * @param      bcSeats    The bc seats
	 * @param      scSeats    The screen seats
	 * @param      stSeats    The st seats
	 */
	public void allotment(int vacancies,
		int openSeats, int bcSeats,
		int scSeats, int stSeats) {
		ArrayList<Student> alloted
		= new ArrayList<Student>();
		int count = 0;
		for (int i = 0; i < list.size()
			&& openSeats > 0 && vacancies > 0; i++) {
			alloted.add(list.get(i));
			openSeats--;
			count++;
			vacancies--;
		}
		for (int i = count; i < list.size()
			&& vacancies > 0; i++) {
			if (list.get(i).getCategory().equals("BC")
				&& bcSeats > 0) {
				alloted.add(list.get(i));
				bcSeats--;
				count++;
				vacancies--;
			}
			if (list.get(i).getCategory().equals("ST")
				&& stSeats > 0) {
				alloted.add(list.get(i));
				stSeats--;
				count++;
				vacancies--;
			}
			if (list.get(i).getCategory().equals("SC")
				&& scSeats > 0 ) {
				alloted.add(list.get(i));
				scSeats--;
				count++;
				vacancies--;
			}
		}
		int reserved = bcSeats + scSeats + stSeats;
		for (int i = count; i < list.size(); i++) {
			if (reserved > 0) {
				alloted.add(list.get(i));
				reserved--;
			}
		}
		for (int i = 0; i < alloted.size(); i++) {
			System.out.println(alloted.get(i).getName()
				+ "," + alloted.get(i).getTotal() + ","
				+ alloted.get(i).getCategory());
		}
	}
}
/**
 *this the class for main.
 */
class Solution {
	/**
	 *empty constructor
	 */
	Solution() {
	}
	/**
	 * the main to read the input.
	 *
	 * @param  args  The arguments
	 */
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
		object.allotment(vacancies,
			openSeats, bcSeats, scSeats, stSeats);
	}
}
