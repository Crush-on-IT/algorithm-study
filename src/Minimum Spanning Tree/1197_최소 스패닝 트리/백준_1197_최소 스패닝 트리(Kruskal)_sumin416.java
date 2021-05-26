import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

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

    private static  boolean union(int[] parent, int a, int b){
        int parentA = findParent(parent,a);
        int parentB = findParent(parent,b);

        if(parentA != parentB) {
            parent[parentA] = parentB;
            return false;
        }

        return true;
    }

    private static int findParent(int[] parent, int a) {

        if(a == parent[a])  return a;
        return parent[a] = findParent(parent, parent[a]);
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

        long result = 0;
        int[] parents = new int[V+1];

        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }

        Node n;

        int cnt = 0;
        for (int i = 0; i < edges.size(); i++) {

            if(cnt==V-1)  break;

            n = edges.get(i);

            if(union(parents, n.start, n.end)) continue;

            result += n.weight;
            ++cnt;
        }


        System.out.println(result);
    }
}
