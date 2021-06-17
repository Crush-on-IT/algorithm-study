import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int N,M;
    static long result=0;
    static long[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new long[N];

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        find(0,trees[N-1]);

        System.out.println(result);
    }

    private static void find(long start, long end) {

        if(start>end)   return;

        long mid = (start+end)/2;
        long tmp = 0;

        for (int i = 0 ; i < N; i++) {
            if(trees[i]-mid > 0)
                tmp += trees[i] - mid;
        }

        if(tmp >= M){
            result = Math.max(result,mid);
            find(mid+1,end);
        }
        else    find(start,mid-1);
    }
}
