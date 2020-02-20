package real;
import java.io.File;
import java.util.ArrayList;
// This is the library selection algorithm

public class LibrarySelection  {
    public ArrayList<Library> libSignUpOrder = new ArrayList<Library>(); //Librarys sorted by sign up time and by amount of points in library
    private ArrayList<Library> lib1stSort = new ArrayList<Library>(); //Librarys sorted by just sign up times
    FileIO IO = new FileIO();

    public void libSort(){
        int signUpTime = 1;
        for(int days=1;days<IO.daysForScanning;days++){
            for(int i = 0;i<IO.libraries.size();i++){
                if(IO.libraries.get(i).signUpTime > IO.daysForScanning){
                    i++;
                }
                if(IO.libraries.get(i).signUpTime == days){
                    lib1stSort.add()
                }
            }
        }
    }
}
