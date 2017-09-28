import java.io.*;
public class starLoop {

	public static void main(String[] args) throws IOException {
		//open buffer reader
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 1;
		for(int i = 0; i < 7; i++) {
			System.out.print("\n");
			for(int j = 0; j < count; j++) {
				System.out.print("*");
				
			}
			if(count == 3) {
				for(int k = 0; k < count-1; k++) {
					System.out.print("*");
				}
				count = 0;
			}
			
			count++;
		}
		System.out.print("\n");
		int sum = 0, num = 5;
		while(sum < 1000) {
			num = num*2;
			sum +=num;
			System.out.print(num+" ");
			
		}
		/* Write a do loop which will continue to read 
		 * positive integers and sum them until two consecutive 
		 * integers entered are identical. The second identical 
		 * integer should not be included in the sum. 
		 * For example, if the user input 10 20 10 30 30 then the 
		 * final value of sum should be 70 (10 + 20 + 10 + 30).
		 */
		
		int num1, num2;
		do {
			System.out.println("Enter an integer: ");
			num1 = keyboard,readLine();			
		} while(num1 != num2);

	}

}
