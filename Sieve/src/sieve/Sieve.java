package sieve;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author jmh463
 */
public class Sieve
{

    /**
     * Main and only method of the class.
     * @param args not used
     */
    public static void main(String[] args) 
    {
        ArrayList<Integer> values = new ArrayList();        
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Number: ");
        int n = input.nextInt();
       
        for(int i = 2; i < n; i++)
        {
            if ((i % 2) != 0)
            {   
                values.add(i);
            }
            if(i == 2)
            {   
                values.add(2);
            }
        }
        
        for (int i = 0; i < values.size(); i++) 
        {
            for (int j = i+1; j < values.size(); j++)
            {
                if(values.get(j) % values.get(i) == 0)
                {
                    values.remove(j);    
                }
            }
        }
        
        System.out.println("The total primes less than or equal to this number is " + values.size());
    }
}