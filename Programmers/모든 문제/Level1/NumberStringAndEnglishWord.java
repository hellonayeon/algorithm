import java.util.Map;
import java.util.HashMap;

class NumberStringAndEnglishWord {
    
    Map<String, Integer> map = new HashMap<>() {{
        put("zero", 0); put("one", 1);  put("two", 2);  put("three", 3);
        put("four", 4);  put("five", 5);  put("six", 6);  put("seven", 7);
        put("eight", 8);  put("nine", 9);
    }};
    
    public int solution(String s) {        
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch >= '0' && ch <= '9') {
                answer.append(ch);
                continue;
            }
            
            sb.append(ch);
            if (map.containsKey(sb.toString())) {
                answer.append(map.get(sb.toString()));
                sb = new StringBuilder();
            }
        }
        
        return Integer.parseInt(answer.toString());
    }
}