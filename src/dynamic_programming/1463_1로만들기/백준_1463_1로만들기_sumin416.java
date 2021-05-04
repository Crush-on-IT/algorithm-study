import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{

   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int X = Integer.parseInt(br.readLine());
      
      int[] memo = new int[X+1];
      
      for (int i = 1; i <= X; i++) {
         memo[i] = Integer.MAX_VALUE;
      }
      memo[0] = 0;
      memo[1] = 0;
      
      for (int i = 2; i <= X; i++) {
         if(i%3 == 0) {
            memo[i] = 1+memo[i/3];
         }
         if(i%2 == 0) {
            memo[i] = Math.min(memo[i], 1+ memo[i/2]);
         }
         memo[i] = Math.min(memo[i], 1+ memo[i-1]);
      }
      ///System.out.println(Arrays.toString(memo));
      System.out.println(memo[X]);
   }
   
}
