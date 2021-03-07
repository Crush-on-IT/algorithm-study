package BJ_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7569 {
    static int[][] dxdy = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][][] map = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    map[h][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        Queue<int[]> queue= new LinkedList<>();
        int answer= -1;
        boolean done = true;
        int tomato = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    tomato = map[i][j][k];
                    if(tomato == 1)   queue.offer(new int[] {i,j,k});
                    else if(done && tomato == 0)  done = false;
                }
            }
        }
        if(done){
            System.out.println(0);
            return;
        }

        while(!queue.isEmpty()){
            int size = queue.size();

            for (int s = 0; s < size; s++) {

                int[] cur = queue.poll();

                for (int i = 0; i < dxdy.length; i++) {
                    int nh = cur[0] + dxdy[i][0];
                    int nx = cur[1] + dxdy[i][1];
                    int ny = cur[2] + dxdy[i][2];

                    if (nh < 0 || nx < 0 || ny < 0 || nh >= H || nx >= N || ny >= M || map[nh][nx][ny] != 0) continue;

                    map[nh][nx][ny] = 1;
                    queue.offer(new int[]{nh, nx, ny});
                }
            }
            ++answer;
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(map[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
