import java.util.PriorityQueue;
import java.util.Collections;

class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        int[] ans = new int[2];
        
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String op : operations) {
            String[] cmd = op.split(" ");
            
            switch(cmd[0]) {
                case "I":
                    minQ.offer(Integer.parseInt(cmd[1]));
                    maxQ.offer(Integer.parseInt(cmd[1]));
                    break;
                case "D":
                    if(!minQ.isEmpty()) {
                        if(cmd[1].equals("1")) {
                            int val = maxQ.poll();
                            minQ.remove(val);
                        }
                        else {
                            int val = minQ.poll();
                            maxQ.remove(val);
                        }
                    }
            }
        }
        
        if(!minQ.isEmpty()) {
            ans[0] = maxQ.poll();
            ans[1] = minQ.poll();
        }
        
        return ans;
    }
}