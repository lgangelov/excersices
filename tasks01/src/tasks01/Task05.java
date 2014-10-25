package tasks01;
import java.util.*;

public class Task05 {
	
	public int hexToBase(String hex) {
		String hexLower = hex.toLowerCase();
		int res=0;
		for(int i=hexLower.length()-1, power=0;i>=0;i--,power++) {
			String d = hexLower.substring(i, i+1);
			int tmp=0;
			switch(d) {
			case "a": tmp = 10;break;
			case "b": tmp = 11;break;
			case "c": tmp = 12;break;
			case "d": tmp = 13;break;
			case "e": tmp = 14;break;
			case "f": tmp = 15;break;
			default: tmp = Integer.parseInt(d);
			}
			res+=tmp*Math.pow(16, power);
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Task05 tsk = new Task05();
		String entry;
		System.out.print("Enter HEX to convert: ");
		entry=in.nextLine();
		in.close();
		System.out.println(tsk.hexToBase(entry));
		
		
	}

}
