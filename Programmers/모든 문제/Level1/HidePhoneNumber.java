class HidePhoneNumber {
    public String solution(String phone_number) {
        char[] chs = phone_number.toCharArray();
        
        for(int i = 0; i < phone_number.length() - 4; i++)
            chs[i] = '*';
        
        return String.valueOf(chs);
    }    
}
