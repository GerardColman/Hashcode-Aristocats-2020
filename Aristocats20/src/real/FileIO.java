package real;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileIO {
	
	ArrayList<Library> libraries = new ArrayList<Library>();
	
	public static void main(String[] args) throws IOException {
		FileIO p = new FileIO();
		String[] fileNames = {"a_example"};
		
		p.getInput(fileNames[0]);
	}
	
	public void getInput(String fileName) throws IOException{
		int sum = 0;
        BufferedReader in = new BufferedReader(new FileReader("input\\" + fileName + ".in"));

        String firstline, secondline, libraryInfo, bookInfo;
        firstline = in.readLine();
        secondline = in.readLine();

        firstline.trim();
        secondline.trim();
        String[] first, second, library, book;

        first = firstline.split(" ");
        second = secondline.split(" ");

        for(int count = 0;count < Integer.parseInt(first[1]);count++){
            libraryInfo = in.readLine();
            bookInfo = in.readLine();
            libraryInfo.trim();
            bookInfo.trim();
            library = libraryInfo.split(" ");
            book = bookInfo.split(" ");
            
            ArrayList<Book> bookArr = new ArrayList<Book>();
            for(int i = 0;i<Integer.parseInt(library[0]);i++) {
            	
            	int temp = Integer.parseInt(book[i]);
            	sum = sum + Integer.parseInt(second[temp]);
            	Book n = new Book(Integer.parseInt(book[i]), Integer.parseInt(second[temp]));
            	bookArr.add(n);
            }
            
            Library a = new Library(count ,bookArr,  Integer.parseInt(library[1]), Integer.parseInt(library[2]), sum);
            libraries.add(a);
        }
        in.close();

    }
	public void printOutput(String fileName) throws FileNotFoundException {
		
		//System.out.println("\n-------- output " + fileName);
		PrintWriter out = new PrintWriter("output\\" + fileName + ".in");
			out.println();
			out.close();
	}
	
}

