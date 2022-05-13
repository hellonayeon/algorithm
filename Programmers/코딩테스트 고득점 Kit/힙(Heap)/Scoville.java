import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }
        
        int answer = 0;
        while (pq.peek() < K && pq.size() >= 2) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            
            int sc = s1 + s2*2;
            pq.add(sc);
            
            answer++;
        }
        
        return (pq.peek() < K) ? -1 : answer;
    }
}