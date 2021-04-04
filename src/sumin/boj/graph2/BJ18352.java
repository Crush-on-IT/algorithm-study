package BJ_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N  = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        //graph 만들기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }


        //bfs로 가능
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(X);
        visited[X] = true;

        int depth = 0;
        int answer = -1;
        int size = 0;
        loop:
        while(!queue.isEmpty()){
            if(depth == K){ //지금 큐에 들은 얘들은 최단경로 =  depth
                if(queue.size()!=0){
                    answer = 1;
                    List<Integer> list = new ArrayList<>();
                    while (!queue.isEmpty()) list.add(queue.poll());
                    list.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1 - o2;
                        }
                    });
                    for (Integer integer : list) {
                        System.out.println(integer);
                    }
                }
                break loop;
            }
            size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (Integer integer : graph.get(cur)) {
                    if(!visited[integer]){
                        visited[integer] = true;
                        queue.offer(integer);
                    }
                }
            }
            ++depth;
            if(queue.size() == 0)   break;
        }

        if(answer == -1)    System.out.println(answer);

    }
}
