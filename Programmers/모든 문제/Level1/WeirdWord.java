class WeirdWord {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        
        int cur_idx = 0;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == ' ')
                cur_idx = 0;
            else
                chars[i] = (cur_idx++ % 2 == 0) ? Character.toUpperCase(chars[i]) : Character.toLowerCase(chars[i]);
        }
        
        return String.valueOf(chars);
    }
}
