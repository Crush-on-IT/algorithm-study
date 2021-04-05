package BJ_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1753 {
    final static int INF = Integer.MAX_VALUE;
    static class Node{
        int e;
        int weight;

        public Node(int e, int weight){
            this.e = e;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        //dijkstra
        int[] distance = new int[V+1];
        boolean[] visited = new boolean[V+1];

        for (int i = 1; i <= V; i++) {
            distance[i] = INF;
        }

        distance[K] = 0;
        visited[K] = true;

        for (Node node : graph.get(K)) {
            distance[node.e] = Math.min(node.weight,distance[node.e]);
        }

        int min = INF;
        int minIdx = -1;

        for (int i = 0; i < V-1; i++) {
            min = INF;
            minIdx = -1;
            //방문 안 한 노드 중 가장 경로 짧은 노드 찾기
            for (int j = 1; j <= V; j++) {
                if(visited[j])  continue;

                if(distance[j]<min){
                    min = distance[j];
                    minIdx = j;
                }
            }

            if(minIdx==-1)  break;

            visited[minIdx] = true;

            for (Node node : graph.get(minIdx)) {
                if(visited[node.e]) continue;
                if(distance[node.e] > distance[minIdx]+node.weight) distance[node.e] = distance[minIdx]+node.weight;
            }
        }

        for (int i = 1; i <= V; i++) {
            if(distance[i] == INF)  System.out.println("INF");
            else    System.out.println(distance[i]);
        }
    }
}
