import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
class Team {
	String teamName;
	int wins;
	int losses;
	int tie;
	Team(String name, int won, int loss, int draw) {
		teamName = name;
		wins = won;
		losses = loss;
		tie = draw;
	}
	public String getName() {
		return teamName;
	}
	public int getWins() {
		return wins;
	}
	public int getLosses() {
		return losses;
	}
	public int getDraw() {
		return tie;
	}
}
class LeaderBoard {
	ArrayList<Team> list;
 	LeaderBoard() {
 		list = new ArrayList<Team>();
	}
	public int compareTo(int a, int b) {
		if (a > b) {
			return 1;
		} else if (a < b) {
			return -1;
		}
		return 0;
	}
	// public boolean high(int a, int b) {
	// 	return compareTo(a, b) > 0;
	// }
	// public void swap(ArrayList<Team> list, int a, int b) {
	// 	Team temp = list[a];
	// 	list[a] = list[b];
	// 	list[b] = temp;
	// }
	public void addTo(Team obj) {
		list.add(obj);
	}
	public void sorting() {
		int max = 0;
		int flag = 0;
		int temp = 0;
		int tempTwo = 0;
		for (int i = 0; i < list.size(); i++) {
			max = i;
			for (int j = i + 1; j < list.size(); j++) {
				flag = compareTo(list.get(j).getWins(), list.get(i).getWins());
				if (flag == 0) {
					temp = compareTo(list.get(j).getLosses(), list.get(i).getLosses());
					if (temp > 0) {
						max = i;
					} else if(temp == 0) {
						tempTwo = compareTo(list.get(j).getDraw(), list.get(i).getDraw());
						if (tempTwo > 0) {
							max = j;
						}
					}
				} else if (flag > 0) {
					max = j;
				} else {
					continue;
				}
			}
			Collections.swap(list, i, max);
		}
	}
	public String print() {
		String str = "";
		for (int i = 0; i < list.size() - 1; i++) {
			str += list.get(i).getName() + ",";
		}
		str += list.get(list.size() - 1).getName();
		return str;
	}
}
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Team obj;
		LeaderBoard object = new LeaderBoard();
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			obj = new Team(tokens[0],
				Integer.parseInt(tokens[1]),
				Integer.parseInt(tokens[2]),
				Integer.parseInt(tokens[3]));
			object.addTo(obj);
		}
		object.sorting();
		System.out.println(object.print());
	}
}
