import java.util.Scanner;
/**
 *the class for cubesum and print the.
 *taxi cab numbers.
 */
class CubeSum
    implements Comparable<CubeSum> {
    /**
     *the variable to store sum of the cubes.
     */
    private final int sum;
    /**
     *the element to store the first number.
     */
    private final int numberOne;
    /**
     *the element to store the second number.
     */
    private final int numberTwo;
    /**
     *the constructor is to initialize.
     *
     * @param      numOne  The number one
     * @param      numTwo  The number two
     */
    CubeSum(
        final int numOne, final int numTwo) {
        this.sum = numOne * numOne * numOne
                   + numTwo * numTwo * numTwo;
        this.numberOne = numOne;
        this.numberTwo = numTwo;
    }
    /**
     *this method returns sum.
     *
     * @return    The sum.
     */
    public int getSum() {
        return this.sum;
    }
    /**
     *this method returns the first number.
     *@return returns the first number.
     */
    public int getNumOne() {
        return this.numberOne;
    }
    /**
     *this method returns the second number.
     *@return returns the second number.
     */
    public int getNumTwo() {
        return this.numberTwo;
    }
    /**
     * compare to method is to for comparing two sums.
     *
     * @param      that  The that
     *
     * @return  compare value as 1 or 0 or -1
     */
    public int compareTo(final CubeSum that) {
        if (this.sum < that.sum) {
            return -1;
        }
        if (this.sum > that.sum) {
            return +1;
        }
        return 0;
    }
}
/**
 *the solution class for main method.
 */
final class Solution {
    /**
     *an empty constructor.
     */
    private Solution() {
    }
    /**
     *this is main method for reading input.
     *first it will add elements to the MinPQ.
     *it will iterate through the PQ untill
     *we find the taxicab number.
     *time complexity is O(2N);
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int range = 600;
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int ways = scan.nextInt();
        int count = 0;
        int temp = -1;
        MinPQ<CubeSum> pqObj
            = new MinPQ<CubeSum>();
        for (int i = 0; i <= range; i++) {
            pqObj.insert(new CubeSum(i, i));
        }
        while (!pqObj.isEmpty()) {
            CubeSum result = pqObj.delMin();
            if (temp == result.getSum()) {
                count++;
            } else {
                count = 0;
            }
            if (count == ways - 1) {
                number--;
                if (number == 0) {
                    System.out.println(result.getSum());
                    break;
                }
            }
            temp = result.getSum();
            if (result.getNumTwo() < range) {
                pqObj.insert(new CubeSum(
                                 result.getNumOne(),
                                 result.getNumTwo() + 1));
            }
        }
    }
}

