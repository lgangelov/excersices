package tasks01;

public class Task12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double num = 999999.99;
		int a = (int)((num*100)/100);
//		int dec = a/10;
//		int digit = a%10;
		int st = (int)(num*100%100);
		Functions fn = new Functions();
		String stotinki;
//		if(st<10)
//			stotinki = " � " + fn.digitToStr(st, true) + " ��������";
//		else
			stotinki = " � " + fn.decToStr(st, true) + " ��������";
			System.out.println(fn.hilToStr(a) + " ����" + stotinki);
			System.out.println(a + " " + st);
//		if(a<20)
//			System.out.println(fn.decToStr(a, false) + " ����" + stotinki);
//		else
//			System.out.println(fn.digitToStr(dec, false) + fn.decToStr(10, false) + " � " + fn.digitToStr(digit, false) + " ����" + stotinki);
	}

}
