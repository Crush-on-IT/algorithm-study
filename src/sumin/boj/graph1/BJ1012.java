import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dxdy = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] map;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        int answer;

        for (int t = 1; t <= T; t++) {

            answer = 0;

            st = new StringTokenizer(br.readLine()," ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new boolean[N][M];
            int a,b;
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine()," ");
                b = Integer.parseInt(st.nextToken());
                a = Integer.parseInt(st.nextToken());

                map[a][b] = true;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(!map[i][j])  continue;

                    map[i][j]= false;
                    dfs(i,j);
                    ++answer;
                }
            }
            System.out.println(answer);
        }
    }

    private static void dfs(int i, int j) {
        for (int k = 0; k < dxdy.length; k++) {
            int nx = i+dxdy[k][0];
            int ny = j+dxdy[k][1];
            if(nx<0 || ny<0 || nx>=N ||ny>=M || !map[nx][ny])    continue;

            map[nx][ny] = false;
            dfs(nx,ny);
        }
    }
}

