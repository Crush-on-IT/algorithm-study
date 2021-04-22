import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] desks = new int[N];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            desks[i] = Integer.parseInt(br.readLine());
            min = Math.min(min,desks[i]);
        }

        long start= 0, end = (long)min*M,mid=0,sum=0;

        while(start<=end){
            mid = (start + end)/2;
            sum = 0;

            for (int i = 0; i < N; i++) {
                sum  += mid/desks[i];
            }

            if(sum>=M)  end = mid-1;
            else    start = mid+1;
        }

        System.out.println(start);
    }

}