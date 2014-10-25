package tasks01;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Task08 {

	public static void main(String[] args) {
		double a = 10;
		Scanner in = new Scanner(System.in);
		System.out.print("Sqrt of: ");
		double num = in.nextDouble();
		in.close();
		double c = 1;
//		double num = 612;
		while((int)(a*Math.pow(10, 5))!=(int)(c*Math.pow(10, 5))) {
			c = a;
			a = a-(Math.pow(a, 2)-num)/(2*a);
		}
		DecimalFormat df = new DecimalFormat("#.#####");
		System.out.println("Result: " + df.format(a));

	}

}
