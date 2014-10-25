package tasks01;

public class TaskVMO {
	public static int solution(int[] A) {
		int f1 = A[0], f2 = A[0];
		for(int i=1; i<A.length; i++) {
			if((A[i]-i)>f1)
				f1 = A[i]-i;
			if((A[i]+i)>f2)
				f2 = A[i]+i;
		}
		return f1+f2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {5,2,3,4,6,6,1,1,1,1,1,1,1,1,1,1,1,1,10,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,9,1};
		System.out.println(A.length);
		System.out.println(solution(A));

	}

}
