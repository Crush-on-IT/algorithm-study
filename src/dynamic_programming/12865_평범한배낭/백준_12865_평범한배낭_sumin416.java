import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader  br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int W,V;
		int[] weights = new int[N];
		int[] values = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			
			values[i] = V;
			weights[i] = W;
			
			for (int j = 0; j < i; j++) {
				if(weights[j]+W<=K ) {
					if(values[i] < V+values[j]) {
						values[i] = V+values[j];
						weights[i] = W + weights[j];
					}
				}
			}
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer  = Math.max(answer, values[i]);
		}
		System.out.println(answer);
	}
}
