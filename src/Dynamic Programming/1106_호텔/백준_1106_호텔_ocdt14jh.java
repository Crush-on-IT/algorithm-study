import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1106_호텔_oct14jh {
	private static class Ads {
		int fee;
		int person;
		public Ads(int fee, int person) {
			super();
			this.fee = fee;
			this.person = person;
		}
		public Ads() {
			super();
			// TODO Auto-generated constructor stub
		}
	}
	
	private static int C, N;
	private static Ads[] cities;
	private static int[] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		memo = new int[C + 1];
		cities = new Ads[N];
		for(int city = 0; city < N; city++) {
			st = new StringTokenizer(br.readLine(), " ");
			cities[city] = new Ads(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		if(C==0)
			System.out.println(0);
		else
			System.out.println(dp(C));
		
		br.close();
	}
	
	private static int dp(int clientCnt) {
		if(clientCnt <= 0)
			return 0;
		
		if(memo[clientCnt] != 0)
			return memo[clientCnt];
		
		int feeMin = Integer.MAX_VALUE;
		for(int city = 0; city < N; city++) {
			Ads temp = cities[city];
			feeMin = Math.min(feeMin, temp.fee + dp(clientCnt - temp.person));
		}
		
		return memo[clientCnt] = feeMin;
	}
}
