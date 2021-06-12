import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static int[] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];

        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        int a,b,c;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == 0) {
                union(b, c);
            } else {
                check(b, c);
            }


        }
    }

    private static void check(int b, int c) {
        if(find(b) == find(c)) System.out.println("YES");
        else System.out.println("NO");
    }

    private static int find(int a){
        if(a == parents[a]) return a;
        return parents[a]=find(parents[a]);
    }

    private static void union(int b, int c) {
        int rootB = find(b);
        int rootC = find(c);

        if(rootB != rootC){
            parents[rootB] = rootC;
        }
    }
}
