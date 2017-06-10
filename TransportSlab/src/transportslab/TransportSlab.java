package transportslab;

/**
 *
 * @author jmh463
 */
public class TransportSlab
{
    private int N0 = 0;
    private double sigmaT = 0; 
    private double delta_x = 0;
    private double thickness = 0;
    private double[] x, N_Analytical, N_Euler, N_MonteCarlo;
    
    /**
     * This constructor sets the initial conditions for the transport slab. This
     * also automatically calls the other methods of this class to find the
     * unattenuated profile and the approximate cross section Sigma T.
     * @param initN0 Number of incident particles
     * @param T Thickness of the material
     * @param initSigmaT Macroscopic cross section
     * @param n Number of sections in the thickness
     */
    public TransportSlab(int initN0, double T, double initSigmaT, int n)
    {
        //Variables to be used in other methods
        N0 = initN0;
        sigmaT = initSigmaT;
        thickness = T;
        //Create an array of n+1 in length to store all increments of delta x
        x = new double[n + 1];
        x[0]=0;
        delta_x = (T / n);
        for (int i = 1; i < n + 1; i++)
        {
            x[i] = x[i-1] + delta_x;
        }
        /*
        Call the other methods of this class and print out the analytical, Euler,
        and Monte Carlo solutions for Sigma T
        */
        System.out.println("Analytical Macroscopic Cross Section: " + this.leastSquaresSigma(analytical()));
        System.out.println("Euler Macroscopic Cross Section: " + this.leastSquaresSigma(euler()));
        System.out.println("Monte Carlo Macroscopic Cross Section: " + this.leastSquaresSigma(monteCarlo()));
    }

    /**
     * Calculates the unattenuated profile analytically and stores it to an array.
     * @return The array {@code N_Analytical} of type {@code double[]}
     */
    public final double[] analytical()
    {
        //Array length dependent upon initial conditions
        N_Analytical = new double[x.length];
        //Calculate # of surviving particles and store it to the array
        for (int i = 0; i < N_Analytical.length; i++)
        {
            N_Analytical[i] = N0*Math.exp(-sigmaT*x[i]);
        }
        return N_Analytical;
    }
    
    /**
     * Calculates the unattenuated profile via Euler's method and stores it to 
     * an array.
     * @return The array {@code N_Euler} of type {@code double[]}
     */
    public final double[] euler()
    {
        //Array length dependent upon initial conditions
        N_Euler = new double[x.length];
        //Set the first element to the initial number of particles
        N_Euler[0]=N0;
        //Calculate # of surviving particles and store it to the array
        for (int i = 1; i < x.length; i++)
        {
            N_Euler[i] = N_Euler[i-1]-N_Euler[i-1]*sigmaT*delta_x;
        }
        return N_Euler;
    }

    /**
     * Calculates the unattenuated profile via the Monte Carlo method and stores 
     * it to an array.
     * @return The array {@code N_MonteCarlo} of type {@code double[]}
     */
    public final double[] monteCarlo()
    {
        //Array length dependent upon initial conditions
        N_MonteCarlo = new double[x.length];
        //Set the first element to the initial number of particles
        N_MonteCarlo[0]=N0;
        //Calculate probability of survival
        double p = sigmaT*delta_x;
        //Initialize the number of surviving particles
        int survived = N0;
        for (int i = 1; i < x.length; i++)
        {
            //Create an array of random numbers for the test
            double[] surviveTest = new double[survived];
            for (int j = 0; j < survived; j++)
            {
                surviveTest[j] = Math.random();   
            }
            //Set to 0 so that we can count the # of survivors from the test below
            survived = 0;
            /*
            If the randomly number is greater than the survival probability,
            then the particle survives
            */
            for (int k = 0; k < surviveTest.length; k++)
            {
                if (surviveTest[k] > p)
                {
                    //Add up the total survivors
                    survived++;
                }
            }
            //Store the # of survivors to the attenuated profile
            N_MonteCarlo[i] = survived;
        }
        return N_MonteCarlo;
    }

    /**
     * This calculates the cross section Sigma T using the least-squares
     * approximation for any unattenuated profile.
     * @param N An array of type {@code double[]}
     * @return Cross section Sigma T
     */
    public final double leastSquaresSigma(double[] N)
    {
        //Initialize elements of the A (2x2) and B (2x1) matrices
        double[] y = new double[x.length];
        double xsum = 0;
        double x2sum = 0;
        double ysum = 0;
        double xysum = 0;
        
        //Calculate elements of the A and B matrices
        for (int i = 0; i < x.length; i++)
        {
            y[i] = Math.log(N[i]);
            xsum += x[i];
            x2sum += x[i]*x[i];
            ysum += y[i];
            xysum += x[i]*y[i];
        }
        //Find the determinant of the A matrix
        double A_det = (N.length * x2sum) - (xsum * xsum);
        //Matrix multiply the bottom row of the inverse matrix of A with B
        //or A^-1*B
        double sigmaT_Final = -1 * ((-xsum / A_det) * ysum + (N.length / A_det) * xysum);
        return sigmaT_Final;
    }

    /**
     * Gets the thickness entered by the constructor for use in the graph class
     * @return thickness of type {@code double}
     */
    public double getThickness()
    {
        return thickness;
    }
}