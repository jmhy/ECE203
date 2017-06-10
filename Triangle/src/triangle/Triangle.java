package triangle;
/**
 *
 * @author jmh463
 */

public class Triangle
{
    private double P;
    private double A;
    private double x;
    private double y;
    private double z;
    
    /**
     * Constructs a triangle from 3 specified side lengths and will abort if an invalid triangle is given
     * @param a Specified side length 1
     * @param b Specified side length 2
     * @param c Specified side length 3
     */
    public Triangle(double a, double b, double c)
    {
        if (a>=b+c)
        {
            System.exit(0);
        }
        else if (b>=a+c)
        {
            System.exit(0);
        }
        else if (c>=a+b)
        {
            System.exit(0);
        }
        else if (a<=0)
        {
            System.exit(0);
        }
        else if (b<=0)
        {
            System.exit(0);
        }
        else if (c<=0)
        {
            System.exit(0);
        }
        else
        {
            x=a;
            y=b;
            z=c;
        }
    }

    /**
     * Finds the perimeter of the triangle from the 3 side lengths
     * @return the perimeter itself
     */
    public double getPerimeter()
    {
        P=x+y+z;
        return P;
    }

    /**
     * Finds the area of the triangle from the 3 side lengths
     * @return the area itself
     */
    public double getArea()
    {
        A=Math.sqrt((P/2)*(P/2-x)*(P/2-y)*(P/2-z));
        return A;
    }

    /**
     * Tests if the triangle is obtuse from the given side lengths
     * @return 1 if obtuse, 0 if not
     */
    public int isObtuse()
    {
        if (((x*x+y*y-z*z)/(2*x*y))<0)
        {
            return 1;
        }
        else if (((x*x+z*z-y*y)/(2*x*z))<0)
        {
            return 1;
        }
        else if (((y*y+z*z-x*x)/(2*y*z))<0)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    /**
     * Implements the methods of the Triangle class
     * @param args not used
     */
    public static void main(String[] args)
    {
        Triangle test1 = new Triangle(3, 4, 5);
        System.out.println("The perimeter of the triangle is " + test1.getPerimeter());
        System.out.println("The are of the triangle is " + test1.getArea());
        System.out.println("Is the triangle obtuse? 1 if true, 0 if false. It is: " + test1.isObtuse());
    }
}