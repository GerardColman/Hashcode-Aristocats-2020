
/*
    Driver Class for HashCode Practice Pizza Problem
 */

import java.util.Arrays;

public class Driver {

    public static int[] readData(PizzaIO io)
    {
        try
        {
            int[] array = io.intialise();

            System.out.println(Arrays.toString(array));
            System.out.println(io.maximum);
            System.out.println(io.diffTypes);

            return array;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {

        String[] filePaths = {"src/a_example.in", "src/b_small.in", "src/c_medium.in", "d_quite_big.in", "e_also_big.in"};

        for(int i = 0; i < filePaths.length; i++) {
            // Read in variables
            PizzaIO io = new PizzaIO();
            int[] array =  readData(io);

            // Apply heuristic

            // Score the result

            // Output result and timing

        }
    }
}
