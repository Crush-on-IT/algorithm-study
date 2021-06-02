package Greedy;
import java.io.*;
import java.util.*;

public class 백준_11399_ATM_saeumi {

	public static void main(String[] args) throws Exception, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		// System.out.println(Arrays.toString(arr));
		int temp = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			temp += arr[i];
			sum += temp;
		}
		System.out.print(sum);
	}
}
