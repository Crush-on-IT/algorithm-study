import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long answer=0,n,sqrtN;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Long.parseLong(br.readLine());
		sqrtN = (long) Math.sqrt(n);
		
		new Main().binarySearch(0,sqrtN);
		
		System.out.println(answer);
	}

	private void binarySearch(long start, long end) {
		long mid=0;
		
		while(start<=end) {
			mid = (start+end)/2;
			
			if(mid<sqrtN)	start = mid+1;
			else	end = mid-1;
			
		}
		
		
		answer = mid;
		
		if(mid*mid != n)	++answer;
		
		
	}
	
	
	
}
