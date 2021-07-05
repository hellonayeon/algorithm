class CaesarCipher {
    public String solution(String s, int n) {
        String ans = "";
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if(ch == ' ') { 
                ans += ch;
                continue;
            }
            
            if(ch >= 'A' && ch <= 'Z')
                ans += (char)(65 + ((ch - 65) + n) % 26);
            else
                ans += (char)(97 + ((ch - 97) + n) % 26);
        }
        
        return ans;
    }
}
