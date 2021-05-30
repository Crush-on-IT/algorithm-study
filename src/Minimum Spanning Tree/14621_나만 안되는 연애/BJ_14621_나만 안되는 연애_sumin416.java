import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] parents;

    static class Edge{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB)  return false;
        parents[rootA] = rootB;
        return true;
    }

    private static int find(int a) {
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //parents 배열 초기화
        parents = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        boolean[] sex = new boolean[N+1];
        st = new StringTokenizer(br.readLine()," ");

        for (int i = 1; i <=N; i++) {
            if(st.nextToken().equals("M"))  sex[i] = true;
            else    sex[i] = false;
        }

        ArrayList<Edge> edges = new ArrayList<Edge>();
        int s,e,w;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            if(sex[s] == sex[e])    continue;
            edges.add(new Edge(s,e,w));
        }

//        Collections.sort(edges, (o1, o2) -> o1.weight - o2.weight);
        Collections.sort(edges, Comparator.comparingInt(o -> o.weight));

        Edge edge;
        int result = 0;
        int cnt = 0;
        for (int i = 0; i < edges.size(); i++) {
            edge = edges.get(i);

            if(union(edge.start,edge.end)){
                result  += edge.weight;
                cnt++;

                if(cnt == N-1)  break;
            }
        }

        if(cnt<N-1) result = -1;

        System.out.println(result);
    }
}
