import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_12865_평범한배낭_oct14jh {
	private static class Item {
		int weight;
		int value;
		public Item() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Item(int weight, int value) {
			super();
			this.weight = weight;
			this.value = value;
		}
	}
	
	private static int N, K;
	private static Item[] items;
	private static int[][] maxValueForEachWeight;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K= Integer.parseInt(st.nextToken());
		
		maxValueForEachWeight = new int[N+1][K+1];
		
		items = new Item[N+1];
		items[0] = new Item(0, 0);
		for(int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		process();
		System.out.println(maxValueForEachWeight[N][K]);
		br.close();
	}
	
	private static void process() {
		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j <= K ; j++) {
				maxValueForEachWeight[i][j] = maxValueForEachWeight[i-1][j];
				
				if(j - items[i].weight >= 0) {
					int previousValue = maxValueForEachWeight[i-1][j];
					int restWeightValue = maxValueForEachWeight[i-1][j-items[i].weight];
					int currentValue = items[i].value;
					maxValueForEachWeight[i][j] = Math.max(previousValue, restWeightValue+currentValue);
				}
			}
		}
	}
	

}
