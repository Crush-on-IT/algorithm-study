
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,answer=0;
    static int[][] map,copy,dxdy={{0,-1},{0,1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copy = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //1. 지도 복사
        //2. 복사한 지도에 벽3개 세우기
        //3. 벽 3개 세운 지도에서 바이러스 뿌리기
        //4. 안전구역 수 세기
        //5. 최대값 갱신
        //6. 벽 3개 세우는 모든 경우 만큼 1~5 반복

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==0){
                    copyMap();
                    copy[i][j] = 1;
                    makeWall(i,j,1);
                }

            }
        }

        System.out.println(answer);

    }

    private static void makeWall(int x, int y, int cnt) {
        if(cnt==3){
            virusSpreed();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if(i<=x && j<=y)    continue;

                if(copy[i][j]==0){
                    copy[i][j] = 1;
                    makeWall(i,j,cnt+1);
                    copy[i][j] = 0;
                }

            }
        }
    }

    private static void virusSpreed() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int totalZero = 0,virusZero = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(copy[i][j]==2)   queue.offer(new int[] {i,j});
                else if(copy[i][j] == 0)    ++totalZero;
            }
        }
        int[] cur;
        int nx,ny;

        while(!queue.isEmpty()){
            cur = queue.poll();

            for (int i = 0; i < dxdy.length; i++) {
                nx = cur[0] + dxdy[i][0];
                ny = cur[1] + dxdy[i][1];

                if(nx<0 || ny<0 || nx>=N || ny>=M || copy[nx][ny]!=0 || visited[nx][ny])   continue;

                visited[nx][ny] = true;
                queue.offer(new int[] {nx,ny});
                ++virusZero;
            }
        }

        answer = Math.max(answer,totalZero-virusZero);
    }

    private static void copyMap(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
            }
        }
    }
}
