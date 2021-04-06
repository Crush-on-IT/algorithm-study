import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());  // K번째 사람을 제거

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int cnt = 1;
        int cur = 0;

        while(!queue.isEmpty()){
            cur = queue.poll();

            if(cnt==K){
                answer.add(cur);
                cnt = 1;
            }
            else{
                queue.offer(cur);
                ++cnt;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < N-1; i++) {
            sb.append(answer.get(i)).append(", ");
        }
        sb.append(answer.get(N-1)).append(">");

        System.out.println(sb.toString());
    }

}
