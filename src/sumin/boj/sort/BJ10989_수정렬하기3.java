package sumin.boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ10989_수정렬하기3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Long N = Long.parseLong(br.readLine());
		
		int[] arr = new int[10001];
		
		for (long i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < 10001; i++) {
			while(arr[i]>0) {
				sb.append(i).append("\n");
				--arr[i];
			}
		}
		System.out.println(sb.toString());
	}

}
