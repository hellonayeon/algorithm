import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    
    class Genre implements Comparable<Genre> {
        String name;
        int plays;
        
        public Genre(String name, int plays) {
            this.name = name;
            this.plays = plays;
        }
        
        @Override
        public int compareTo(Genre g) {
            return g.plays - this.plays;
        }
    }
    
    class Album implements Comparable<Album> {
        int id;
        int play;
        
        public Album(int id, int play) {
            this.id = id;
            this.play = play;
        }
        
        @Override
        public int compareTo(Album a) {
            if (this.play == a.play) {
                return this.id - a.id;
            }
            return a.play - this.play;
        }
    }
    
    
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> gMap = new HashMap<>(); // 장르 별 플레이 수
        List<Genre> gList = new ArrayList<>();
        Map<String, PriorityQueue<Album>> aMap = new HashMap<>(); // 장르 별 수록 앨범 우선순위
        
        for (int i=0; i<genres.length; i++) {
            gMap.put(genres[i], gMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        for (String genre : gMap.keySet()) {
            gList.add(new Genre(genre, gMap.get(genre)));
            aMap.put(genre, new PriorityQueue<Album>());
        }
        Collections.sort(gList);
        
        for (int i=0; i<genres.length; i++) {
                aMap.get(genres[i]).add(new Album(i, plays[i]));
        }
        
        List<Integer> ids = new ArrayList<>();
        for (int i=0; i<gList.size(); i++) {
            Genre genre = gList.get(i);
            PriorityQueue<Album> pq = aMap.get(genre.name);
            
            int cnt = 0;
            while (cnt++ < 2) {
                if (pq.size() == 0) break;
                Album album = pq.poll();
                ids.add(album.id);
            }
        }
        
        int[] answer = new int[ids.size()];
        for (int i=0; i<ids.size(); i++) {
            answer[i] = ids.get(i);
        }
        
        return answer; 
    }
}