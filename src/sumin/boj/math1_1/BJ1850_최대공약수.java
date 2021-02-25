package sumin.boj.math1_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1850_최대공약수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st  = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		long cnt = getGCD(A,B);
		
		StringBuffer sb = new StringBuffer();
		for (long i = 0; i < cnt; i++) {
			sb.append("1");
		}
		
		System.out.println(sb.toString());
	}

	private static long getGCD(long a, long b) {

		long rest = 0;
		
		while(b!=0) {
			rest = a%b;
			
			a = b;
			b = rest;
		}
		return a;
	}

}
