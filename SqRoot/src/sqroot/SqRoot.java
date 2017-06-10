package sqroot;
/**
 *
 * @author jmh463
 */

public class SqRoot
{
    private double SqrNum;

    /**
     * Accepts an integer number and returns the square root as a double
     * @param amount the amount to take the square root of
     * @return the square root of amount
     */
    public double sqRoot(int amount)
    {
        SqrNum = Math.sqrt(amount);
        return SqrNum;
    }
    
    /**
     * Prints the integer number and its square root
     * @param amount the amount to take the square root
     */
    public void printSqRoot(int amount)
    {
        System.out.println("The square root of " + amount + " is " + Math.sqrt(amount));
    }
    
    /**
     * Tests the two methods of this class
     * @param args not used
     */
    public static void main(String[] args)
    {
        SqRoot testsq = new SqRoot();
        System.out.println("The square root is " + testsq.sqRoot(25));
        testsq.printSqRoot(25);
    }
}