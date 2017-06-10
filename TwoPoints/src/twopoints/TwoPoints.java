package twopoints;

/** TwoPoints.java
 * @author jmh463
 * This class models two points in a Cartesian coordinate system.
 */
public class TwoPoints
{
    private final double x1, x2, y1, y2;
    
    /**
     * Accepts four double inputs to represent two Cartesian points (x1,y1) and (x2,y2).
     * @param a the point x1
     * @param b the point y1
     * @param c the point x2
     * @param d the point y2
     */
    public TwoPoints(double a, double b, double c, double d)
    {
        x1 = a;
        y1 = b;
        x2 = c;
        y2 = d;
    }

    /**
     * Calculates the slope of the line connecting the two Cartesian points.
     * @return the slope of the line
     */
    public double slope()
    {
        if (x2 - x1 == 0)
        {
            return Double.POSITIVE_INFINITY;
        }
        else
        {
            return (y2 - y1)/(x2 - x1);
        }
    }

    /**
     * Accepts a double and performs a linear interpolation between two points.
     * @param x3 the x-value of the new point
     * @return the y-value of the new point
     */
    public double interpolate(double x3)
    {
        if (x2 - x1 == 0)
        {
            return Double.NaN;
        }
        else
        {
            double y3 = this.slope() * (x3 - x1) + y1;
            return y3;
        }
    }
}