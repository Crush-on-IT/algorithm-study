import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		
		long start = 0, end = n, mid,result;
		
		while(start<=end){
			mid =  (start+end)/2;
			result = (1+mid)*(1+n-mid);
			if(result == k) {
				System.out.println("YES");
				return;
			}
			else if(result<k){
				start = mid+1;
			}
			else	end = mid-1;
		}
		
		System.out.println("NO");
	}

}
