package codility;

public class L3_TapeEquilibrium {
	public static void main(String[] args) {
		int answer = solution(new int[] {-1000,1000});
		System.out.println(answer);
	}
	public static int solution(int[] A) {
		int answer = 0;
		int N = A.length;
		int left = A[0],right=0;
		for (int i = 1; i < N; i++) {
			right += A[i];
		}
		
		answer = Math.abs(left-right);
		
		for (int i = 1; i < A.length-1; i++) {
			right-=A[i];
			left+=A[i];
			answer = Math.min(answer,Math.abs(left-right));
		}
		
		return answer;
    }
	
}
