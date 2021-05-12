import java.util.Scanner;

public class 백준_5904_Moo게임_oct14jh {
	/*N, 결과값answer 그리고 moo로구성될 문자열 길이 값 Sk 배열 */
	private static int N;
	private static int[] SkLength = new int[28];	// 28로 둔 이유는 N최대값 10억인데 28로 두면, 약 10억7천만까지 값 체킹 가능
	private static char answer;
	
	public static void main(String[] args) {
		
		Scanner sc = new  Scanner(System.in);
		N = sc.nextInt();
		
		SkLength[0] = 3;
		for(int i = 1; i < SkLength.length; i++) {
			SkLength[i] = (2 * SkLength[i-1]) + (i + 3);	// S[1], S[2] ... 의 문자열 길이 값 미리 계산
		}
		
		answer = DP(N);
		System.out.println(answer);
		sc.close();
	}

	private static char DP(int n) {
		int k = 0;	
		
		if(n == 1)
			return 'm';
		if(n == 2 || n == 3)
			return 'o';
		
		while(n > SkLength[k])
			k++;
		
		/* S[k] = S[k-1] + "moo..oo" + S[k-1] 임을 생각하고 접근 */
		if(n == SkLength[k-1] + 1)	// 앞부분을 자르고, 첫번째칸은 m
			return 'm';
		if(n <= SkLength[k-1] + k + 3)	// "moo..oo" 부분은 o가 k+2 만큼 생성되기에... m까지 고려해서 총 k+3. // 당연히 첫글자는 앞의 if에서 return 되기에 고려 X
			return 'o';

		
		int reducingN = n - (SkLength[k-1] + (k+3));	// S[k]의 reducingN은 사실상 S[k-1]임...고로, 점점 범위를 좁혀나가서 DP
		return DP(reducingN);
	}
}
