import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintfExample {

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader (System.in));
		
		String string1, string2;
		int num1, num2, sum;
		
		System.out.println("Input an integer number");
		string1  = stdin.readLine();
		
		num1 = Integer.parseInt(string1);
		
		System.out.println("Input another integer number");
		string2  = stdin.readLine();
		
		num2 = Integer.parseInt(string2);

		sum = num1 + num2;
		System.out.printf("The sum of %d and %d =  %d.\n",num1, num2, sum);
	}

}
