package codility;

public class L3_FrogJmp {
	public static void main(String[] args) {
		int answer = solution(10,85,30);
		System.out.println(answer);
	}
	
	public static int solution(int X, int Y, int D) {
		int jump = (Y-X)/D;
		
		if((Y-X)%D>0)	++jump;
		
		return jump;
	}
}
