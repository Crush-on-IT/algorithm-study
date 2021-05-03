import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		int N = new Scanner(System.in).nextInt();
		
		int answer = -1;
		
		for (int i = 0; i <= N/3; i++) {
			int weight = N-3*i;
			if(weight % 5 == 0) {
				System.out.println(i+weight/5);
				return;
			}
		}
		
		System.out.println(answer);
	}

}
