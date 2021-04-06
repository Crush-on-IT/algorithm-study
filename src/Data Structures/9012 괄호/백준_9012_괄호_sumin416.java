
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        loop:
        for (int i = 0; i < N; i++) {

            String input = br.readLine();
            int cnt = 0;
            for (int j = 0 ; j < input.length() ; ++j){
                char ch = input.charAt(j);

                switch(ch){
                    case '(':
                        ++cnt;
                        break;
                    case ')':
                        --cnt;
                        break;
                }

                if(cnt<0)   break;
            }

            if(cnt == 0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
