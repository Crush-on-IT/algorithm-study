import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static class Room{
		int start;
		int end;
		public Room(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		
		List<Room> rooms = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
				
			rooms.add(new Room(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(rooms,(o1,o2)->o1.start-o2.start);
		
		PriorityQueue<Room> pq = new PriorityQueue<Room>((o1,o2)->o1.end-o2.end);
		
		Room room = null, pqRoom = null;
		for (int i = 0; i < rooms.size(); i++) {
			room = rooms.get(i);
			
			if(pq.isEmpty() || pq.peek().end > room.start) {
				pq.add(room);
			}
			else {
				pqRoom = pq.poll();
				pqRoom.end = room.end;
				pq.add(pqRoom);
			}
		}
		
		System.out.println(pq.size());
		
	}
}
