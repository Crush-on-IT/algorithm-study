import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PrimitiveIterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static class Node{
        int end;
        int weight;

        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        //graph 만들기
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i <=N; i++) {
            graph.add(new ArrayList<Node>());
        }

        //이차원 배열 형태의 input을 graph로 만들기
        int input = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 1; j <= N; j++) {
                input = Integer.parseInt(st.nextToken());
                if(i == j|| input == 0)  continue;

                graph.get(i).add(new Node(j,input));
                graph.get(j).add(new Node(i,input));

            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->(o1.weight-o2.weight));
        pq.add(new Node(1,0));

        int cnt = 0;
        long result = 0;
        boolean[] visited = new boolean[N+1];

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.end])    continue;

            visited[cur.end] = true;
            result += cur.weight;

            for (Node node : graph.get(cur.end)) {
                if(!visited[node.end]){
                    pq.add(node);
                }
            }

            if(++cnt == N){
                break;
            }
        }

        System.out.println(result);
    }
}
