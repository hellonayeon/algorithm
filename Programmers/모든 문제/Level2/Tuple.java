import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;

class Tuple {
    public int[] solution(String s) {
        Set<String> tuple = new HashSet<>();
        
        String[] str = s.substring(2, s.length() - 2).replace("},{", " ").split(" ");
        
        Arrays.sort(str, new Comparator<>() {
           @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
          
        int[] ans = new int[str.length];
        int idx = 0;
        for(String ele : str) {
            for(String num : ele.split(",")) {
                if(tuple.add(num)) ans[idx++] = Integer.parseInt(num);
            }
        }
        
        return ans;
    }
}