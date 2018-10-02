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
	public int compareTo(Team one, Team two) {
		if (one.getWins() < two.getWins()) {
			return  -1;
		} else if (one.getWins() > two.getWins()) {
			return 1;
		} else {
			if (one.getLosses() < two.getLosses()) {
				return 1;
			} else if (one.getLosses() > two.getLosses()) {
				return -1;
			} else {
				if (one.getDraw() < two.getDraw()) {
					return -1;
				} else if(one.getDraw() < two.getDraw()) {
					return 1;
				}
			}
		}
		return 100;
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
		for (int i = 0; i < list.size(); i++) {
			max = i;
			for (int j = i + 1; j < list.size(); j++) {
				flag = compareTo(list.get(i), list.get(j));
				if (flag == -1) {
					max = j;
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
