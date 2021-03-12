package sumin.programmers.highscoreKIT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 스택큐_기능개발 {
	public static void main(String[] args) {
		int[] answer = solution(new int[] {95, 90, 99, 99, 80, 99},new int[] {1, 1, 1, 1, 1, 1});
		System.out.println(Arrays.toString(answer));
	}
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<Integer> queue= new LinkedList<>();
        
        int times;
        
        for (int i = 0; i < progresses.length; i++) {
			times = (100-progresses[i])/speeds[i];
			if((100-progresses[i])%speeds[i]!=0)	++times;
			queue.offer(times);
		}
        List<Integer> ans = new ArrayList<>();
        
        int cnt = 1,standard = queue.poll();
        while(!queue.isEmpty()) {
        	int cur = queue.poll();
        	if(cur<=standard)	++cnt;
        	else {
        		ans.add(cnt);
        		cnt=1;
        		standard = cur;
        	}
        }
        ans.add(cnt);
        
        answer = new int[ans.size()];
        
        for (int i = 0; i < answer.length; i++) {
			answer[i] = ans.get(i);
		}
        
        return answer;
    }
}
