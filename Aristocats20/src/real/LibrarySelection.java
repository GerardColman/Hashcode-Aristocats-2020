package real;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
// This is the library selection algorithm

public class LibrarySelection  {
    public ArrayList<Library> libSignUpOrder = new ArrayList<Library>(); //Libraries sorted by sign up time and by amount of points in library
    private ArrayList<Library> lib1stSort = new ArrayList<Library>(); //Libraries sorted by just sign up times
    private ArrayList<Library> tempArray = new ArrayList<>();
    FileIO io = null;

    public LibrarySelection(FileIO io)
    {
        this.io = io;
    }

    public void libSort() {
        int signUpTime = 1;
        /*First sorting pass*/
        for(int days=1;days<FileIO.daysForScanning;days++) {
            tempArray.clear();
            for(int i = 0;i<io.libraries.size();i++){
                if(io.libraries.get(i).signUpTime > io.daysForScanning){
                    i++;
                } else if (io.libraries.get(i).signUpTime == days){
                    tempArray.add(io.libraries.get(i));
                }
            }
            int j = 0;
            while(j != tempArray.size()){
                tempArray.sort(new Comparator<Library>()
                {
                    @Override
                    public int compare(Library o1, Library o2) {
                        return Integer.compare(o1.booksPerDay,o2.booksPerDay);
                    }
                });
                j++;
            }
            libSignUpOrder.addAll(tempArray);
        }
    }
    private int getBlockCount(int blockIndex){ //returns the amount in an individual block
        if(blockIndex == 0){
            return 0;
        }
        int BlockCount = 0;
        int pointer = 0;
        while(lib1stSort.get(pointer).signUpTime != blockIndex){ //get to start of needed block
            pointer++;
        }
        while(lib1stSort.get(pointer).signUpTime != blockIndex + 1){
            BlockCount++;
        }
        return BlockCount;
    }
}
