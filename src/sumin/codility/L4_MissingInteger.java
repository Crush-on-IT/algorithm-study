package codility;

public class L4_MissingInteger {
	public static void main(String[] args) {
		int answer = solution(new int[] {1,3,6,4,1,2});
		System.out.println(answer);
	}
	public static int solution(int[] A) {
		int answer = 0;
		
		boolean[] checked = new boolean[1000001];
		
		for(Integer num : A) {
			if(num<=0)	continue;
			checked[num] = true;
		}
		
		for (int i = 1; i < checked.length; i++) {
			if(!checked[i]) {
				answer = i;
				break;
			}
		}
		
		return answer;
    }
}
