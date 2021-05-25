import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    static class Node{
        int start;
        int end;
        long weight;


        public Node(int start, int end, long weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        //make edges
        ArrayList<Node> edges = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine()," ");

            Node node = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Long.parseLong(st.nextToken()));
            edges.add(node);
        }

        Collections.sort(edges, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return (int)(o1.weight-o2.weight);
            }
        });

        boolean[] visited=  new boolean[V+1];
        visited[edges.get(0).start] = true;

        long result = 0;

        Node tmp;
        int start, end, cnt;
        for (int i = 0; i <edges.size(); i++) {
            cnt = 0;

            tmp = edges.get(i);
            start = tmp.start;
            end = tmp.end;

            if(visited[start] && visited[end]){
                continue;
            }

            visited[start] = true;
            visited[end] = true;
            result += tmp.weight;

            for (int j = 1; j <= V; j++) {
                if(visited[j])  ++cnt;
            }

            if(cnt == V)    break;

        }

        System.out.println(result);
    }
}
