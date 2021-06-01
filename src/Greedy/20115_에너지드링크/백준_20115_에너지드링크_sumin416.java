import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            max = list[i] > max ? list[i] : max;
        }
        double res = max;
        for(int i = 0; i < N; i++) {
            if(list[i] != max) res+=list[i]/2.0;
        }
        System.out.println(res);
    }
}
