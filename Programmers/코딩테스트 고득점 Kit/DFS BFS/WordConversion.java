class WordConversion {
    private int ans;
    private boolean[] used;

    public int solution(String begin, String target, String[] words) {    
        ans = 51;  
        used = new boolean[words.length];

        dfs(begin, target, words, 0);
        return (ans != 51) ? ans : 0;
    }
    
    public void dfs(String word, String target, String[] words, int step) {
        if(word.equals(target)) {
            ans = (step < ans) ? step : ans;
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(!used[i] && check(word, words[i])) {
                used[i] = true;
                dfs(words[i], target, words, step+1);
                used[i] = false;
            }     
        }
    }

    public boolean check(String w1, String w2) {
        int cnt = 0;
        for(int i = 0; i < w1.length(); i++)
            if(w1.charAt(i) != w2.charAt(i)) cnt++;
        
        return (cnt == 1) ? true : false;
    }
}
