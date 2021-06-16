class Year2016 {
    public String solution(int a, int b) {        
        int[] date = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] day = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED" };
        
        for(int month = 1; month < a; month++)
            b += date[month];
   
        return day[b % 7];
    }
}