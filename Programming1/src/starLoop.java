import java.io.*;
public class starLoop {

	public static void main(String[] args) {
		
		
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

	}

}
