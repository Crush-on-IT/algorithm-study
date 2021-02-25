package sumin.boj.math1_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2609_최대공약수와최소공배수 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		//A > B로 만들기
		if(A<B) {
			int temp = A;
			A = B;
			B = temp;
		}
		
		int gcd = getGCD(A,B);
		int lcm = A*B/gcd;
		
		System.out.println(gcd);
		System.out.println(lcm);
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
