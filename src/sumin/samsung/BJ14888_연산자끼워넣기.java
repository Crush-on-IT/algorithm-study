package sumin.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ14888_연산자끼워넣기 {

	static int N,min,max;
	static int[] numbers,symbols;
	public static void main(String[] args) throws NumberFormatException, IOException {
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N];
		symbols = new int[5];
		
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(input[i]); 
		}
		
		String[] input2 = br.readLine().split(" ");
		for (int i = 0; i < 4; i++) {
			symbols[i+1] = Integer.parseInt(input2[i]);
		}
		//symbol 순열 만들기
		int[] arr = new int[N-1];
		nextPermutation(symbols,0,arr);
		
		System.out.println(max);
		System.out.println(min);
	}
	private static void nextPermutation(int[] availSymbols, int cnt, int[] arr) {
		if(cnt==N-1) {
			//arr완성
			//System.out.println(Arrays.toString(arr));
			//계산하기
			int result = cal(arr);
			
			if(result>max)	max=result;
			if(result<min)	min = result;
			
			return;
		}

		//배열 복사
		int[] availSymbolsCopy = new int[5];
		for (int i = 1; i < availSymbols.length; i++) {
			availSymbolsCopy[i] = availSymbols[i];
		}
		
		for (int i = 1; i < availSymbolsCopy.length; i++) {
			//기호 안남았으면
			if(availSymbolsCopy[i] == 0)	continue;
			
			//기호 남았으면
			--availSymbolsCopy[i];
			arr[cnt] = i;
			nextPermutation(availSymbolsCopy,cnt+1,arr);
			availSymbolsCopy[i]++;
		}
	}
	private static int cal(int[] arr) {
		//arr에는 기호를 숫자로 배열
		//numbers에는 숫자
		
		int tmp = numbers[0];
		
		for (int i = 0; i < arr.length; i++) {
			//숫자 꺼내기
			int tmp2 = numbers[i+1];
			
			switch(arr[i]) {
				case 1:
					tmp+=tmp2;
					break;
				case 2:
					tmp-=tmp2;
					break;
				case 3:
					tmp*=tmp2;
					break;
				case 4:
					tmp/=tmp2;
					break;
			}
			
		}
		
		return tmp;
	}

}

