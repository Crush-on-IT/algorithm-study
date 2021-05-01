import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[M]; 
		make(arr,1,0);
		
	}
	private static void make(int[] arr, int cur, int cnt) {
		if(cnt==M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = cur; i <= N; i++) {
			arr[cnt] = i;
			make(arr,i,cnt+1);
		}
	}
	
}
