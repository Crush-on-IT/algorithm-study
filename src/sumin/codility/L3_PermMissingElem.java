package codility;

public class L3_PermMissingElem {
	public static void main(String[] args) {
		int answer = solution(new int[] {2,3,1,5});
		System.out.println(answer);
	}
	public static int solution(int[] A) {
		int answer = 0;
		
		boolean[] checked = new boolean[A.length+2];
		
		for(Integer num : A) {
			checked[num] = true;
		}
		
		for (int i = 1; i < checked.length+2; i++) {
			if(!checked[i]) {
				answer = i;
				break;
			}
			
		}
		
		return answer;
	}
}
