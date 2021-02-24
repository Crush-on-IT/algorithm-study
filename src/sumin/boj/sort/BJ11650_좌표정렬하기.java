package sumin.boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BJ11650_좌표정렬하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		//리스트보다 2차원 배열이 더 효율적!
		List<int[]> list = new ArrayList<>();
		String[] input = new String[2];
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			list.add(new int[] {Integer.parseInt(input[0]),Integer.parseInt(input[1])});
		}
		
		Collections.sort(list,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]!=o2[0])
					return o1[0]-o2[0];
				return o1[1]-o2[1];
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int[] cur = list.get(i);
			sb.append(cur[0]).append(" ").append(cur[1]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
