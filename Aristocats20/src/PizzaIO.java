import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class PizzaIO {
	
	public int maximum = 0;
	public int numOfTypes = 0;
	
	public int[] intialise(String path) throws FileNotFoundException {
		String c = " ";
		File f = new File(path);
		Scanner in = new Scanner(f);
		
			
			if(in.hasNextInt()) {
				maximum = in.nextInt();
			}
			
			if(in.hasNextInt()) {
				
				numOfTypes = in.nextInt();
			}
			
		int arr[] = new int[numOfTypes];
		
		for(int count = 0; count < numOfTypes; count++) {
			arr[count] = in.nextInt();
		}
		
		in.close();
		return arr;
	}
}
