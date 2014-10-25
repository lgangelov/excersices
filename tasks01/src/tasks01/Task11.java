package tasks01;
import java.util.Random;
import java.util.Scanner;

public class Task11 {
	public String checkInput(int[] A, int input) {
		int i1 = input/1000, i2 = input/100%10, i3 = input/10%10, i4 = input%10;
		int[]B = {i1, i2, i3, i4};
		int bulls=0;
		int cows=0;
		for(int a=0; a<A.length; a++) {
			for(int b=0; b<B.length; b++) {
				if(A[a] == B[b] && a==b)
					bulls++;
				else if(A[a]==B[b])
					cows++;
			}
		}
		if(bulls == 4)
			return "You won!";
		else
			return "You have "+bulls+" bulls and "+cows+" cows.";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int a2=0, a3=0, a4=0;
		int a1 = rand.nextInt(9)+1;
		while(a2==a1) {
			a2 = rand.nextInt(10);
		}
		while(a3==a1 || a3==a2) {
			a3 = rand.nextInt(10);
		}
		while(a4==a1 || a4==a2 || a4==a3) {
			a4 = rand.nextInt(10);
		}
		int[]A = {a1, a2, a3, a4};
		int num = a1*1000+a2*100+a3*10+a4;
		Scanner in = new Scanner(System.in);
		int input;
		int attempts=0;
		Task11 tsk = new Task11();
		System.out.println(num);
		do {
			input = in.nextInt();
			System.out.println(tsk.checkInput(A, input));
			attempts++;
		}
		while(num!=input && attempts<=10);
		in.close();
	}

}
