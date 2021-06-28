import java.util.Scanner;

public class 백준_1987_알파벳_oct14jh {
    static int R, C, answer;
    static boolean[][] visit;
    static boolean[] alpha;
    static char[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        answer = 0;
        alpha = new boolean[26];
        map = new char[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = sc.next().toCharArray();
        }
        visit[0][0] = true;
        alpha[map[0][0] - 'A'] = true;
        solve(0, 0, 1);
        System.out.println(answer);
    }

    public static void solve(int x, int y, int cnt) {
        answer = Math.max(answer, cnt);
        for (int i = 0; i < 4; i++) {
        	int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if (!visit[nx][ny] && !alpha[map[nx][ny] - 'A']) {
                    visit[nx][ny] = true;
                    alpha[map[nx][ny] - 'A'] = true;
                    solve(nx, ny, cnt + 1);
                    visit[nx][ny] = false;
                    alpha[map[nx][ny] - 'A'] = false;
                }
            }
        }
    }
}