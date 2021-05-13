package Divide_Conquer;

import java.io.*;
import java.util.*;

public class 백준_1074_Z_saeumi {

	private static int r, c, N, count;
	private static int size;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		size = (int) Math.pow(2, N);

		dfs(0, 0, size);
	} // end of main

	private static void dfs(int y, int x, int N) {

		if (y == r && x == c) {
			System.out.println(count);
			System.exit(0);
		} else {
			if (r >= y && r < y + N / 2 && c >= x && c < x + N / 2) {
				dfs(y, x, N / 2);
			} else if (r >= y && r < y + N / 2 && c >= x + N / 2 && c < x + N) {
				count  += (int) Math.pow(N/2, 2);
				dfs(y, x + N / 2, N / 2);
			} else if (r >= y + 2 / N && r < y + N && c >= x && c < x + N / 2) {
				count  += (int) Math.pow(N/2, 2) *2;
				dfs(y + N / 2, x, N / 2);
			} else if (r >= y + 2 / N && r < y + N && c >= x + N / 2 && c < x + N) {
				count  += (int) Math.pow(N/2, 2) *3;
				dfs(y + N / 2, x + N / 2, N / 2);
			}
		}
	}
} // end of class
