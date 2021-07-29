import java.util.HashSet;

class WordChainGame {
    public int[] solution(int n, String[] words) {
        HashSet<String> usedWords = new HashSet<>(); // 나온 단어들 저장

        int cnt = 1;
        char pre = words[0].charAt(words[0].length() - 1);
        
        usedWords.add(words[0]);
        
        for(; cnt < words.length; cnt++) {
            String w = words[cnt];
            
            if(!usedWords.add(w) || w.charAt(0) != pre) break;
            
            pre = w.charAt(w.length() - 1);
        }
        
        if(cnt == words.length) return new int[]{0, 0};

        return new int[]{ cnt%n+1, cnt/n+1 };
    }
}