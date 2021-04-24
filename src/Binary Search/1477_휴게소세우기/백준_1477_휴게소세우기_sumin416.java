import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] stops = new int[N+2];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			stops[i] = Integer.parseInt(st.nextToken());
		}
		stops[N] = 0;
		stops[N+1] = L;
		Arrays.sort(stops);
		
		int start = 1,end = L-1,mid,cnt,newTree;
		
		while(start<=end) {
			mid = (start+end)/2;
			cnt = 0;
			
				
			for (int j = 0; j < stops.length-1; j++) {
				cnt+=(stops[j+1]-stops[j])/mid;
				if((stops[j+1]-stops[j])%mid == 0)	--cnt;
			}
			
			if(cnt<=M) {
				end = mid-1;
			}
			else {
				start = mid+1;
			}
		}
		System.out.println(start);
	}
	
	
	
	
}
