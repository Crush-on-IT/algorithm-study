package codility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class L2_CyclicRotation {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[] A= {3, 8, 9, 7, 6};
		int K = 3;
		
		int[] answer = solution(A,K);
		
		for(Integer num : answer) {
			System.out.print(num+" ");
		}
	}
	
	public static int[] solution(int[] A, int K) {
		
		if(A.length <= 1)	return A;
		
		int nK = (K-1)%A.length;
		
		for (int i = 0; i < A.length-1-nK; i++) {
			int first = A[0];
			for (int j = 1; j < A.length; j++) {
				A[j-1] = A[j];
			}
			A[A.length-1] = first;
		}
		
		return A;
    }
	

}
