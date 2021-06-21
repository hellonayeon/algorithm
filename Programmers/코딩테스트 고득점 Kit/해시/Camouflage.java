import java.util.HashMap;

class Camouflage {
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        // key[kind of clothes], value[count(same kind of cloth)]
        for(String[] cloth : clothes)
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
            
        int ans = clothes.length;
        
        if(map.size() > 1) {
            int count = 1;
            
            for(String kind : map.keySet())
                count *= map.get(kind) + 1;
            
            ans = count - 1;
        }      
        return ans;
    }
}
