class NRadixGame {
    public String solution(int n, int t, int m, int p) {
        String nums = "0";
        
        for(int num = 1; nums.length() < t * m; num++) {
            String trans = "";
            int tmp = num;
            
            while(tmp != 0) {
                if(tmp % n >= 10) trans = (char)(tmp % n + 55) + trans;
                else trans = tmp % n + trans;
                tmp /= n;    
            }
            
            nums += trans;
        }
        
        String ans = "";
        for(int k = p - 1; k < t * m; k += m)
            ans += nums.charAt(k);
        
        return ans;
    }
}