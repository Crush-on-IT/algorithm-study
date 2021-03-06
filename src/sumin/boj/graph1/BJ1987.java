package BJ_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1987 {
    static char[][] map;
    static int[][] dxdy  = {{1,0},{0,1},{-1,0},{0,-1}};
    static int N,M,answer=1;
    static boolean visited[][],checked[];
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        checked = new boolean[26];
        visited = new boolean[N][M];
        checked[map[0][0]-'A'] = true;
        visited[0][0] = true;
        dfs(0,0,1);

        System.out.println(answer);
    }

    private static void dfs(int x, int y,int cnt) {

        for (int i = 0; i < dxdy.length; i++) {
            int nx = x+dxdy[i][0];
            int ny = y+dxdy[i][1];

            if(nx<0 || ny<0||nx>=N||ny>=M||visited[nx][ny]) continue;

            if(checked[map[nx][ny]-'A']){
                answer = Math.max(answer,cnt);
                continue;
            }
            if(cnt+1 == N*M)    answer=N*M;
            checked[map[nx][ny]-'A'] = true;
            visited[nx][ny] = true;
            dfs(nx,ny,cnt+1);
            checked[map[nx][ny]-'A'] = false;
            visited[nx][ny] = false;
        }
    }
}
