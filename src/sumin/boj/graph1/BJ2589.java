package BJ_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2589 {
    static int[][] dxdy  = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        boolean[][] visited= null;

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        //모든 부분에 대해 bfs
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 'W' )   continue;
                visited= new boolean[N][M];
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[] {i,j});
                visited[i][j] = true;
                int distance = -1;
                while(!queue.isEmpty()){
                    int size = queue.size();

                    distance++;
                    for (int s = 0; s < size; s++) {
                        int[] cur = queue.poll();
                        for (int k = 0; k < dxdy.length; k++) {
                            int nx = cur[0]+dxdy[k][0];
                            int ny = cur[1]+dxdy[k][1];

                            if(nx<0 || ny<0 || nx>=N ||ny>=M || map[nx][ny] == 'W' || visited[nx][ny]) continue;
                            visited[nx][ny] = true;
                            queue.offer(new int[] {nx,ny});
                        }
                    }
                }
                answer = Math.max(answer,distance);
            }
        }
        System.out.println(answer);
    }
}
