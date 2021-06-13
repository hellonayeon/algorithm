import java.util.HashMap;

public class Lotto {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer num : lottos) map.put(num, map.getOrDefault(num, 0) + 1);
        
        int count = 0;
        for(Integer num : win_nums) 
            if(map.containsKey(num)) count++;
        
        answer[1] = (count == 0) ? 6 : 7 - count;

        if(map.containsKey(0))
            answer[0] = ((count + map.get(0)) == 0) ? 6 : 7 - (count + map.get(0));
        else
            answer[0] = answer[1];

        return answer;
    }
}
