package codility;

import java.util.HashMap;
import java.util.Map;

public class L2_OddOccurrencesInArray {

	public static void main(String[] args) {
		int answer = solution(new int[] {9,3,9,3,9,7,9});
		System.out.println(answer);
	}

	public static int solution(int[] A) {
		int answer = 0;
		
		Map<Integer,Boolean> map = new HashMap<>();
		int prevSize = 0;
		
		for(Integer num : A) {
			map.put(num, false);
			if(prevSize == map.size()) {
				map.remove(num);
				--prevSize;
			}
			else	++prevSize;
		}
		
		for(Integer num : map.keySet()) {
			answer = num;
			break;
		}
		
		return answer;
    }
}
