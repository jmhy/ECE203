package dowhile;

import java.util.Scanner;

/**
 *
 * @author jmh463
 */
public class DoWhile
{
    public static void main(String[] args)
    {
        //Problem 1 - Do While to While
        int day = 0;
        //Request the user to enter the day number
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a day (Sun = 0, Mon = 1,..., Sat = 6): ");
        day = input.nextInt();
        //Check if the day number is valid before printing an empty line
        while((day < 0) || (day > 6))
        {
            //If invalid, request an input again
            System.out.print("Enter a day (Sun = 0, Mon = 1,..., Sat = 6): ");
            day = input.nextInt();
        }
        //Print empty line if the day is valid
        System.out.println();
        
        
        //Problem 2 - For Loop to Do While
        //Request user to enter two integers, the first must be greater in value
        int start = input.nextInt();
        int end = input.nextInt();
        //Print a sequnce of integers and their squares
        do
        {
            int i = start;
            System.out.printf("Integer = %d, Squared = %d%n", i, i*i);
            //Increase starting value by increments of 1
            start++;
        }
        //Perform above actions until start = end
        while(start < end);
    }
}