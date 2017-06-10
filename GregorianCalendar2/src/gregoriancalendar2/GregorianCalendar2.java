package gregoriancalendar2;
/**
 *
 * @author jmh463
 */

//Import classes needed for the code
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

//Create a class and call it BillionSecondsOld
public class GregorianCalendar2
{
    //Create a main method
    public static void main(String[] args)
    {
        //Create a calendar and set date of birth to January 11, 1993
        GregorianCalendar dateOfBirth = new GregorianCalendar(1993, GregorianCalendar.JANUARY, 11);
        
        //Print date of birth
        System.out.println("Date of Birth:");
        System.out.println(new SimpleDateFormat("MMMM dd yyyy").format(dateOfBirth.getTime()));
        
        //Add 1 billion seconds to date of birth
        dateOfBirth.add(GregorianCalendar.SECOND, 1000000000);
        
        //Return the date that I will be 1 billion seconds old (should be September 19, 2024)
        System.out.println("When I will be 1 billion seconds old:");
        System.out.println(new SimpleDateFormat("MMMM dd yyyy").format(dateOfBirth.getTime()));
    }
}
