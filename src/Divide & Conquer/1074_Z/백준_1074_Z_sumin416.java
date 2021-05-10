
import java.util.Scanner;

public class Main {
	private static int cnt=0;
	private static int N,r,c;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		visitZ(N,0,0);
		System.out.println(cnt);
	}
	
	private static void visitZ(int N,int x, int y) {
		if(N==1) {
			for(int i = x ; i <= x+1 ; ++i) {
				for(int j = y ; j <= y+1 ; ++j) {
					if(i==r&&j==c) {
						
						return;
					}
					++cnt;
				}
			}
			return;
		}
//		System.out.println("N="+N+", x="+x+", y="+y);
		//왼
		if(r<(x+(1<<(N-1)))) {
//			System.out.println("x좌표:"+(x+(1<<(N-1)))+" 보다 작아서 1,2분면에 들어옴");
			if(c<(y+(1<<(N-1)))) {
//				System.out.println("y좌표:"+(y+(1<<(N-1)))+" 보다 작아서 1분면에 들어옴");
				visitZ(N-1,x,y);
			}
			else {	
				cnt+=(Math.pow(4, N-1));
				
				//오
//				System.out.println("y좌표:"+(y+(1<<(N-1)))+" 보다 커서 2분면에 들어옴 + "+cnt+"=cnt");
				visitZ(N-1,x,y+(1<<(N-1)));
			}
		}
		else {
			cnt+=(Math.pow(4, N-1))*2;
//			System.out.println("x좌표:"+(x+(1<<(N-1)))+" 보다 커서 3,4분면에 들어옴 + "+cnt+"=cnt");
			if(c<(y+(1<<(N-1)))) {
				//하왼
//				System.out.println("y좌표:"+(y+(1<<(N-1)))+" 보다 작아서 3분면에 들어옴");
				visitZ(N-1,x+(1<<(N-1)),y);
			}
			else {	
				cnt+=(Math.pow(4, N-1));
				//하오
//				System.out.println("y좌표:"+(y+(1<<(N-1)))+" 보다 커서 4분면에 들어옴 + "+cnt+"=cnt");
				visitZ(N-1,x+(1<<(N-1)),y+(1<<(N-1)));
			}
		}
	}
	
	
}
