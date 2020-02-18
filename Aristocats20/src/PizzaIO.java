import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class PizzaIO {
	
	public int maximum = 0;
	public int diffTypes = 0;
	
	public static void main(String[] args) throws FileNotFoundException {

		
	 }
	
	public int[] Intialise() throws FileNotFoundException {
		String c = " ";
		File f = new File("C:/Users/Kealan/Downloads/e_also_big.in");
		Scanner in = new Scanner(f);
		
			
			if(in.hasNextInt()) {
				maximum = in.nextInt();
			}
			
			if(in.hasNextInt()) {
				
				diffTypes = in.nextInt();
			}
			
		int arr[] = new int[diffTypes];
		
		for(int count = 0;count < diffTypes;count++) {
			arr[count] = in.nextInt();
			System.out.println(arr[count]);
		}
		
		in.close();
		return arr;
	}
}
