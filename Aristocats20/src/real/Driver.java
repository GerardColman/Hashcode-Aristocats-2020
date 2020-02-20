package real;

import java.io.IOException;

public class Driver {

    public static void main(String[] args) throws IOException
    {
        String[] filePaths = {"src/real/a_example.txt", "src/real/b_read_on.txt", "src/real/c_incunabula.txt", "src/real/d_tough_choices.txt", "src/real/e_so_many_books.txt"};

        for(int i = 0; i < 6; i++)
        {
            // File IO
            FileIO io = new FileIO();
            io.getInput(filePaths[i]);

            // Algorithm
            int days = FileIO.daysForScanning;
            LibrarySelection librarySelection = new LibrarySelection(io);

            for(int day = 0; day < days; day++)
            {
                // Run algorithm
                librarySelection.libSort();
            }


            // Output results


        }


    }
}
