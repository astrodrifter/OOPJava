package classesBasic;
import java.io.*;
import java.util.*;
public class FileRead {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String word, filename;
		
		System.out.println("Enter file name: ");
		filename = sc.nextLine();
		
		System.out.println("Enter word: ");
		word = sc.nextLine();
		
		Scanner fileScanner = new Scanner(new FileReader(filename));
		
		String line;
		int matchingLines = 0;
		
		while(fileScanner.hasNextLine()) {
			line  = fileScanner.nextLine();
			
			if(line.indexOf(word) >= 0) {
				matchingLines ++;
			}
		}
		
		System.out.println("Text file "+filename
				+" has the word on "+matchingLines+" lines.");

	}

}
