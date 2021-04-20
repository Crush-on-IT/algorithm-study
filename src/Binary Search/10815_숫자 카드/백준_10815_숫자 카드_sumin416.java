import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		
		int[] cards = new int[N];
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken()); 
		}
		Arrays.sort(cards);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		int input = 0,answer = 0;
		
		for (int i = 0; i < M; i++) {
			answer = 0;
			input = Integer.parseInt(st.nextToken());
			
			int start=0,end = N-1,mid;
		
			while(start<=end) {
				mid = (start+end)/2;
				//System.out.println(mid);
				if(cards[mid] == input) {
					answer = 1;
					break;
				}
				if(cards[mid]<input)	start = mid+1;
				else	end = mid-1;
			}
			//System.out.println(answer);
			//System.out.println("----------------");
			sb.append(answer).append(" ");
			
		}
		
		System.out.println(sb.toString());
		
	}

}
