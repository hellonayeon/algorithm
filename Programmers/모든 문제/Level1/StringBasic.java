class StringBasic {
    public boolean solution(String s) {  
        // 문자열 s의 길이가 4 혹은 6인지 검사
        if(s.length() == 4 || s.length() == 6) {
           // 숫자로만 구성돼있는지 검사
            try { 
                Integer.parseInt(s); 
                return true;
            } 
            catch(NumberFormatException nfe) { 
                return false; 
            } 
        }
        else return false;
    }   
}
