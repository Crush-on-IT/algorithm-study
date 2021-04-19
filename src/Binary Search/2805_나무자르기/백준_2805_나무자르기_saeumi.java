package Binary_search;
import java.io.*;
import java.util.*;

public class 백준_2805_나무자르기_saeumi {

	static int N; // 나무의 수
	static int M; // 원하는 나무의 길이
	static int[] trees; // 나무들의 높이 정보

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 나무의 수
		M = Integer.parseInt(st.nextToken()); // 원하는 나무의 길이
		trees = new int[N]; // 나무들의 정보

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		} // End of input

		Arrays.sort(trees); // 오름차순으로 정렬 (정렬 필수 !! ) 
		int len = trees.length; // 나무 배열의 길이

		// 이분탐색을 위한 변수
		int maxHeight = trees[len - 1]; // 최대 길이
		int minHeight = 0; // 최소 길이
		int middle = 0; // 중간값

		// 이분탐색
		while (maxHeight >= minHeight) {
			middle = (minHeight + maxHeight) / 2; // 중간값

			int cutTree = 0; // 잘라낸 나무의 길이
			long cutSumTree = 0; // 잘라낸 나무 길이들의 합 - 나무 길이가 int형을 넘어갈 수도 있으니까 !

			// 잘라낸 나무들의 길이 합 구하기
			for (int i = 0; i < len; i++) {
				cutTree = trees[i] - middle; // 중간값으로 나무 자르기

				// 잘린 나무가 없는 경우는 0
				if (cutTree < 0) {
					cutTree = 0;
				}

				// 잘라낸 나무길이의 합
				cutSumTree += cutTree;
			}

			// 잘라낸 나무들의 합이 최소한으로 가져야 하는 나무 길이보다 큰 경우
			if (cutSumTree >= M) {
				minHeight = middle + 1;
			} else if (cutSumTree < M) {
				maxHeight = middle - 1;
			}
		} // end of while

		System.out.println(maxHeight);

	}
}
