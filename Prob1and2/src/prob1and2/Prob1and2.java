package prob1and2;

/**
 *
 * @author jmh463
 */
public class Prob1and2
{
    public static void spread(int[] values)
    {
        int max = values[0];
        int min = values[0];
        for (int i = 1; i < values.length; i++)
        {
            if (values[i] > max)
            {
                max = values[i];
            }
        }
        for (int i = 1; i < values.length; i++)
        {
            if (values[i] < min)
            {
                min = values[i];
            }
        }
        System.out.println("The spread of this array is " + (max - min));
    }
    public static void distinct(int[] values)
    {
        for (int i = 0; i < values.length; i++)
        {
            boolean isDistinct = false;
            for(int j = 0; j < i; j++)
            {
                if(values[i] == values[j])
                {
                    isDistinct = true;
                    break;
                }
            }
            if(!isDistinct)
            {
                System.out.print(values[i] + " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] array2 = {5, 3, 7, 3, 18, 6, 9, 10, 2, 14};
        int[] array3 = {0, 1, 2, 3, 4};
        spread(array1);
        spread(array2);
        spread(array3);    
        int[] array4 = {2, 3, 2, 4, 4, 3, 1, 3};
        distinct(array4);
    }
}