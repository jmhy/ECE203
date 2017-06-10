package newfib;

import java.util.Scanner;

/**
 *
 * @author jmh463
 */
public class NewFib
{
    public static int nFib(int n)
    {
        int[] fib = new int[n];
        for(int i = 0; i < 10; i++)
        {
            fib[i] = 1;
        }
        for(int i = 10; i < n; i++)
        {
            fib[i]=fib[i-3]+fib[i-10];
        }
        return fib[n-1];
   }
    public static void main(String[] args)
    {
        System.out.println("The number in the sequence is: " + nFib(20));
    }    
}