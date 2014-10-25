package tasks01;
//finds index of an array that the sum of all previous and all after is equal
public class TaskVM {
	public static int solution(int[] A) {
		double lowSum = 0, highSum = 0;
		for(int i=0; i<A.length; i++) {
			highSum += A[i];
		}
		for(int k = 0; k<A.length; k++) {
			if(k!=0)
				lowSum+=A[k-1];
			highSum -= A[k];
			if(lowSum==highSum)
				return k;
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2, -1, 1};
		System.out.println(solution(A));

	}

}
