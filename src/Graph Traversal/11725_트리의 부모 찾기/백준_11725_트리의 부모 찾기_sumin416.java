import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int[] parents = new int[N+1];
        boolean[] visited = new boolean[N+1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int n1,n2;

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);

        }


        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        int parent;

        while(!queue.isEmpty()){
            parent = queue.poll();

            for (Integer integer : graph.get(parent)) {
                if(!visited[integer]){
                    visited[integer] = true;
                    queue.offer(integer);
                    parents[integer] = parent;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }


    }


}
