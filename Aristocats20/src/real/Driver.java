package real;

import java.io.IOException;

public class Driver {

    public enum SignUp {READY, IN_PROGRESS}
    SignUp signUpStatus = SignUp.READY;

    int currentSignUpDaysRemaining = 0;

    public static void main(String[] args) throws IOException
    {
        Driver d = new Driver();

        String[] filePaths = {"src/real/a_example.txt", "src/real/b_read_on.txt", "src/real/c_incunabula.txt", "src/real/d_tough_choices.txt", "src/real/e_so_many_books.txt"};

        for(int i = 0; i < 6; i++)
        {
            // File IO
            FileIO io = new FileIO();
            io.getInput(filePaths[i]);

            // Algorithm
            int days = FileIO.daysForScanning;
            LibrarySelection librarySelection = new LibrarySelection(io);
            BooksScanned scanningFacility = new BooksScanned(days);

            for(int day = 0; day < days; day++)
            {
                if(d.currentSignUpDaysRemaining == 0) // Check sign up status
                {
                    d.signUpStatus = SignUp.READY;
                }

                // Run algorithm
                librarySelection.libSort();

                // Sign up a library
                if(d.signUpStatus == SignUp.READY)
                {
                    Library currentLib = librarySelection.libSignUpOrder.get(0); // current lib to sign up
                    d.currentSignUpDaysRemaining = currentLib.signUpTime; // set the current sign up days
                    scanningFacility.signUpLibrary(currentLib); // Sign up the library
                    librarySelection.libSignUpOrder.remove(0); // Remove from queue

                    d.signUpStatus = SignUp.IN_PROGRESS; // Mark in progress
                }


                // For each library in the ScanningFacility
                // Scan the max books required

                for(int lib2Scan = 0; lib2Scan < scanningFacility.libraries.size(); lib2Scan++)
                {

                }

                // End of loop, one day passed
                if(d.signUpStatus == SignUp.IN_PROGRESS)
                {
                    d.currentSignUpDaysRemaining--; // Decrement days
                }
            }


            // Output results


        }


    }
}
