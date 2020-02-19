
/*
    Driver Class for HashCode Practice Pizza Problem
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Driver {

    public static int parseData(int[] array, int target, int endIndex, ArrayList<Integer> indices)
    {
        int sum = 0;
        int i = endIndex;
        int numPizzas = 0;

        while(i >= 0 && sum != target)
        {
            if(sum + array[i] < target)
            {
                sum += array[i];
                numPizzas++;
                indices.add(i);
            }
            i--;
        }

        if(sum == target)
        {
            //System.out.println("We did it!");
        }

        // System.out.println("Sum: " + sum);

        return numPizzas;
    }

    public static int[] readData(PizzaIO io, String path)
    {
        try
        {
            int[] array = io.intialise(path);

           // System.out.println(Arrays.toString(array));
           // System.out.println(io.maximum);
           // System.out.println(io.numOfTypes);

            return array;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        return null;
    }

    public static int calculateScore(ArrayList<Integer> indices, int[] array) {
        int sum = 0;

        for(int i = 0; i < indices.size(); i++)
        {
            sum += array[indices.get(i)];
        }

        return sum;
    }

    public static void main(String[] args) {

        String[] filePaths = {"src/a_example.in", "src/b_small.in", "src/c_medium.in", "src/d_quite_big.in", "src/e_also_big.in"};

        for(int i = 0; i < filePaths.length; i++) {
            // Read in variables
            PizzaIO io = new PizzaIO();
            int[] array =  readData(io, filePaths[i]);

            //System.out.println("Target: " + io.maximum + ", num of types: " + io.numOfTypes);
            // System.out.println(Arrays.toString(array));

            // Apply heuristic
            Heuristic h = new Heuristic();
            h.findEndIndex(array, io.maximum);


            ArrayList<Integer> indices = new ArrayList<>();
            int count = parseData(array, io.maximum, h.endIndex, indices);

            System.out.println(count);

            for(int j = 0; j < indices.size(); j++)
            {
                System.out.print(indices.get(j) + " ");
            }

            System.out.println();

            // Score the result

            // Output result and timing

        }
    }
}
