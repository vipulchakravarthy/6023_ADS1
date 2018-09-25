import java.util.Scanner;
/**
 * the percolation class is to identify.
 * there is a path or not
 */
class Percolation {
    /**
     * the boolean grid of 2-Dimensional.
     */
    private boolean[][] grid;
    /** this is virtual node.
    */
    private int top;
    /** this is virtual node.
    */
    private int bottom;
    /** to give the number of opensites.
    */
    private int count;
    /** to indicate the grid size.
    */
    private int gridSize;
    /** object for quick union class.
    */
    private WeightedQuickUnionUF obj;
    /** this is a constructor to initialize.
     * @param n the variable to determine the.
     * size of grid.
    */
   Percolation(final int n) {
    grid = new boolean[n][n];
    count = 0;
    gridSize = n;
    top = n * n;
    bottom = top + 1;
    obj = new WeightedQuickUnionUF((n * n) + 2);
    }
    /**open site (row, col) if it is not open already.
    *@param row to determine the row
    *@param col to determine the col
    */
   public void open(final int row, final int col) {
            if (grid[row][col]) {
                return;
            }
            grid[row][col] = true;
            count++;
            if (row  == 0) {
                obj.union(oneDarray(row, col), top);
            }
            if (row == gridSize - 1) {
                obj.union(oneDarray(row, col), bottom);
            }
            if (col - 1  >=  0 && isOpen(row, col - 1)) {
                obj.union(oneDarray(row, col),
                    oneDarray(row, col - 1));
            }
            if (col + 1 < gridSize && isOpen(row, col + 1)) {
                obj.union(oneDarray(row, col),
                    oneDarray(row, col + 1));
            }
            if (row - 1 >= 0 && isOpen(row - 1, col)) {
                obj.union(oneDarray(row, col),
                    oneDarray(row - 1, col));
            }
            if ((row + 1 < gridSize && isOpen(row + 1, col))) {
                obj.union(oneDarray(row, col),
                    oneDarray(row + 1, col));
            }
    }
    /**
     * the method is to determine the 2-Dimensional array.
     * in form of 1-Dimensional array.
     * @param     row     row value
     * @param      col     column value
     *
     * @return     index in 1-dimensional array
     */
    public int oneDarray(final int row, final int col) {
        return ((gridSize * (row)) + col);
    }
    /**
     * is site (row, col) open?
     * @param     row     row value
     * @param      col     column value
     *
     * @return     boolean
     */
   public boolean isOpen(final int row, final int col)  {
    return   grid[row][col];

   }
    /**
     * to give the number of open sites.
     *
     * @return    count to give the number of open sires.
     */
   public  int numberOfOpenSites() {
    return count;
   }
/**
 * whether system percolates or not.
 *
 * @return boolean value
 */
   public boolean percolates() {
    return obj.connected(top, bottom);
   }
 }
 /**
  * this is solution class which contains main method.
  */
final class Solution {
    /**
     * this is empty constrcutor.
     */
    private Solution() {
    }
    /**
     * the main method.
     *
     * @param      args  The arguments
     */
   public static void main(final String[] args) {
    Scanner scan = new Scanner(System.in);
    String arraySize = scan.nextLine();
    Percolation percolatesObj = new Percolation(
        Integer.parseInt(arraySize));
    while (scan.hasNext()) {
        String line = scan.nextLine();
        String[] tokens = line.split(" ");
        percolatesObj.open(Integer.parseInt(tokens[0]) - 1,
            Integer.parseInt(tokens[1]) - 1);
    }
    System.out.println(percolatesObj.percolates());
   }
  }



