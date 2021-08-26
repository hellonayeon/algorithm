// 우선순위 큐의 특성 생각하기
import java.util.PriorityQueue;
import java.util.Collections;

class OvertimeIndex {
    public long solution(int n, int[] works) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int time = 0;
        for(int w : works) {
            pq.offer(w);
            time += w;
        }
        
        if(time <= n) return ans; 
        
        while(n-- != 0) {
            int w = pq.poll();
            pq.offer(--w);
        }
        
        for(int w : pq)
            ans += w * w;
        
        return ans;
    }
}