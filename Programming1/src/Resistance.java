/*This program takes current and volts from console 
 * and prints resistance to console.
 * 
 * Dhruva O'Shea 06/09/17
 */
import java.io.*;
import java.util.Scanner;

public class Resistance {

	public static void main(String[] args) throws IOException {
		
		// open scanner
		Scanner keyboard = new Scanner(System.in);
		
		// get inputs
		float amps, volts, resistance;
		System.out.print("Enter Amps value: ");
		amps = keyboard.nextInt();
		System.out.print("Enter Volts value: ");
		volts = keyboard.nextInt();
		
		// calculate
		resistance  = amps*volts;
		
		//Print result to console
		System.out.println("Resistance = " + resistance + " Ohms.");

	}

}
