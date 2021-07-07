class Number124 {
    public String solution(int n) {
        String ans = "";
        String[] nums = {"4", "1", "2"};
        
        while(n > 0) {
            ans = nums[n % 3] + ans;
            n = (n - 1) / 3;
        }
        
        return ans;
    }
}