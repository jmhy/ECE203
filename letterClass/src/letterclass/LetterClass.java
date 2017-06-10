package letterclass;

import java.util.Scanner;

/**
 *
 * @author jmh463
 */
public class LetterClass
{

    /**
     * Main method that does all of the work for this class.
     * @param args not used
     */
    public static void main(String[] args)
    {
        //Detect user input and store it in string s
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        String s = input.nextLine();
        
        //Check what type of letter it is
        String letterType;
        switch(s)
        {
            case "a":
            case "e":
            case "i":
            case "o":
            case "u":
                letterType = "vowel";
                break;
            case "y":
            case "w":
                letterType = "semi-vowel";
                break;
            //If neither of the above conditions are met, return a consonant    
            default: letterType = "consonant";
        }
        System.out.println(letterType);
    }    
}