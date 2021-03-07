package BJ_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2583 {
    static int[][] dxdy = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[N][M];
        int lx,ly,rx,ry;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine()," ");
            ly = Integer.parseInt(st.nextToken());
            lx = N-Integer.parseInt(st.nextToken());
            ry = Integer.parseInt(st.nextToken());
            rx = N-Integer.parseInt(st.nextToken());
            //영역칠하기
            for (int j = rx; j < lx; j++) {
                for (int k = ly; k < ry; k++) {
                    map[j][k] = true;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j])   continue;

                Queue<int[]> queue= new LinkedList<>();

                queue.offer(new int[] {i,j});
                map[i][j] = true;
                int count = 1;
                while(!queue.isEmpty()){
                    int[] cur = queue.poll();

                    for (int k = 0; k < dxdy.length; k++) {
                        int nx = cur[0]+dxdy[k][0];
                        int ny = cur[1]+dxdy[k][1];

                        if(nx<0||ny<0||nx>=N || ny>=M||map[nx][ny]) continue;
                        map[nx][ny] = true;
                        ++count;
                        queue.offer(new int[] {nx,ny});
                    }
                }
                list.add(count);
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
    }
}
