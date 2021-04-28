import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16987_계란으로계란치기_oct14jh {
	private static class Egg {
		int durability;
		int weight;
		public Egg() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Egg(int durability, int weight) {
			super();
			this.durability = durability;
			this.weight = weight;
		}
		public int getDurability() {
			return durability;
		}
		public void setDurability(int durability) {
			this.durability = durability;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Egg [durability=" + durability + ", weight=" + weight + "]";
		}
	}
	
	private static int N;
	private static Egg[] box;
	
	private static boolean visited[];
	private static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine().trim());

		visited = new boolean[N];
		box = new Egg[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			box[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		dfs(0, 0);
		
		if(result == Integer.MIN_VALUE)
			System.out.println(0);
		else 
			System.out.println(result);
		
		br.close();
	}
	
	private static void dfs(int index, int count) {
		if(index == N) {
			result = Math.max(count, result);
			return;
		} else {
			boolean brokenEgg = true;
			
			for(int i = 0; i < N; i++) {
				if(!visited[i])
					brokenEgg = false;
				if(!visited[i] && i != index) {
					box[i].durability -= box[index].weight;
					box[index].durability -= box[i].weight;
					int tempCount = 0;
					if(box[index].durability <= 0) {
						visited[index] = true;
						tempCount++;
					}
					if(box[i].durability <= 0) {
						visited[i] = true;
						tempCount++;
					}
					
					dfs(index + 1, count + tempCount);
					
					if(box[index].durability <= 0) {
						visited[index] = false;
					}
					if(box[i].durability <= 0) {
						visited[i] = false;
					}
					box[index].durability += box[i].weight;
					box[i].durability += box[index].weight;
				}
			}
			
			if(!brokenEgg)
				dfs(N, count);
		}
	}
}
