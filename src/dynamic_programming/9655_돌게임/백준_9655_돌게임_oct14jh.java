import java.util.Scanner;

public class 백준_9655_돌게임_oct14jh {
	private static int N;
	private static boolean WinnerSK;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		if(N % 2 != 0)
			WinnerSK = true;
		
		if(WinnerSK)
			System.out.println("SK");
		else
			System.out.println("CY");
	
	}
}
	

