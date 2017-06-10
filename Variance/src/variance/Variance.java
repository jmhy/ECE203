package variance;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author jmh463
 */
public class Variance
{
    /**
     * Main and only method of the class.
     * @param args not used
     */
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        ArrayList<Double> xBar = new ArrayList<Double>();
        double x = 0;
        double varSum = 0;
        while(x >= 0)
        {
            System.out.print("Enter number: ");
            x = input.nextDouble();
            if (x < 0)
            {
                System.out.println("End of program");
                System.exit(0);
            }
            xBar.add(x);
            
            double ave = 0;
        
            for(int j = 0; j < xBar.size(); j++)
            {    
                ave = ave + xBar.get(j);          
            }        
            ave = ave / (xBar.size());

            double var = 0;
            for (int i = 0; i < xBar.size(); i++)
            {                   
                var = var + (xBar.get(i) - ave)*(xBar.get(i) - ave);                                    
            }
            var = var/xBar.size();
            System.out.println(var);
        }
    }   
}