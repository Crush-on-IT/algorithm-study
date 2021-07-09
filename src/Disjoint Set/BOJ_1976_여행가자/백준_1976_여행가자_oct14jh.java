package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자_G4 {
	private static int N, M;
	private static int[] parents;
	private static String answer = "";
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parents = new int[N];
		for(int i = 0; i < N; i++) {
			parents[i] = i;
		}
		
		StringTokenizer st = null;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				int status = Integer.parseInt(st.nextToken());
				if(status == 1) {
					unionSet(i, j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] course = new int[st.countTokens()];
		for(int i = 0; i < course.length; i++) {
			course[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		for(int check = 0; check < course.length - 1; check++) {
			int placeA = course[check];
			int placeB = course[check + 1];
			
			if(findSet(placeA) != findSet(placeB)) {
				answer = "NO";
				break;
			} else {
				answer = "YES";
			}
		}
		
		System.out.println(answer);
		
		br.close();
	}

	private static int findSet(int placeA) {
		if(parents[placeA] == placeA)
			return placeA;
		return parents[placeA] = findSet(parents[placeA]);
	}

	private static void unionSet(int i, int j) {
		int iRoot = findSet(i);
		int jRoot = findSet(j);
		if(iRoot != jRoot)
			parents[jRoot] = iRoot;
	}
}
