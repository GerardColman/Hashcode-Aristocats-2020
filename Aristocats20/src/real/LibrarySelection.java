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
    }
}
