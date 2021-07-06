import java.util.HashMap;

class DartGame {
    public final HashMap<Character, Integer> bonusMap = new HashMap<>() {
        {
            put('S', 1);
            put('D', 2);
            put('T', 3);
        }};

    public int solution(String dartResult) {
        int[] scores = new int[3];
        int idx = -1;
        
        int i = 0;
        while(idx < 2) {
            int nidx = 0;
            int score = (dartResult.charAt(i + 1) == '0') ? Integer.parseInt(dartResult.substring(i, i + (nidx += 2))) : dartResult.charAt(i + nidx++) - '0';
            char bonus = dartResult.charAt(i + nidx++);
            char option = (i + nidx < dartResult.length()) ? dartResult.charAt(i + nidx++) : ' ';
                
            scores[++idx] = (int) Math.pow(score, bonusMap.get(Character.valueOf(bonus)));
            if(option == '*') {
                if(idx > 0) 
                    scores[idx - 1] *= 2;
                
                scores[idx] *= 2;
            }
            else if(option == '#') {
                scores[idx] *= -1;
            }
            else {
                i += nidx - 1;
                continue;
            }
            
            i += nidx;
        }
        
        int total_score = 0;
        for(int j = 0; j < 3; j++)
            total_score += scores[j];
        
        return total_score;
    }    
}
