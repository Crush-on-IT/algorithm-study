
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dots;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dots = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dots[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dots);

        int start=0,end=0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            System.out.println(new Main().findRight(end) - new Main().findLeft(start) - 1);

        }
    }

    //끝을 찾는다.
    private int findRight(int end){

        int left=0,right = N-1,mid=0;

        while(left<=right){

            mid = (left+right)/2;

            if(dots[mid]<=end)    left = mid+1;
            else    right = mid-1;

        }
        //System.out.print("left:"+left);
        return left;
    }
    //끝을 찾는다.
    private int findLeft(int start){

        int left=0,right = N-1,mid=0;

        while(left<=right){

            mid = (left+right)/2;

            if(dots[mid]<start)    left = mid+1;
            else    right = mid-1;

        }

        //System.out.print(" right:"+right);
        return right;
    }
}