package calendar;

import java.util.Scanner;

/**
 *
 * @author jmh463
 */
public class Calendar
{
    private static int numDays = 0;
    private static int h = 0;

    /**
     * This method determines if a specified year is a leap year.
     * @param year The year in YYYY.
     * @return True if leap year, false if not.
     */
    public static boolean leap(int year)
    {
        if(((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Determines the first day of the year using Zeller's Congruence.
     * @param year The year (YYYY)
     */
    public static void firstDayOfYear(int year)
    {
        //January is counted as month 13 of the previous year
        int month = 13;
        year--;
        
        //Zeller's Congruence formula
        h = (1 + (int)(((month + 1) * 26) / 10.0) + year + (int)(year / 4.0) + 6 * (int)(year / 100.0) + (int)(year / 400.0)) % 7;
        String dayName = "";
        
        //Take number (0-6) from Zeller's Congruence to determine the day
        //0 represents Saturday
        switch(h)
        {
            case 0: dayName = "Saturday"; break;
            case 1: dayName = "Sunday"; break;
            case 2: dayName = "Monday"; break;
            case 3: dayName = "Tuesday"; break;
            case 4: dayName = "Wednesday"; break;
            case 5: dayName = "Thursday"; break;
            default: dayName = "Friday"; break;
        }
        System.out.println("The first day of the year is " + dayName);
    }

    /**
     * Determines the first day of the month using Zeller's Congruence.
     * @param month Month index (1-12)
     * @param year The year (YYYY)
     */
    public static void firstDayOfMonth(int month, int year)
    {
        //Check if the month is Jan or Feb
        if(month == 1 || month == 2)
        {
            month += 12;
            year--;
        }
        
        //Zeller's Congruence formula
        h = (1 + (int)(((month + 1) * 26) / 10.0) + year + (int)(year / 4.0) + 6 * (int)(year / 100.0) + (int)(year / 400.0)) % 7;
        String dayName = "";
        
        //Take number (0-6) from Zeller's Congruence to determine the day
        //0 represents Saturday
        switch(h)
        {
            case 0: dayName = "Saturday"; break;
            case 1: dayName = "Sunday"; break;
            case 2: dayName = "Monday"; break;
            case 3: dayName = "Tuesday"; break;
            case 4: dayName = "Wednesday"; break;
            case 5: dayName = "Thursday"; break;
            default: dayName = "Friday"; break;
        }
        System.out.println("The first day of the month is " + dayName);
    }

    /**
     * Determine the number of days in a month.
     * @param month Month index (1-12)
     * @param year The year (YYYY)
     */
    public static void numDaysInMonth(int month, int year)
    {
        //Index of all 12 months of the year
        int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        //Modify the index if there is a leap year
        if (month == 2 && leap(year)) days[month] = 29;
        
        //For use in the printCal method
        numDays = days[month];
        
        //Print the number of days
        System.out.println("The number of days in the month is " + numDays);
    }

    /**
     * Prints a calendar for a specified month and year based on the Gregorian
     * Calendar. Omits days that are part of other months.
     * @param month Month index (1-12)
     * @param year The year (YYYY)
     */
    public static void printCal(int month, int year)
    {
        //Index of month names
        String[] monthNames = {"","January","February","March","April","May","June","July","August","September","October","November","December"};
        
        //Print the month and year at the top of the calendar
        System.out.println("    " + monthNames[month] + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");
        
        //Start printing day numbers from the first day of the month
        int h2 = (h == 0 ? 7 : h);
        for (int i = h2; i > 1; i--)
            System.out.print("   ");
        
        //Keep printing numbers until the last day is reached
        for (int i = 1; i <= numDays; i++)
        {
            System.out.printf("%2d ", i);
            //Create a new line after reaching the end of the week
            if (((i + h - 1) % 7 == 0) || (i == numDays)) System.out.println();
        }
    }

    /**
     * The main method of the class; this implements all of the other methods. 
     * The user is requested to enter a month and year. Then, print the calendar.
     * @param args Not used
     */
    public static void main(String[] args)
    {
        //Request the month
        Scanner input = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();
        
        //Check if month is valid
        if(month < 1 || month > 12)
        {
            System.out.println("Invalid month. Valids inputs are 1-12.");
            System.exit(0);
        }
        
        //Request the year
        System.out.print("Enter year: ");
        int year = input.nextInt();
        
        //Year must be no earlier than 1753
        if(year < 1753)
        {
            System.out.println("Invalid year. Valid inputs are 1753 and beyond.");
            System.exit(0);
        }
        
        //Check if the entered year is a leap year
        if(leap(year))
        {
            System.out.println(year + " is a leap year.");
        }
        else
        {
            System.out.println(year + " is NOT a leap year.");
        }
        
        //Implementation of the other methods of this class
        firstDayOfYear(year);
        firstDayOfMonth(month, year);
        numDaysInMonth(month, year);
        printCal(month, year);
    }    
}