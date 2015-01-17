package firstSteps;
import java.util.Scanner;

public class testing {

	public static void main(String[] args) {
		System.out.println("Enter name:");
		Scanner in = new Scanner(System.in);
		String name;
		name = in.nextLine();
		in.close();
		System.out.println(name + " shte mi naprawish li edna?");
		String[] list = new String[]{"edno", "dve", "tri", "chetiri"};
		for(int i = 0; i<list.length; i++) {
			// TODO kvoot si iskam
			int output = convert(list[i]);
			if (output == 3)
				System.out.print("Ne, shti naprava " + output + " ");
		}
	}
	public static int convert(String str) {
		switch(str) {
			case "edno" : return 1;
			case "dve" : return 2;
			case "tri" : return 3;
			case "chetiri" : return 4;
			default : return -1;
		}
	}

}
