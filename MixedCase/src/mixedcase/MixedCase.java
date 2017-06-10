package mixedcase;

import java.util.Scanner;

/**
 *
 * @author jmh463
 */
public class MixedCase
{
    private static boolean hasUpper;
    private static boolean hasLower;
    
    /**
     * Main method that does all of the work for this class.
     * @param args not used
     */
    public static void main(String[] args)
    {
        //Detect user input and store it in string s
        Scanner input = new Scanner(System.in);
        System.out.print("Enter String: ");
        String s = input.nextLine();
        
        //Detect if any of the letters entered are upper or lower case
        for(int i = 0; i < s.length(); i++)
        {
            if(Character.isUpperCase(s.charAt(i)))
            {
                hasUpper = true;
            }
            else
            {
                hasLower = true;
            }
        }
        //If all uppercase letters
        if(hasUpper == true && hasLower == false)
        {
            System.out.println("String is all uppercase.");

        }
        //If there is at least one uppercase letter
        else if(hasUpper == true)
        {
            System.out.println("String contains mixed case of letters.");
        }
        //If all lowercase letters
        else
        {
            System.out.println("String contains only lower case letters.");
        }
    }    
}