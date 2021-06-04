package Greedy;
import java.io.*;
import java.util.*;

public class 백준_13305_주유소 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		// valueOf 객체 리턴, parseInt 기본 자료형 리턴

		// 숫자 길이 상 long 사용
		long[] distances = new long[n - 1];
		long[] fuels = new long[n];

		// 거리 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n - 1; i++) {
			int distance = Integer.valueOf(st.nextToken());
			distances[i] = distance; // 거리의 값들을 배열에 넣기 
		}

		// 주유소 입력 받기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int fuel = Integer.valueOf(st.nextToken());
			fuels[i] = fuel;
		}

		long price = distances[0] * fuels[0]; // 초기 연료비 --> 무조건 있어야하는 것
		int nowCity = 0;
		int nextCity = nowCity + 1;

		// 마지막 도시 전까지 진행
		while (nextCity < n - 1) {
			if (fuels[nowCity] < fuels[nextCity]) { // 다음 도시의 연료가 더 비싸면, 지금 주유소에서 다다음 도시까지 미리 넣고 출발
				price += fuels[nowCity] * distances[nextCity];
			} else { // 아니라면 다음주유소에서 다음 도시 거리만큼 넣는다
				price += fuels[nextCity] * distances[nextCity];
				nowCity = nextCity; // 조심  
			}

			nextCity++;
		}

		System.out.print(price);
	}
}