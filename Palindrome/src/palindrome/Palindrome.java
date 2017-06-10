package palindrome;

import java.util.Scanner;

/**
 *
 * @author jmh463
 */
public class Palindrome
{

    /**
     * Main method that does all of the work for this class.
     * @param args not used
     */
    public static void main(String[] args)
    {
        //Create empty string 'reverse' to be used later
        String reverse = "";
        
        //Detect user input and store it in string s
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();
        
        //For each iteration, add the orginal letters to the reverse string
        for(int i = 0; i < s.length(); i++)
        {
            reverse = reverse + s.charAt(i);
        }
        
        //Check if the original string is equal to the reverse
        if(s.equalsIgnoreCase(reverse))
        {
            System.out.println("This is a palindrome.");
        }
        else
        {
            System.out.println("This is not a palindrome.");
        }
    }    
}