package real;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileIO {
    public static void main(String[] args) throws IOException {
        InputOutput p = new InputOutput();
        String[] fileNames = {"a_example"};

        p.getInput(fileNames[0]);
    }

    public void getInput(String fileName) throws IOException{

        BufferedReader in = new BufferedReader(new FileReader("input\\" + fileName + ".in"));

        String line;
        line = in.readLine();
        line.trim();

        String[] use;
        use = line.split(" ");
        in.close();

    }

    public void printOutput(String fileName) throws FileNotFoundException {

        //System.out.println("\n-------- output " + fileName);
        PrintWriter out = new PrintWriter("output\\" + fileName + ".in");
        out.println();
        out.close();
    }

}
