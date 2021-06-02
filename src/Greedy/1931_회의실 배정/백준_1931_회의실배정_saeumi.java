package Greedy;
import java.io.*;
import java.util.*;

public class 백준_1931_회의실배정_saeumi {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(br.readLine());
		int time[][] = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
			time[i][1] = Integer.parseInt(st.nextToken()); // 끝나는 시간

		}

		 Arrays.sort(time, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) { // 종료시간이 같으면 
					return o1[0] - o2[0]; //시작시간이 빠른 순으로 정렬
				}
				return o1[1] - o2[1];
			}

		});

		int count = 0;
		int end_time = 0; // 직전 종료시간

		for (int i = 0; i < N; i++) {
			if (end_time <= time[i][0]) { // 만약 직전 종료시간이 다음 회의 시작시간보다 작거나 같다면 갱신
				end_time = time[i][1];
				count++;
			}
		}
		System.out.println(count);
	}

}
