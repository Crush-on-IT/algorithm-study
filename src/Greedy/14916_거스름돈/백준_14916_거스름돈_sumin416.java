import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt2=0, cnt5=0;
        int sub = 0;
        cnt5 = N/5;

        while(cnt5>=0){
            sub = N - 5 * cnt5;
            if(sub % 2 == 0){
                cnt2 = sub/2;
                break;
            }

            --cnt5;
        }

        int result = cnt2+cnt5;

        if(cnt5<0)  result = -1;

        System.out.println(result);
    }
}
