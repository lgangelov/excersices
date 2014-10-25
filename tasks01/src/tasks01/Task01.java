package tasks01;
import java.util.Random;

public class Task01 {

	public static void main(String[] args) {
		Random rand = new Random();
		int a1 = rand.nextInt(6)+1;
		int a2 = rand.nextInt(6)+1;
		if (a1==a2)
			System.out.println("Dushesh " + (a1 + a2));
		else
			System.out.println(a1+" and "+a2+" = "+ (a1+a2));

	}

}
