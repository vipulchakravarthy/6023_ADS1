import java.util.Scanner;
class Percolation {
    // create n-by-n grid, with all sites blocked
    private boolean[][] grid;
    private int top;
    private int bottom;
    private int size;
    private int count;
    int gridSize;
    WeightedQuickUnionUF obj;
   public Percolation(int n) {
   	grid = new boolean[n][n];
   	count = 0;
   	gridSize = n;
   	top = n * n ;
   	bottom = top + 1;
   	obj = new WeightedQuickUnionUF((n * n) + 2);
	}
	// open site (row, col) if it is not open already
   public void open(int row, int col) {
   			if (grid[row][col]) return;
   			grid[row][col] = true;
   			count++;
   			if (row  == 0) {
   				obj.union(oneDarray(row, col), top);
   			}
   			if (row == gridSize - 1) {
   				obj.union(oneDarray(row, col), bottom);
   			}
   			if (col - 1  >=  0 && isOpen(row, col - 1)   ) {
   				obj.union(oneDarray(row, col), oneDarray(row, col - 1));
   			}
   			if (col + 1 < gridSize && isOpen(row, col + 1)   ) {
   				obj.union(oneDarray(row, col), oneDarray(row, col + 1));
   			}
   			if ( row -1 >= 0 && isOpen(row - 1, col)   ) {
   				obj.union(oneDarray(row, col), oneDarray(row - 1, col));
   			}
   			if ((row + 1< gridSize && isOpen(row + 1, col))  ) {
   				obj.union(oneDarray(row, col), oneDarray(row + 1, col));
   			}
   	}
   	public int oneDarray(int i , int j) {
   		return ((gridSize * (i)) + j);
   	}

 	// is site (row, col) open?
   public boolean isOpen(int row, int col)  {
   	return	 grid[row][col];

   }
   // public boolean isFull(int row, int col)  // is site (row, col) full?
   //      // number of open sites
   public  int numberOfOpenSites(){
   	return count;
   }
    // does the system percolate?
   public boolean percolates() {
   	return obj.connected(top, bottom);
   }
 }
class Solution {
	Solution() {
	}
   public static void main(String[] args) {
   	Scanner scan = new Scanner(System.in);
   	String arraySize = scan.nextLine();
   	Percolation percolatesObj = new Percolation(Integer.parseInt(arraySize));
   	while (scan.hasNext()) {
   		String line = scan.nextLine();
   		String[] tokens = line.split(" ");
   		percolatesObj.open(Integer.parseInt(tokens[0]) - 1, Integer.parseInt(tokens[1]) - 1);
   	}
   	System.out.println(percolatesObj.percolates());
   }
  }



