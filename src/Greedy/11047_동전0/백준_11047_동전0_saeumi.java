package Greedy;
import java.io.*;
import java.util.*;

public class 백준_11047_동전0_saeumi {

	static Integer[] arr;
	static int temp;
	
	public static void main(String[] args) throws IOException {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			 arr= new Integer[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			Arrays.sort(arr, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			});
			
			int sum =0;
			for(int i =0; i<N; i++) {
				if(K/arr[i] > 0 ) {
					temp = K /arr[i];
					sum += temp;
					K = K % arr[i];
					
				}  
			}
			System.out.println(sum);
	} //end of main

} //end of class
