/* Program prompts user to enter height and width of rectangle from console.
 * Calculates area and prints to console.
 * 
 * 
 */

import java.util.Scanner;
public class RectangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		float h, w, area;
		System.out.print("Enter height of rectangle: ");
		h = keyboard.nextFloat();
		System.out.print("Enter width of rectangle: ");
		w = keyboard.nextFloat();
		area = h*w;
		System.out.printf("Rectangle area = %.2f^2.\n", area);

	}

}
