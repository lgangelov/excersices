package tasks01;
import java.util.Scanner;

public class Task04 {
	public static String baseToHex(int num) {
		String result = "";
		Functions f = new Functions();
		while(num>=1) {
			int r = num % 16;
			num /= 16;
			result = f.getHex(r) + result;
		}
		return result;
	}
	public static void main(String[] args) {
		String str = new String();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter decimal to convert: ");
		int num = sc.nextInt();
//		str = tsk.baseToHex(428591);
		str = baseToHex(num);
		System.out.println("HEX: "+str);
		sc.close();

	}

}
