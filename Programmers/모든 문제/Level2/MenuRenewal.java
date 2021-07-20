import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Arrays;

class MenuRenewal {
    
    HashMap<String,Integer> map;
    int max;
    
    public String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> queue = new PriorityQueue<>();
        
        for(int i = 0;i < orders.length;i++){
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        } 
        
        for (int i = 0; i < course.length; i++){
            map = new HashMap<>();
            max = 0;
            
            for (int j=0;j<orders.length;j++) {
                combi("", 0, 0, course[i], orders[j]);
            }
            
            for (String key : map.keySet()){
                if (max >= 2 && map.get(key) == max){
                    queue.offer(key);
                }
            }
        }

        String  ans[] = new String[queue.size()];
        int idx = 0;
        while (!queue.isEmpty()){
            ans[idx++] = queue.poll();
        }
        
        return ans;
    }
    
    void combi(String str, int idx, int cnt, int n, String word){
        if (cnt == n){
            map.put(str, map.getOrDefault(str, 0) + 1);
            max = Math.max(max, map.get(str));
            return;
        }
        
        for (int i=idx;i<word.length();i++){
            char c =word.charAt(i);
            combi(str+c, i+1, cnt+1, n, word);
        }
    }
}