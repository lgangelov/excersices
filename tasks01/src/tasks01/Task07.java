package tasks01;

import java.util.Arrays;

public class Task07 {
	public boolean isSameDigits(String number1, String number2) {
		char[] arr1 = number1.toCharArray();
		char[] arr2 = number2.toCharArray();
		if(arr1.length != arr2.length)
			return false;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		for(int i = 0; i<4; i++) {
			if(arr1[i]!=arr2[i])
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
//		String num = "1234";
//		int a = Integer.parseInt("1234");
		Task07 tsk = new Task07();
		int c;
		String testNum, currNum;
		for(int i=1200;i<=6880; i++) {
			for(int b=11; b<=Math.sqrt(i); b++) {
				if(i%b!=0)
					continue;
				c=i/b;
				testNum = "" + c + b;
				currNum = "" + i;
				if(tsk.isSameDigits(currNum, testNum)) {
					System.out.println(i + " = " + b + "*" + c);
//					break;
				}
			}
		}

	}

}
