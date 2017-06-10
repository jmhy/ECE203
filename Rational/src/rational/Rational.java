package rational;

/** Rational.java
 * @author jmh463
 * This class models a rational number in reduced form, of which the numerator
 * and denominator can be set by the user. The user can also add a second 
 * rational number to current to produce a new rational number in reduced form.
 */
public class Rational
{
    private int num, den;

    /**
     * Accepts two integer parameters and creates a Rational object representing a rational number (a/b).
     * Throws an exception if the denominator is set to zero.
     * @param a sets the numerator
     * @param b sets the denominator
     */
    public Rational(int a, int b)
    {
        if (b == 0)
        {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        int g = gcd(a, b);
        num = a / g;
        den = b / g; 
    }

    /**
     * Accepts one integer parameter and creates a Rational object representing a rational number (a/1).
     * @param a sets the numerator
     */
    public Rational(int a)
    {
        this(a,1);
    }

    /**
     * Accepts two integer parameters to manually set the numerator and denominator of a rational number.
     * Throws an exception if the denominator is set to zero.
     * @param a sets the numerator
     * @param b sets the denominator
     */
    public void setRational(int a, int b)
    {
        if (b == 0)
        {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        int g = gcd(a, b);
        num = a / gcd(a, b);
        den = b / gcd(a, b); 
    }

    /**
     * Accepts one integer parameter to manually set the rational number to be (a/1).
     * @param a sets the numerator
     */
    public void setRational(int a)
    {
        num = a / gcd(a, 1);
        den = 1;
    }

    /**
     * Gets the numerator of the Rational object.
     * @return the current numerator
     */
    public int getNum()
    {
        return num;
    }
    
    /**
     * Gets the denominator of the Rational object.
     * @return the current denominator
     */
    public int getDen()
    {
        return den;
    }

    /**
     * Adds a new rational number to the current rational number
     * @param c the numerator of the new rational number
     * @param d the denominator of the new rational number
     */
    public void add(int c, int d)
    {
        int g = gcd(num, den);
        num = (num * d + den * c) / g;
        den = (den * d) / g;
    }
    /**
     * Accepts two integers that represent a rational number and calculates the greatest common divisor.
     * @return the value of the gcd
     */
    private static int gcd(int m, int n)
    {
        int mx = Math.max(m, n);
        int mn = Math.min(m, n);
        int remainder = 1;
        while (remainder != 0)
        {
            remainder = mx % mn;
            mx = mn;
            mn = remainder;
        }
        return mx;
    }
}
