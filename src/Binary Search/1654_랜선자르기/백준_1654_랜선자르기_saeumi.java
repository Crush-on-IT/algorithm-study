package Binary_search;

import java.io.*;
import java.util.*;

public class 백준_1654_랜선자르기_saeumi {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선의 개수
		int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
		int arr[] = new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine()); // 값 받아오기
		} // end of input

		Arrays.sort(arr);
		int len = arr.length;

		// 이분 탐색을 위한 변수
		int max = arr[len - 1]; // 1~802(배열 안 최대값까지)
		int min = 1; // // 문제에서 랜선 길이는 자연수라 0으로 초기값으로 정하면 에러가 발생한다
		int middle = 0; // 증간값

		// 이분탐색
		while (max >= min) {
			middle = (max + min) / 2;
			long allCount = 0;

			for (int j = 0; j < arr.length; j++) {
				allCount += arr[j] / middle;
			}
			
			if (allCount >= N) { // 처음에는 ==이 되면 break를 걸어서 시간을 단축해보려고 했는데, 그건 구체적인 수를 찾을 때는 가능하지만,
									// 문제처럼 가능한 경우의 수 중에서 최대값을 구할 경우에는 다음과 같은 부등호 처리를 해야한다.
									// == 이 아니라도 문제에 답이 되는 경우가 존재하기 때문이다.
				min = middle + 1;
			} else if (allCount < N) {
				max = middle - 1;
			}
		}
		System.out.println(max);
	}
}
