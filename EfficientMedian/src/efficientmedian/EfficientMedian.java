package efficientmedian;

/**
 *
 * @author jmh463
 */
public class EfficientMedian
{

    /**
     * This method finds the median of an array using the selection sort method.
     * Only the necessary part of the array is sorted for efficiency.
     * @param values Array of integers
     */
    public static void median(int[] values)
    {
        int i, j, temp;
        double median;

        //Selection sort implemented through two for loops
        for (i = 0; i < values.length/2 + 1; i++)
        {
            for (j = i + 1; j < values.length; j++)
            {
                if (values[i] > values[j])
                {
                    temp = values[i];
                    values[i] = values[j];
                    values[j] = temp;
                }
            }
        }
        
        //Check if the number of elements in the array is odd or even
        if (values.length % 2 == 0)
        {
            //If even, find the average of the two middle elements
            median = (double)(values[(values.length / 2) - 1] + values[values.length / 2]) / 2;
        }
        else
        {
            //If odd, just find the middle element
            median = values[values.length / 2];
        }
        System.out.println("The array's median is " + median);
    }

    /**
     * Tests the median method with sample arrays.
     * @param args not used
     */
    public static void main(String[] args)
    {
        int[] array1 = {567, 2, 600, 6, 601}, array2 = {45, 300, 46, 49};
        median(array1);
        median(array2);
    }
}