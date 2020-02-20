package real;
import java.io.*;
import java.util.ArrayList;

public class FileIO {
	
	ArrayList<Library> libraries = new ArrayList<Library>();
	public static int booksForScanning;
	public static int daysForScanning;
	public static int librariesForScanning;
	public static int[] bookScores;
	
	public static void main(String[] args) throws IOException {
		FileIO p = new FileIO();
		String[] fileNames = {"src/real/a_example.txt"};
		
		p.getInput(fileNames[0]);

        System.out.println(p.libraries.toString());

	}
	
	public void getInput(String fileName) throws IOException
    {
		int sum = 0;
        BufferedReader in = new BufferedReader(new FileReader(fileName));

        String firstline, secondline, libraryInfo, bookInfo;
        firstline = in.readLine();
        secondline = in.readLine();

        firstline.trim();
        secondline.trim();
        String[] first, second, library, book;

        first = firstline.split(" ");
        second = secondline.split(" ");

        bookScores = new int[Integer.parseInt(first[0])];
        
        for(int count = 0;count < second.length;count++)
        {
        	bookScores[count] = Integer.parseInt(second[0]);
        }
        
        booksForScanning = Integer.parseInt(first[0]);
        librariesForScanning = Integer.parseInt(first[1]);
        daysForScanning = Integer.parseInt(first[2]);
        
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
	
	public void printOutput(String fileName, BooksScanned B) throws FileNotFoundException, UnsupportedEncodingException {
		
		//System.out.println("\n-------- output " + fileName);
		PrintWriter out = new PrintWriter("output\\" + fileName + ".out", "UTF-8");
		
			out.println(B.getNumLibsSignedUp());
			for(int count = 0;count < B.getNumLibsSignedUp();count++) {
				out.println(" " + libraries.get(count).l_id + " " + libraries.get(count).booksScanned);
				out.println(libraries.get(count).scanRecords);
			}
			out.close();
	}
	
}
