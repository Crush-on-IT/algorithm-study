
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static int[][] dxdy = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1},{0,0}};
    static int N=8,answer= 0 ;
    static boolean[][] map = new boolean[N][N];
    static boolean[][] visited = new boolean[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input;

        for (int i = 0,j=0; i < N; i++) {
            input = br.readLine().toCharArray();

            for (int k = 0; k < N; k++) {
                if(input[k]=='#')  map[i][k] = true;   //true면 벽이 있다.
            }
        }

        new Main().BFS();
        System.out.println(answer);
    }

    void BFS(){

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {N-1,0});
        visited[N-1][0] = true;

        int[] cur;
        int nx,ny,size;

        while(!queue.isEmpty()){

            size = queue.size();
            visited = new boolean[N][N];

            for (int s = 0; s < size; s++) {

                cur = queue.poll();

                //queue에 넣고 난 뒤 map 변경되고서 그 위치가 벽이면
                if(map[cur[0]][cur[1]])  continue;

                for (int i = 0; i < dxdy.length; i++) {
                    nx = cur[0] + dxdy[i][0];
                    ny = cur[1] + dxdy[i][1];

                    //map 범위 넘어가거나, 이미 방문했거나, 벽이면 못감
                    if(nx<0 || ny<0 || nx>= N || ny>=N || visited[nx][ny] || map[nx][ny])  continue;

                    if(nx==0 && ny==N-1){
                        answer = 1;
                        return;
                    }
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx,ny});

                }
            }

            if(queue.size()==0) return;

            //map 내리기
            for (int i = N-2; i >=0; i--) {
                for (int j = 0; j < N; j++) {
                    map[i+1][j] = map[i][j];
                }
            }
            for (int i = 0; i < N; i++) {
                if(map[0][i])   map[0][i] = false;
            }
        }

    }

}
