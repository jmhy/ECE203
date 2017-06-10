package holleprinter;

/**
 *
 * @author jmh463
 */

//Create a class called "HollePrinter"
public class HollePrinter
{
    //Declare a main method
    public static void main(String[] args)
    {
        //Create a string 'greeting' with specified text, i.e. Hello, World!
        String greeting="Hello, World!";
        
        //Print out string 'greeting'
        System.out.println("Original Greeting: " + greeting);
        
        //Swap the e's with the o's in the string
        String greeting2 = greeting.replace("o","*").replace("e","o").replace("*","e");
        
        //Print out the modified string with the swapped letters
        System.out.println("Greeting with e's and o's swapped: " + greeting2);
    }
}
