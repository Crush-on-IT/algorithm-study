package sumin.boj.math1_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1934_최소공배수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		
		int A=0,B=0;
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			
			A=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());
			
			int gcd = getGCD(A,B);
			System.out.println(A*B/gcd);
			
		}
	}

	private static int getGCD(int a, int b) {
		int rest = 0;
		
		while(b!=0) {
			rest = a%b;
			a = b;
			b = rest;
		}
		return a;
	}

}
