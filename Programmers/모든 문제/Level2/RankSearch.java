import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class RankSearch {
    
    HashMap<String, ArrayList<Integer>> infoMap = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {                
        for(int idx = 0; idx < info.length; idx++)
            setInfo(info[idx].split(" "), "", 0);
        
        for(String key : infoMap.keySet()) 
            Collections.sort(infoMap.get(key));
        
        return match(query);
    }
    
    public void setInfo(String[] info, String str, int depth) {
        if(depth == 4) {
            if(!infoMap.containsKey(str)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(info[4]));
                infoMap.put(str, list);
            }
            else infoMap.get(str).add(Integer.parseInt(info[4]));
            return;
        }
        
        setInfo(info, str+"-", depth+1);
        setInfo(info, str+info[depth], depth+1);
    }
    
    public int[] match(String[] query) {
        int[] ans = new int[query.length];
        
        for(int i = 0; i < query.length; i++) {
            String[] element = query[i].split(" ");
            
            String key = "";
            for(int j = 0; j < element.length-1; j++) {
                if(element[j].equals("and")) continue;
                key += element[j];
            }
            
            if(!infoMap.containsKey(key)) continue;
            
            ArrayList<Integer> scores = infoMap.get(key);
            int score = Integer.parseInt(element[element.length-1]);
            int start = 0, end = scores.size() - 1;
            while(start <= end){
                int mid = (start + end) / 2;
                if(scores.get(mid) < score){
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
            
            ans[i] = scores.size() - start;
        }
        
        return ans;
    }
}