import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static class Node{
        int end;
        double weight;

        public Node(int end, double weight){
            this.end = end;
            this.weight = weight;
        }
    }

    static  int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine()," ");

            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        double calResult = 0.0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {

                calResult = cal(i,j);

                graph.get(i).add(new Node(j,calResult));
                graph.get(j).add(new Node(i,calResult));

            }
        }

        boolean[] visited = new boolean[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (int)(o1.weight - o2.weight));

        int tmp = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");

            for (int t = 0; t < 2; t++) {
                tmp = Integer.parseInt(st.nextToken());
                if(!visited[tmp]){
                    visited[tmp] = true;

                    for (int j = 0; j < graph.get(tmp).size(); j++) {
                        if(!visited[graph.get(tmp).get(j).end])
                            pq.add(graph.get(tmp).get(j));
                    }
                }
            }
        }

        Node node = null;
        double result = 0;
        int cnt  = 0;

        for (int i = 1; i < visited.length; i++) {
            if(visited[i])  ++cnt;
        }

        while(!pq.isEmpty()){
            node = pq.poll();

            if(visited[node.end])   continue;

            visited[node.end] = true;

            result += node.weight;

            if(++cnt == N)  break;

            for (int j = 0; j < graph.get(node.end).size(); j++) {
                if(!visited[graph.get(node.end).get(j).end])
                    pq.add(graph.get(node.end).get(j));
            }
        }

        System.out.println(String.format("%.2f",Math.round(result*100)/100.0));

    }

    private static double cal(int N1, int N2){
        double dis = 0;
        dis = Math.sqrt(Math.pow(map[N1][0] - map[N2][0],2) + Math.pow(map[N1][1] - map[N2][1],2));
        return dis;
    }
}
