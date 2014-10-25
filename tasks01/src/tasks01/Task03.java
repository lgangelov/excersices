package tasks01;

public class Task03 {
	public boolean isPrime(int n) {
		if(n<2)
			return false;
		int sq = (int)Math.sqrt(n);
		for(int i = 2; i <= sq; i++) {
			if(n%i == 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task03 tsk = new Task03();
		for(int i = 1; i<=1000; i++) {
			if(tsk.isPrime(i))
				System.out.print(i+" ");
		}
	}

}
