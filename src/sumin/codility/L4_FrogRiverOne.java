package codility;


public class L4_FrogRiverOne {
	public static void main(String[] args) {
		int answer = solution(5,new int[] {1,3,1,4,2,3,5,4});
		System.out.println(answer);
	}
	
	public static int solution(int X, int[] A) {
		int answer = -1;
		
		boolean[] visited = new boolean[X+1];
		int cnt = 0;
		
		for(int i = 0 ; i < A.length;++i) {
			if(A[i]<=X && !visited[A[i]]) {
				visited[A[i]] = true;
				++cnt;
			}
			if(cnt==X) {
				answer = i;
				break;
			}
		}
		
		
		
		return answer;
    }
}
