package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.Checksum;

public class Heuristic {

    ArrayList<Integer> arrayList = new ArrayList<>(); // ArrayList of indexes to be returned
    public int endIndex;

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 6};
        int[] array2 = {1, 2, 3, 4, 5, 6,};

        Heuristic h = new Heuristic();

        h.findEndIndex(array, 3);

        System.out.println("End index: " + h.endIndex);
        h.findEndIndex(array2, 3);

        System.out.println("End index: " + h.endIndex);

        h.CheckSum(array, 3);

    }


    // This loops through the array till the sum of the elements in the ArrayList is equal to
    public void CheckSum(int[] input, int finalSum){
        int newIndex =  input.length;
        int max = 0;

        for(int i = newIndex - 1; i >= 0; i--){
            Integer size  = i;
            Integer sum = 0;
            ArrayList<Integer> currentList = new ArrayList<Integer>();

            for(int j = size; j >= 0; j--){
                Integer currentValue = input[j];
                Integer tempSum = sum + currentValue;

                if(tempSum == finalSum){
                    sum = tempSum;
                    currentList.add(j);
                    break;
                } else if(tempSum > finalSum){
                    continue; // Try next element
                } else if(tempSum < finalSum){
                    sum = tempSum;
                    currentList.add(j);
                    continue; // Try next element
                }
            }

            if(sum > max){
                max = sum;
                arrayList = currentList;
            }
        }
        System.out.println(arrayList.toString());
    }

    /*
        Binary search
     */
    public int findEndIndex(int[] array, int target) {
        this.endIndex = Arrays.binarySearch(array, target);

        if (endIndex > -1) {
            return 1;// Target found
        } else { // Target not found
            endIndex += 2; // Add two to move to current max item that is less than the target
            endIndex *= -1; // Make the index positive
        }

        return 0;
    }

}
