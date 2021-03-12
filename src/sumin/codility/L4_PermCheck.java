package codility;

public class L4_PermCheck {
	public static void main(String[] args) {
		int answer = solution(new int[] { 4, 1, 3 });
		System.out.println(answer);
	}

	public static int solution(int[] A) {
		int answer =  1;
		
		boolean[] checked = new boolean[A.length+2];
		
		for(Integer num : A) {
			checked[num] = true;
		}
		
		for (int i = 1; i <= A.length; i++) {
			if(!checked[i]) {
				answer = 0;
				break;
			}
		}
	
		return answer;
	}
	
}
