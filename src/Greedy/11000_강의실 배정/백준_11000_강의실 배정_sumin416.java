import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static class Room{
        int start;
        int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        int s,e;

        List<Room> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            list.add(new Room(s,e));
        }

        Collections.sort(list, ((o1, o2) -> o1.start - o2.start));
        PriorityQueue<Room> pq = new PriorityQueue<>((o1,o2)->o1.end - o2.end);

        for (Room room : list) {
            if(pq.isEmpty() || pq.peek().end > room.start ){
                pq.add(room);
            }
            else{
                pq.poll();
                pq.add(room);
            }
        }
        System.out.println(pq.size());
    }
}
