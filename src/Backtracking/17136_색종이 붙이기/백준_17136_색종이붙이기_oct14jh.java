package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_17136_색종이붙이기_oct14jh {
	private static int[][] map = new int[10][10];
	private static int[] coloredPaper = {0, 0, 0, 0, 0};
	private static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 일단 색종이를 채워야하는 곳을 탐색한다.
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(map[i][j] >= 1)
					attaching(i, j);
			}
		}
		
		// 결과 출력
		for(int i = 0; i < 5; i++) {
			result += coloredPaper[i];
		}
		System.out.println(result);
		br.close();
	}
	
	// 1이 처음 등장하는 (r, c) 기준으로 연결된 것들 중 정사각형 형태로 붙여진 애들 체크하면서 색종이 채우기
	private static void attaching(int r, int c) {
		int paperSize = 0;
		int rowSize = rowSize(r, c, map[r][c]);
		int colSize = colSize(r, c, map[r][c]);
		if(rowSize <= colSize) {	// row길이 사각형
			paperSize = rowSize;
			process(r, c, paperSize);
		} else {	// col길이 사각형
			paperSize = colSize;
			process(r, c, paperSize);
		}
	}
	
	private static void process(int r, int c, int paperSize) {
		for(int i = 0; i < paperSize; i++) {
			for(int j = 0; j < paperSize; j++) {
				map[r+i][c+j] = paperSize;
			}
		}
	}
	
	
	private static int rowSize(int r, int c, int currentSize) {
		int size = 1;
		int next = r;
		while(true) {
			next++;
			if(!isLineOut(next, c)) {
				if(map[next][c] == 1) {
					if(size >= 5) {
						break;
					} else {
						size++;
					}
				}else {
					break;
				}
			} else {
				break;
			}
		}
		return size;
	}
	
	private static int colSize(int r, int c, int currentSize) {
		int size = 1;
		int next = c;
		while(true) {
			next++;
			if(!isLineOut(r, next)) {
				if(map[r][next] == 1 ) {
					if(size >= 5) {
						break;
					} else {
						size++;
					}
				}else {
					break;
				}
			} else {
				break;
			}
		}
		return size;
	}	
	
	private static boolean isLineOut(int r, int c) {
		if(r < 0 || r >= 10 || c < 0 || c >= 10)
			return true;
		return false;
	}
}
