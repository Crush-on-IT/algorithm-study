import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,D,answer = 0;
	static int[][] map,copy,dxdy = {{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		copy = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		new Main().makeShooter();
		System.out.println(answer);
	}

	private void makeShooter() {
		boolean[] shooter = new boolean[M];
		for (int i = 0; i < M; i++) {
			shooter[i] = true;
			for (int j = i+1; j < M; j++) {
				shooter[j] = true;
				for (int j2 = j+1; j2 < M; j2++) {
					shooter[j2] = true;
					copyMap();
					play(shooter);
					shooter[j2] = false;
				}
				shooter[j] = false;
			}
			shooter[i] = false;
		}
	}
	
	private void copyMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	
	private void play(boolean[] shooter) {
		int count=0;
		//System.out.println(Arrays.toString(shooter));
		
		
		while(ExistEnemy()) {
			//System.out.println("아직 적이 남아있다.!");
			count+=shoot(shooter);
			downEnemy();
		}
		
		answer = Math.max(answer, count);
		
	}
	
	private int shoot(boolean[] shooter) {
		
		int count = 0;
		int size,d,nx,ny;
		List<int[]> shootedEnemy = new ArrayList<>();
		int[] cur;
		
		for (int i = 0; i < shooter.length; i++) {
			
			//이 궁수가 쏠 적 찾기
			if(shooter[i]) {
				Queue<int[]> queue = new LinkedList<>();
				d=0;
				queue.offer(new int[] {N,i}); //d=0
				List<int[]> shootAvail = new ArrayList<>();
				boolean[][] visited = new boolean[N][M];
				
				while(!queue.isEmpty()) {
					size = queue.size();
					
					for (int s = 0; s < size; s++) {
						cur = queue.poll();
						
						for (int j = 0; j < dxdy.length; j++) {
							nx = cur[0] + dxdy[j][0];
							ny = cur[1] + dxdy[j][1];
							
							if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny])	continue;
							
							visited[nx][ny] = true;
							
							if(copy[nx][ny] == 1)	shootAvail.add(new int[] {nx,ny});
							else	queue.offer(new int[] {nx,ny});
							
						}
					}
					
					++d;
					
					if(!shootAvail.isEmpty()) {
						//sort 안해도 0번째가 제일 왼쪽일꺼 같은 느낌..!
						
						shootAvail.sort(new Comparator<int[]>() {
							
							@Override
							public int compare(int[] o1, int[] o2) {
								return o1[1]-o2[1];
							}
						});
						
						shootedEnemy.add(shootAvail.get(0));
						break;
					}
					
					if(d==D)	break;
					
				}
				
				
			}
		}
		
		for(int[] enemy : shootedEnemy) {
			if(copy[enemy[0]][enemy[1]] == 1) {
				count++;
				copy[enemy[0]][enemy[1]] = 0;
			}
		}
		
		
		//System.out.println(count);
		return count;
	}
	
	private void downEnemy() {
		
		for (int i = N-2; i >=0; i--) {
			for (int j = 0; j < M; j++) {
				copy[i+1][j] = copy[i][j];
			}
		}
		
		for (int j = 0; j < M; j++) {
			copy[0][j] = 0;
		}
	}


	private boolean ExistEnemy() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copy[i][j] == 1)	return true;
			}
		}
		
		return false;
	}
}
