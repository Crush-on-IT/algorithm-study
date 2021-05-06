package Dynamic_programming;

import java.io.*;
import java.util.*;

public class 백준_12865_평범한배낭2_saeumi {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 준서가 버틸수 있는 무게
		int arr[][] = new int[N + 1][K + 1];
		int W[] = new int[N + 1];
		int V[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken()); // 각 물건의 무게
			V[i] = Integer.parseInt(st.nextToken()); // 해당 물건의 가치
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {

				if (W[i] > j) {
					arr[i][j] = arr[i - 1][j];
				} else {
					arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - W[i]] + V[i]);
				}
			}
		}
		System.out.println(arr[N][K]);
	}
}
