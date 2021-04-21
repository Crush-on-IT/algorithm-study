package Binary_search;

import java.util.*;

public class 백준_1789_수들의합_saeumi {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 long S = sc.nextLong();
		 long n =1; 
		 
		 
		 while (true) {
			 if(n*(n-1)/2 > S) break;
			 n++;
		}
		 System.out.println(n-2);
		 
	}

}
