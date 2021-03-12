package sumin.programmers.highscoreKIT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class 해시_베스트앨범 {
	static class Genre{
		int total;
		PriorityQueue<Song> songs;
		public Genre(int total, PriorityQueue<Song> songs) {
			super();
			this.total = total;
			this.songs = songs;
		}
		@Override
		public String toString() {
			return "Genre [total=" + total + ", songs=" + songs + "]";
		}
	}
	static class Song implements Comparable<Song>{
		int no;
		int play;
		public Song(int no, int play) {
			super();
			this.no = no;
			this.play = play;
		}
		@Override
		public String toString() {
			return "Song [no=" + no + ", play=" + play + "]";
		}
		@Override
		public int compareTo(Song o) {
			return o.play-this.play;
		}
		
	}
	public static void main(String[] args) {
		int[] answer = solution(new String[] {"classic", "pop", "classic", "classic", "pop"},new int[]	{500, 600, 150, 800, 2500});
		System.out.println(Arrays.toString(answer));
	}
	
	public static int[] solution(String[] genres, int[] plays) {
        int[] answer;
        int cnt = 0;
        
        HashMap<String,Genre> map = new HashMap<>();
        PriorityQueue<Song> pq = null; 
        
        for (int i = 0; i < genres.length; i++) {
			String G = genres[i];
			int P = plays[i];
			if(map.containsKey(G)) {
				Genre genre = map.get(G);
				genre.total +=P;
				genre.songs.offer(new Song(i,P));
				
				map.put(G, genre);
				if(genre.songs.size()==2)	--cnt;
			}
			else {
				pq = new PriorityQueue<>();
				pq.offer(new Song(i,P));
				
				map.put(G,new Genre(P,pq));
				++cnt;
			}
		}
        int size= map.size()*2-cnt;
        answer = new int[size];
        
        
        //for(String genre:map.keySet()) {
        //	System.out.println(map.get(genre).toString());
        //}
        
        List<Genre> genrelist = new ArrayList(map.values());
        
        Collections.sort(genrelist,new Comparator<Genre>() {

			@Override
			public int compare(Genre o1, Genre o2) {
				return o2.total-o1.total;
			}
        	
        });
        
        int idx=0;
        for(Genre genre : genrelist) {
			answer[idx++] = genre.songs.poll().no;
			if(!genre.songs.isEmpty())	answer[idx++] = genre.songs.poll().no;
        }
        
        return answer;
    }
}
