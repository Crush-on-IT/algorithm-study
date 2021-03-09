package BJ_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2665 {
    //아직 안간곳 0, 방문한곳 1, 방문 불가 -1
    static int[][][] visited;
    static char[][] map;
    static int[][] dxdy ={{1,0},{-1,0},{0,1},{0,-1}};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new int[2*N][N][N];


        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        bfs(0,0,0);

        int answer = 0;

        //print(visited);

        for (int i = 0; i < 2*N; i++) {
            if(visited[i][N-1][N-1] == 1){
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    private static void print(int[][][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                for (int k = 0; k < visited[0][0].length; k++) {
                    System.out.print(visited[i][j][k]+" ");
                }
                System.out.println();
            }
            System.out.println();

        }
    }

    private static void bfs(int height, int x, int y) {

        Queue<int[]> queue= new LinkedList<>();

        queue.offer(new int[] {x,y});
        int nx=0,ny=0;
        while(!queue.isEmpty()){

            int[] cur = queue.poll();

            for (int i = 0; i < dxdy.length; i++) {
                nx = cur[0]+dxdy[i][0];
                ny = cur[1]+dxdy[i][1];

                if(nx<0 || ny<0 || nx>=N ||ny>=N || visited[height][nx][ny] != 0)   continue;

                //흰방이면
                if(map[nx][ny] == '1'){
                    visited[height][nx][ny] = 1;
                    queue.offer(new int[] {nx,ny});
                }

                //검은방이면
                else{
                    visited[height][nx][ny] = -1;
                    if(height!=2*N-1){
                        visited[height+1][nx][ny] = 1;

                        bfs(height+1,nx,ny);
                    }
                }
            }

        }

    }
}
