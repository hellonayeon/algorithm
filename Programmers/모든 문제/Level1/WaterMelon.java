class WaterMelon {
    public String solution(int n) {
        String ans = "";
        
        for(int i = 0; i < n/2; i++)
            ans += "수박";
        
        return (n % 2 == 0) ? ans : ans + "수";
    }        
}
