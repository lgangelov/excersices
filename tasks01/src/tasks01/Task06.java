package tasks01;
import java.util.Scanner;

public class Task06 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;
		n = in.nextInt();
		in.close();
		int a=1,b=1,c;
		for(int i=1; i<=n; i++) {
			System.out.print(a+", ");
			c=a+b;
			a=b;
			b=c;
		}
		System.out.println("...");
	}

}
