package sumin.boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ10825_국영수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[][] arr = new String[N][4];
		
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().split(" ");
		}
		
		Arrays.sort(arr,new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				int k1 = Integer.parseInt(o1[1]);
				int k2 = Integer.parseInt(o2[1]);
				int e1 = Integer.parseInt(o1[2]);
				int e2 = Integer.parseInt(o2[2]);
				int m1 = Integer.parseInt(o1[3]);
				int m2 = Integer.parseInt(o2[3]);
				
				if(k1!=k2)	return k2-k1;
				if(e1!=e2)	return e1-e2;
				if(m1!=m2)	return m2-m1;
				return o1[0].compareTo(o2[0]);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i][0]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
