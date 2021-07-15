import java.util.HashMap;

class NewsClustering {
    HashMap<String, Integer> set1 = new HashMap<>();
    HashMap<String, Integer> set2 = new HashMap<>();
    double union;
    double inter;
    
    public int solution(String str1, String str2) {
        
        makeSet(set1, str1.toUpperCase());
        makeSet(set2, str2.toUpperCase());
        
        // 두 집합이 모두 공집합일 경우
        if(set1.isEmpty() && set2.isEmpty()) return 65536;
        
        // 다중집합 처리
        for(String key : set1.keySet()) {
            if(set2.containsKey(key)) {
                inter += Math.min(set1.get(key), set2.get(key));
                union += Math.max(set1.get(key), set2.get(key));
                set1.put(key, 0);
                set2.put(key, 0);
            }
            else union += set1.get(key);
        }
        
        for(String key : set2.keySet()) {
            union += set2.get(key);
        }
        
        return (int)(inter / union * 65536);
    }
    
    public void makeSet(HashMap<String, Integer> set, String str) {
        for(int idx = 0; idx < str.length() - 1; idx++) {
            char ch1 = str.charAt(idx);
            char ch2 = str.charAt(idx + 1);
            
            if(!isAlphabet(ch1) || !isAlphabet(ch2)) continue;
            
            String key = new String(new char[]{ch1, ch2});
            set.put(key, set.getOrDefault(key, 0) + 1);
            
        }
    }
    
    public boolean isAlphabet(char ch) {
        return (ch >= 'A' && ch <= 'Z');
    }
}