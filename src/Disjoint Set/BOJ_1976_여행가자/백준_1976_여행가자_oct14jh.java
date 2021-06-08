import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class 백준_1976_여행가자_oct14jh {
    static int[] parent;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
 
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
 
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int temp = Integer.parseInt(st.nextToken());
 
                if (temp == 1) {
                    union(i, j);
                }
            }
        }
 
        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < M; i++) {
            int now = Integer.parseInt(st.nextToken());
 
 
            if (start != find(now)) {
                bw.write("NO\n");
                bw.flush();
                bw.close();
                br.close();
                return;
            }
        }
 
        bw.write("YES\n");
        bw.flush();
        bw.close();
        br.close();
    }
 
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
 
        return parent[x] = find(parent[x]);
    }
 
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
 
        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }
 
}
