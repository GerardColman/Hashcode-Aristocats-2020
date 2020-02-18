import java.util.Arrays;

public class Heuristic
{

    public int endIndex;

    /*
        Binary search
     */
    private int findEndIndex(int[] array, int target)
    {
        this.endIndex = Arrays.binarySearch(array, target);

        if(endIndex > -1)
        {
            return 1; // Target found
        }
        else // Target not found
        {
            endIndex += 2; // Add two to move to current max item that is less than the target
            endIndex *= -1; // Make the index positive
        }

        return 0;
    }

    public static void main(String[] args)
    {
        int[] array = {1, 2, 4, 5, 6};
        int[] array2 = {1, 2, 3, 4, 5, 6,};

        Heuristic h = new Heuristic();

        h.findEndIndex(array, 3);

        System.out.println("End index: " + h.endIndex);
        h.findEndIndex(array2, 3);

        System.out.println("End index: " + h.endIndex);

    }


}
