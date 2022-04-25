import java.util.List;
import java.util.ArrayList;


class FeatureDevelop {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> cnts = new ArrayList<>();
        
        
        int day = (int) Math.ceil((100.0 - progresses[0])/speeds[0]);
        int cnt = 1;
        for (int i=1; i<progresses.length; i++) {
            int nextProgress = progresses[i] + day*speeds[i];
            
            if (nextProgress >= 100) {
                cnt++;
            }
            else {
                cnts.add(cnt);
                cnt = 1;
                day += Math.ceil((100.0 - nextProgress)/speeds[i]);
            }
        }
        cnts.add(cnt);
        
        int[] answer = cnts.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}