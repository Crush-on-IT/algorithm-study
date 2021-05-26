import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//Prim Algorithm
public class Main {

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
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        //make graph
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        int s,e,w;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine()," ");
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e,w));
            graph.get(e).add(new Node(s,w));
        }

        int result = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        boolean[] visited = new boolean[V+1];

        pq.add(new Node(1,0));

        Node n;
        int cnt=0;
        int max = 0;

        while(!pq.isEmpty()){
            n = pq.poll();

            if(visited[n.end])  continue;

            visited[n.end] = true;
            result += n.weight;
            max = Math.max(max,n.weight);

            for (int i = 0; i < graph.get(n.end).size(); i++) {
                if(!visited[graph.get(n.end).get(i).end])
                    pq.add(new Node(graph.get(n.end).get(i).end,graph.get(n.end).get(i).weight));
            }

            if(++cnt == V)  break;
        }

        result -= max;
        System.out.println(result);
    }
}
