package real;
import java.io.File;
import java.util.ArrayList;
// This is the library selection algorithm

public class LibrarySelection  {
    public ArrayList<Library> libSignUpOrder = new ArrayList<Library>(); //Libraries sorted by sign up time and by amount of points in library
    private ArrayList<Library> lib1stSort = new ArrayList<Library>(); //Libraries sorted by just sign up times
    FileIO io = null;

    public LibrarySelection(FileIO io)
    {
        this.io = io;
    }

    public void libSort() {
        int signUpTime = 1;
        int pointerSelect = 0;
        int pointerSort = 0;
        boolean isBiggest = false;
        /*First sorting pass*/
        for(int days=1;days<FileIO.daysForScanning;days++) {
            for(int i = 0;i<io.libraries.size();i++){
                if(io.libraries.get(i).signUpTime > io.daysForScanning){
                    i++;
                }
                if(io.libraries.get(i).signUpTime == days){
                    lib1stSort.add(io.libraries.get(i));
                }
            }
        }
        /*Second sorting pass*/
        for(int i = 0;i<io.daysForScanning;i++){
            for(pointerSelect = 0;pointerSelect<lib1stSort.size();pointerSelect++){
                while(lib1stSort.get(pointerSelect).signUpTime == i) {
                    if (lib1stSort.get(pointerSelect).signUpTime < lib1stSort.get(pointerSort).signUpTime) {
                        pointerSelect = pointerSort;
                    }
                }
            }
        }
        libSignUpOrder = lib1stSort;
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
