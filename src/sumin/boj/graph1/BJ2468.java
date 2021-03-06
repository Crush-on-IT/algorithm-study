import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int[][] dxdy = {{1,0},{-1,0},{0,1},{0,-1}},map;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int input = 0;
        Map<Integer,Boolean> numbers = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");

            for (int j = 0; j < N; j++) {
                input = Integer.parseInt(st.nextToken());
                map[i][j] = input;
                numbers.put(input,false);
            }
        }
        int answer = 1;
        int count;
        for (Integer key : numbers.keySet()) {
            visited = new boolean[N][N];
            count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(visited[i][j] || map[i][j]<=key)   continue;
                    dfs(key,i,j);
                    ++count;
                }
            }
            answer = Math.max(answer,count);
        }


        System.out.println(answer);
    }

    private static void dfs(int key,int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < dxdy.length; i++) {
            int nx = x+dxdy[i][0];
            int ny = y+dxdy[i][1];

            if(nx<0 || ny<0 || nx>=N || ny>=N ||visited[nx][ny]||map[nx][ny]<=key)   continue;
            visited[nx][ny] = true;
            dfs(key,nx,ny);
        }


    }
}

