import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String input;
		HashMap<String,Integer> map = new HashMap<>();
		String[] arr = new String[N+1];
		
		StringBuilder sb= new StringBuilder();
		
		for (int i = 1; i <= N; i++) {
			input= br.readLine();
			map.put(input, i);
			arr[i] = input;
		}
		for (int i = 0; i < M; i++) {
			input = br.readLine();
			char ch = input.charAt(0);
			//숫자면
			if(ch>='0'&&ch<='9')
				sb.append(arr[Integer.parseInt(input)]);
			else
				sb.append(map.get(input));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
