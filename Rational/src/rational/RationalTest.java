package rational;

/** RationalTest.java
 * @author jmh463
 * This class tests the Rational.java class.
 */
public class RationalTest
{
    public static void main(String[] args)
    {
        Rational test = new Rational(2);
        System.out.println("The rational number is " + test.getNum() + "/" + test.getDen());
        int x = 4;
        int y = 5;
        test.add(x, y);
        System.out.println("Adding " + x + "/" + y + " results in " + test.getNum() + "/" + test.getDen());
        test.setRational(9,5);
        System.out.println("The rational number has been set to " + test.getNum() + "/" + test.getDen());
    }
}
