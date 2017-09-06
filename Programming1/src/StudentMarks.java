/* This program takes marks for three students and
 * 1. calculates average mark, 2. Find student with 
 * highest mark 3. finds student with the lowest mark.
 * 
 * Dhruva O'Shea 06/09/17
 */


import java.util.Scanner;
public class StudentMarks {

	public static void main(String[] args) {
		// get student marks input using scanner
		Scanner keyboard = new Scanner(System.in);
		float st1, st2, st3;
		System.out.print("Enter mark for student 1: ");
		st1 = keyboard.nextFloat();
		System.out.print("Enter mark for student 2: ");
		st2 = keyboard.nextFloat();
		System.out.print("Enter mark for student 3: ");
		st3 = keyboard.nextFloat();
		System.out.printf("st1 = %.2f, st2 = %.2f, st3 = %.2f\n", st1, st2, st3);
		
		// calculate average mark
		float ave;
		ave = (st1+st2+st3)/3;
		System.out.println("Average mark = " + ave);
		
		// find max
		float max, min;
		max = Math.max(st1, st2);
		max = Math.max(max, st3);
		System.out.println("Max mark is " + max);
		
		//find min
		min = Math.min(st1, st2);
		min = Math.min(min, st3);
		System.out.println("Min mark is " + min);
		
		
	}

}
