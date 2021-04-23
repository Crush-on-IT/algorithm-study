import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		long[] lines = new long[K];
		long max = 0;
		for(int i=0 ; i < K ; ++i) {
			lines[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, lines[i]);
		}
		
		long start=1,end = max,mid=0,sum,answer=0;
		
		while(start<=end) {
			//System.out.println(start+" "+end);
			mid = (start+end)/2;
			sum=0;
			for(long line : lines)
				sum+=line/mid;
		
			if(sum>=N) {
				start = mid+1;
				answer = Math.max(answer,mid);
			}
			else	end = mid-1;
		}
		
		System.out.println(answer);
		
	}

}
