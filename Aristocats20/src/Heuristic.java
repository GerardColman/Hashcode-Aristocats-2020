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

    public int sum(){
        int sum1 = 0;
        for(int i = 0; i < arrayList.size(); i++){
            sum1 += arrayList.get(i);
        }
        return sum1;
    }

    // This loops through the array till the sum of the elements in the ArrayList is equal to
    public void CheckSum(int[] input, int finalSum){
        boolean firstLoop = false;
        boolean secondLoop = false;
        int a = 0;
        int b = 0;
        int newIndex;
        while(!firstLoop){
            newIndex = endIndex - a; // Setting up my new endIndex
            secondLoop = false; // Resetting secondLoop flag
            b = 0;
            while(!secondLoop){
                if(sum() == finalSum){
                    firstLoop = true;
                    break;
                } else {
                    if (arrayList.isEmpty()) {
                        arrayList.add(newIndex); // add top element to arrayList
                        b++; // increment index
                    } else if (newIndex <= b) {
                        arrayList.clear();
                        secondLoop = true; // Exiting secondLoop
                    } else if ((sum() + input[b]) < finalSum) { // If the new sum is less than finalSum add the index to the arrayList
                        arrayList.add(newIndex - b); // Adding new index to arrayList
                        b++; // Increment index
                    }
                }
            }
            a++;
        }

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
