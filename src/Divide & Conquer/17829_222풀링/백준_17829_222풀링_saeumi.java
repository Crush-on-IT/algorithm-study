package Divide_Conquer;

import java.io.*;
import java.util.*;

public class 백준_17829_222풀링_saeumi {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int t = N;
		for (int k = 1; k <= t; k *= 2) {
			for (int i = 0; i < N; i += 2) {
				for (int j = 0; j < N; j += 2) {
					int[] num = new int[4];
					num[0] = map[i][j];
					num[1] = map[i][j + 1];
					num[2] = map[i + 1][j];
					num[3] = map[i + 1][j + 1];

					Arrays.sort(num);
					map[i / 2][j / 2] = num[2];
				}
			}
			N = N / 2;
		}
		System.out.println(map[0][0]);
	}

}
