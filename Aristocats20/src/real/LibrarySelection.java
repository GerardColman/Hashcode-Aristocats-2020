package real;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
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

        lib1stSort = io.libraries;

        lib1stSort.sort(new Comparator<Library>()
        {
            @Override
            public int compare(Library o1, Library o2) {
                return Integer.compare(o1.signUpTime, o2.signUpTime);
            }
        });

        for(int days = 1; days < FileIO.daysForScanning; days++)
        {
            break;
        }

        libSignUpOrder = lib1stSort;
    }
}
