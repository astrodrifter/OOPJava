import java.io.*;

public class addInt2 {

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
		System.out.print("The sum is: ");
		System.out.print(sum);
		System.out.println();

	}

}
