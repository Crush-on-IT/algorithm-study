import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3980_선발명단 {
	private static int[][] ManU;
	private static boolean[] isSelected;
	private static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int testCase = 1; testCase <= T; testCase++) {
			// 테스트케이스별 초기화
			ManU = new int[11][11];
			isSelected = new boolean[11];
			result = Integer.MIN_VALUE;
			
			// 입력 [선수][포지션별능력]
			for(int i = 0; i < 11; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < 11; j++) {
					ManU[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 본인은 처음에 여기서 각 선수인덱스별로 포문돌리면서 순열 돌릴려고 함...
			// 선수인덱스 초기값 0, 종합능력치 초기값 0으로 메소드
			process(0, 0);
			System.out.println(result);
		}
	}
	
	
	private static void process(int playerIndex, int totalAbility) {
		if(playerIndex == 11) {	// 11번째 인덱스를 체크하려할 때 이제 그냥 끝내버리기
			result = Math.max(result, totalAbility);	// 저장되어 들어와있는 totalAbility와 전역변수에 저장된 result 비교
			return;
		}
		
		for(int position = 0; position < 11; position++) {	// 포지션별 능력치 체크
			if(ManU[playerIndex][position] == 0 || isSelected[position])	// 포지션에 등록된 선수가 있거나 선수의 능력치가 0이면 skip
				continue;
			
			isSelected[position] = true;	// 해당 포지션에 선수를 채웠다 가정하고
			process(playerIndex + 1, totalAbility + ManU[playerIndex][position]); // 다음 선수 체크 및 능력치 계산
			isSelected[position] = false;		// 해당 포지션에 선수를 안채웠다고 풀어두기.
		}
	}
	

}
