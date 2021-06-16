import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int[] parents;

    static int find(int a){
        if(a == parents[a]) return a;

        return parents[a] = find(parents[a]);
    }

    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB)  return;

        if(rootA<= rootB)   parents[rootB] = rootA;
        else    parents[rootA] = rootB;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());


        parents = new int[N+1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine()," ");

            for (int j = 1; j <= N ; j++) {

                if(Integer.parseInt(st.nextToken()) == 0)  continue;

                union(i,j);
            }
        }

//        for (int i = 0; i <= N; i++) {
//            System.out.print(parents[i]+" ");
//        }
//        System.out.println();

        st = new StringTokenizer(br.readLine()," ");
        int input, root = find(Integer.parseInt(st.nextToken()));
        boolean answer = true;
        for (int i = 1; i < M; i++) {
            input = Integer.parseInt(st.nextToken());

            if(find(input) != root){
                answer = false;
                break;
            }

        }

        if(answer) System.out.println("YES");
        else System.out.println("NO");

    }
}