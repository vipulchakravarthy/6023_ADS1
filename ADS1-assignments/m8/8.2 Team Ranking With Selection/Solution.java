import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
/**
 *the team class is to store properties.
 *of a team.
 */
class Team {
    /**
     * the variable to store team name.
     */
    private String teamName;
    /**
     * the variable to store number of wins.
     */
    private int wins;
    /**
     * the variable to store number of
     * lost matches.
     */
    private int losses;
    /**
     * the variable to store number
     * of tie matches.
     */
    private int tie;
    /**
     * constructor to initialize all properties.
     * @param      name  The name
     * @param      won   The won
     * @param      loss  The loss
     * @param      draw  The draw
     */
    Team(final String name,
         final int won, final int loss, final int draw) {
        teamName = name;
        wins = won;
        losses = loss;
        tie = draw;
    }
    /**
     * the method to get the name.
     *
     * @return     The name.
     */
    public String getName() {
        return teamName;
    }
    /**
     *this method Gives the wins.
     *
     * @return     The wins.
     */
    public int getWins() {
        return wins;
    }
    /**
     *this method Gives the Losses.
     *
     * @return     The losses.
     */
    public int getLosses() {
        return losses;
    }
    /**
     *the method is get the draw.
     *
     * @return     The draw.
     */
    public int getDraw() {
        return tie;
    }
}
/**
 * Class for leader board.
 * it stores the data of all teams.
 */
class LeaderBoard {
    /**
    * list is the arraylist created.
     * for storing all the objects.
     */
    private ArrayList<Team> list;
    /**
     * the constructor to initialize the.
     * arraylist.
     */
    LeaderBoard() {
        list = new ArrayList<Team>();
    }
    /**
     *the compareto method is to.
     *check the number of wins and
     *losses
     * @param      teamOne   One
     * @param      teamTwo   Two
     * @return  based on their lead
     */
    public int compareTo(
        final Team teamOne, final Team teamTwo) {
        if (teamOne.getWins() < teamTwo.getWins()) {
            return  -1;
        } else if (teamOne.getWins() > teamTwo.getWins()) {
            return 1;
        } else {
            if (teamOne.getLosses() < teamTwo.getLosses()) {
                return 1;
            } else if (teamOne.getLosses() > teamTwo.getLosses()) {
                return -1;
            } else {
                if (teamOne.getDraw() < teamTwo.getDraw()) {
                    return -1;
                } else if (teamOne.getDraw() > teamTwo.getDraw()) {
                    return 1;
                }
            }
        }
        return 0;
    }
    /**
     * the method to add the object to array.
     * the time complexity is O(1).
     * because we just insert an element.
     * @param      obj   The object
     */
    public void addTo(final Team obj) {
        list.add(obj);
    }
    /**
     *this method is to perform the sorting.
     *operation.
     *the time complexiety will be N + N^2/2.
     *N is the size of array.
     *it will iterate through out the array.
     *for each comparision so we have N comparisons.
     *and N^2/2.
     */
    public void sorting() {
        int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j > 0; j--) {
                flag = compareTo(list.get(j - 1), list.get(j));
                if (flag == -1) {
                Collections.swap(list, j, j - 1);
                } else {
                    break;
           }
            }
        }
    }
    /**
     *to print the string format of array.
     *time complexiety is O(n)
     *n is size of the array.
     * @return  str the objects in array.
     */
    public String print() {
        String str = "";
        for (int i = 0; i < list.size() - 1; i++) {
            str += list.get(i).getName() + ",";
        }
        str += list.get(list.size() - 1).getName();
        return str;
    }
}
/**
 *the solution class for main.
 */
final class Solution {
    /**
     * empty constructor.
     */
    private Solution() {
    }
    /**
     * this is main to read the input.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Team obj;
        final int three = 3;
        LeaderBoard object = new LeaderBoard();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] tokens = line.split(",");
            obj = new Team(tokens[0],
                           Integer.parseInt(tokens[1]),
                           Integer.parseInt(tokens[2]),
                           Integer.parseInt(tokens[three]));
            object.addTo(obj);
        }
        object.sorting();
        System.out.println(object.print());
    }
}
