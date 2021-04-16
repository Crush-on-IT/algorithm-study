package BFS_DFS;

import java.io.*;
import java.util.*;

public class 백준_2636_치즈 {
    static int[] dx = {-1, 1 ,0, 0};    // 상하좌우 탐색을 위한 배열
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];                // 입력 배열
        boolean[][] visited = new boolean[N][M];    // 방문 체크를 위한 배열
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> land = new ArrayDeque<>();     // 외부 땅
        Queue<int[]> cheese = new ArrayDeque<>();   // 접촉 치즈
        land.add(new int[]{0, 0});
        visited[0][0] = true;

        int cnt = 0; int lastCheese = 0;
        while (!land.isEmpty()) {
            // 외부 땅 찾기
            int[] nowLand = land.poll();
            for (int i = 0; i < 4; i++) {
                int nx = nowLand[0] + dx[i];
                int ny = nowLand[1] + dy[i];

                if (nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny]) continue;
                if (map[nx][ny] == 0){ land.add(new int[]{nx, ny});}
                else{
                    cheese.add(new int[]{nx, ny});  // 외부와 접촉된 치즈 cheese queue에 넣기
                    map[nx][ny] = 0;                // 치즈 녹이기
                }
                visited[nx][ny] = true;             // 방문체크
            }

            // 접촉된 치즈
            if (land.isEmpty()) {
                if(!cheese.isEmpty()) {
                    cnt++;
                    lastCheese = cheese.size();
                }
                while (!cheese.isEmpty()) {         // 치즈였던 자리 외부 땅으로 전환
                    land.add(cheese.poll());
                }
            }
        }

        System.out.printf("%d %n %d", cnt, lastCheese);
    }
}
