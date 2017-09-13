/*This program is a conditional operator example
 * condition ? yesExpression : noExpression;
 * Dhruva O'Shea 13/09/17
 */

public class ConditonalOperator {

	public static void main(String[] args) {
		int x = 5, y = 0, minVal;
		minVal = (x > y) ? y : x;
		System.out.println("Min = "+minVal);
	}

}
