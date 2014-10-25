package tasks01;

public class Functions {
	public String getHex(int num) {
		switch(num) {
		case 10: return "A";
		case 11: return "B";
		case 12: return "C";
		case 13: return "D";
		case 14: return "E";
		case 15: return "F";
		default: return num+"";
		}
	}
	public String digitToStr(int d, boolean cent) {
		switch(d) {
		case 0: return "����";
		case 1: return cent?"����":"����";
		case 2: return cent?"���":"���";
		case 3: return "���";
		case 4: return "������";
		case 5: return "���";
		case 6: return "����";
		case 7: return "�����";
		case 8: return "����";
		case 9: return "�����";
		default: return "";
		}
	}
	public String decToStr(int d, boolean cent) {
		Functions fn = new Functions();
		if(d < 10)
			return fn.digitToStr(d, cent);
		else if(d == 10)
			return "�����";
		else if(d == 11)
			return "����������";
		else if (d<20)
			return fn.digitToStr(d%10, cent) + "�������";
		else if (d % 10 == 0)
			return fn.digitToStr(d/10, false) + "�����";
		else
			return fn.digitToStr(d/10, false) + "����� � " + fn.digitToStr(d%10, cent);
	}
	
	public String hundToStr(int d) {
		Functions fn = new Functions();
		if(d < 100)
			return fn.decToStr(d, false);
		else if(d == 100)
			return "���";
		else if(d%100 == 0)
			return fn.digitToStr(d/100, false) + (((d/100)<4)?"���":"������");
		else if((d%100)/10 == 0)
			return fn.hundToStr((d/100)*100) + " � " + fn.digitToStr(d%10, false);
		else if(d%10 == 0)
			return fn.hundToStr(d/100*100) + " � " + fn.decToStr(d%100, false);
		else
			return fn.hundToStr(d/100*100) + " " + fn.decToStr(d%100, false);
	}
	
	public String hilToStr(int d) {
		Functions fn = new Functions();
//		String num = Integer.toString(d);
//		int digits = num.length();
		if(d < 1000)
			return fn.hundToStr(d);
		else if(d==1000)
			return "������";
		else if(d%1000 == 0)
			return fn.hundToStr(d/1000) + " ������";
		else if((d%1000)/100==0)
			return fn.hilToStr((d/1000)*1000) + " � " + fn.hundToStr(d%100);
		else if(d%100 == 0)
			return fn.hilToStr((d/1000)*1000) + " � " + fn.hundToStr(d%1000);
		else
			return fn.hilToStr((d/1000)*1000) + " " + fn.hundToStr(d%1000);
	}
}
