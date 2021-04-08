import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        Deque<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; ++i){
            st = new StringTokenizer(br.readLine()," ");

            switch(st.nextToken()){
                case "push_front":
                    deque.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    System.out.println(deque.size()!=0?deque.pollFirst():-1);
                    break;
                case "pop_back":
                    System.out.println(deque.size()!=0?deque.pollLast():-1);
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    System.out.println(deque.size()!=0?0:1);
                    break;
                case "front":
                    System.out.println(deque.size()==0?-1:deque.peekFirst());
                    break;
                case "back":
                    System.out.println(deque.size()==0?-1:deque.peekLast());
                    break;
            }
        }

    }
}
