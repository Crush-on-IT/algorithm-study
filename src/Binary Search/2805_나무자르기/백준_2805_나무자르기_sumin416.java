import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		long answer = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		
		long[] trees = new long[N];
		long max = 0;
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			trees[i] = Long.parseLong(st.nextToken());
			max = Math.max(max, trees[i]);
		}
		
		
		long start = 0,end = max-1,mid=0,cnt=0;
		
		while(start<=end) {
			mid = (start+end)/2;
			cnt=0;
			
			for (int i = 0; i < trees.length; i++) {
				cnt += (trees[i]-mid>0)?trees[i]-mid:0;
			}
			
			if(cnt == M)	break;
			
			if(cnt < M)	end=mid-1;
			else	start = mid+1;
		}
		
		if(cnt<M)	answer = mid>0?mid-1:0;
		else answer = mid;
		
		System.out.println(answer);
		
	}

}
