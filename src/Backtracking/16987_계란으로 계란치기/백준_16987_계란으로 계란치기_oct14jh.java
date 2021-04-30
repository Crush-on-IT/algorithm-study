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
	
	private static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine().trim());

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
	
	private static void dfs(int handEgg, int count) {
		result = Math.max(result, count);
		
		if(handEgg == N) {
			return;
		}
		
		if(box[handEgg].durability <= 0) {
			dfs(handEgg + 1, count);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(handEgg != i && box[i].durability > 0) {
				int breakEggCnt = hit(handEgg, i);
				dfs(handEgg + 1, count + breakEggCnt);
				box[handEgg].durability += box[i].weight;
				box[i].durability += box[handEgg].weight;
			}
		}
	}
	
	private static int hit(int handEgg, int nextEgg) {
		int tempCount = 0;
		
		box[handEgg].durability -= box[nextEgg].weight;
		box[nextEgg].durability -= box[handEgg].weight;
		
		if(box[handEgg].durability <= 0)
			tempCount++;
		if(box[nextEgg].durability <= 0)
			tempCount++;
		
		return tempCount;
	}
}
