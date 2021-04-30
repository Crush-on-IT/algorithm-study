import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static boolean[] visitedX,visitedY;
	static int N,answer;
	
	public static void main(String[] args) throws IOException {
		answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		visitedX = new boolean[N];
		visitedY = new boolean[N];
		
		int[] queens = new int[N];
		
		play(queens,0);
		
		System.out.println(answer);
	}
	
	private static void play(int[] queens, int cur) {
		if(cur == N) {
			++answer;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!isAvail(queens, cur, i))	continue;
			
			queens[cur] = i;
			play(queens,cur+1);
		}
	}

	private static boolean isAvail(int[] queens, int cur, int i) {
		int nx,ny;
		
		
		for (int j = 0; j < cur; j++) {
			if(Math.abs(cur-j) == Math.abs(i-queens[j]) || queens[j] == i)	return false;
		}
		
		return true;
	}
	
	
	
	
}
