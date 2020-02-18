
/*
    Driver Class for HashCode Practice Pizza Problem
 */

import java.util.Arrays;

public class Driver {

    public static int[] readData(PizzaIO io, String path)
    {
        try
        {
            int[] array = io.intialise(path);

            System.out.println(Arrays.toString(array));
            System.out.println(io.maximum);
            System.out.println(io.numOfTypes);

            return array;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {

        String[] filePaths = {"src/a_example.in", "src/b_small.in", "src/c_medium.in", "src/d_quite_big.in", "src/e_also_big.in"};

        for(int i = 0; i < filePaths.length; i++) {
            // Read in variables
            PizzaIO io = new PizzaIO();
            int[] array =  readData(io, filePaths[i]);

            System.out.println("Target: " + io.maximum + ", num of types: " + io.numOfTypes);
            System.out.println(Arrays.toString(array));

            // Apply heuristic

            // Score the result

            // Output result and timing

        }
    }
}
