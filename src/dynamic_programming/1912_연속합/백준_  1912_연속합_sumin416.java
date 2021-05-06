import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader  br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] answer = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N ; i++) {
			arr[i] =  Integer.parseInt(st.nextToken());
		}
		answer[0] = Math.max(0, arr[0]);
		for (int i = 1; i < N; i++) {
			answer[i] = Math.max(answer[i-1]+arr[i], arr[i]);
		}
		int result = 0;
		for (int i = 0; i < answer.length; i++) {
			result  = Math.max(result, answer[i]);
		}
		System.out.println(result);
	}
}
