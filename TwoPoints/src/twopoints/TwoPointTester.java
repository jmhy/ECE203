package twopoints;

/** TwoPointTester.java
 * @author jmh463
 * This class tests the TwoPoints.java class.
 */
public class TwoPointTester
{
    public static void main(String[] args)
    {
        double x1 = 2;
        double y1 = 3;
        double x2 = 7;
        double y2 = 7;
        TwoPoints test = new TwoPoints(x1, y1, x2, y2);
        System.out.println("The slope between the points (" + x1 + "," + y1 + ") and (" + x2 + "," + y2 + ") is " + test.slope());
        double inter = 4.1;
        System.out.println("The linear interpolation of the x-value " + inter + " is " + test.interpolate(inter));
    }
}
