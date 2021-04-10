# [2606] 바이러스 - Java

###  :octocat: 분류

> BFS, DFS

### :octocat: 코드
``` java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<Integer>());
        }
        int a,b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list.get(i));
        }

        dfs(list,new boolean[N+1],new Stack<Integer>(),0,V,N);
        bfs(list,V,N);
    }

    private static void bfs(ArrayList<ArrayList<Integer>> list, int V, int N) {
        boolean[] visited = new boolean[N+1];
        Stack<Integer> stack = new Stack<Integer>();

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(V);
        visited[V] = true;
        stack.push(V);
        int cur = 0;
        while(!queue.isEmpty()){
            cur = queue.poll();

            for (Integer integer : list.get(cur)) {
                if(visited[integer])    continue;
                visited[integer] = true;
                queue.offer(integer);
                stack.push(integer);
            }
        }

        for (Integer integer : stack) {
            System.out.print(integer+" ");
        }
        System.out.println();

    }


    private static Stack<Integer> dfs(ArrayList<ArrayList<Integer>> list, boolean[] visited, Stack<Integer> stack,int cnt, int start, int N) {
        if(cnt == 0){
            visited[start] = true;
            stack.push(start);
        }

        for (Integer end : list.get(start)) {
            if(visited[end])    continue;
            visited[end] = true;
            stack.push(end);
            stack = dfs(list,visited,stack,cnt+1,end,N);
        }

        if(cnt==0){
            for (Integer integer : stack) {
                System.out.print(integer+" ");
            }
            System.out.println();
            return null;
        }
        else    return stack;
    }
}


```

### :octocat: 풀이 방법


### :octocat: 후기


