
public class Swap {

	public static void main(String[] args) {
		int num1 = 4;
		int num2 = 6;
		
		System.out.println("Before " + num1 + " " + num2);
		
		//swap
		int temp;
		temp = num1;
		num1 = num2;
		num2 = temp;
		
		System.out.println("After " + num1 + " " + num2);
	}

}
