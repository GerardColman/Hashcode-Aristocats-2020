package practice;
/*
    Driver Class for HashCode Practice Pizza Problem
 */

import java.util.ArrayList;

public class Driver {

    public ArrayList<Integer> indices;
    public int count = 0;

    public int parseData(int[] array, int target, int endIndex, ArrayList<Integer> indices)
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

    public void parsingHeuristic(int[] array, int target, int endIndex)
    {
        int count = 0;
        int curMax = 0;
        ArrayList<Integer> tempIndices = new ArrayList<>();
        ArrayList<Integer> maxIndices = new ArrayList<>();

        for(int i = 0; i <= endIndex; i++)
        {
            int tempCount = parseData(array, target, (endIndex - i), tempIndices);

            if(calculateScore(tempIndices, array) > curMax)
            {
                maxIndices = (ArrayList<Integer>) tempIndices.clone();
                count = tempCount;
                curMax = calculateScore(tempIndices, array);
            }

            tempIndices.clear();
        }

        indices = maxIndices;
        this.count = count;
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

        String[] filePaths = {"src/practice/a_example.in", "src/practice/b_small.in", "src/practice/c_medium.in", "src/practice/d_quite_big.in", "src/practice/e_also_big.in"};

        Driver d = new Driver();

        for(int i = 0; i < filePaths.length; i++) {
            // Read in variables
            PizzaIO io = new PizzaIO();
            int[] array =  readData(io, filePaths[i]);

            //System.out.println("Target: " + io.maximum + ", num of types: " + io.numOfTypes);
            // System.out.println(Arrays.toString(array));

            // Apply heuristic
            Heuristic h = new Heuristic();
            h.findEndIndex(array, io.maximum);

            d.parsingHeuristic(array, io.maximum, h.endIndex);

            h.CheckSum(array, io.maximum);

            System.out.println(io.maximum);

            // h.CheckSum(array, io.maximum);

            System.out.print("ParsingHeuristic Score: ");
             System.out.println(calculateScore(h.arrayList, array));

             //System.out.println(d.count);


            for(int j = 0; j < h.arrayList.size(); j++)
            {
                System.out.print(h.arrayList.get(j) + " ");
            }




            System.out.println();

            System.out.println("------------------------- SCORE -------------------------");
            System.out.println("Score: " + calculateScore(h.arrayList, array));

            // Score the result

            // Output result and timing

        }
    }
}
