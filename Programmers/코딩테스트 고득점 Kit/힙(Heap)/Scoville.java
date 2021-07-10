import java.util.PriorityQueue;

class Scoville {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int s : scoville) 
            queue.add(s);
        
        int cnt = 0;
        while(queue.size() >= 2 && queue.peek() < K ) {
            int s1 = queue.poll();
            int s2 = queue.poll();
            queue.add(s1 + (s2 * 2));
            
            cnt++;
        }
        
        return (queue.peek() >= K) ? cnt : -1;
    }
}