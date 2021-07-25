class JadenCase {
    public String solution(String s) {
        char[] chs = s.toLowerCase().toCharArray();

        boolean change = true;
        for(int idx = 0; idx < chs.length; idx++) {
            char ch = chs[idx];
            if(ch == ' ') {
                change = true;
                continue;
            }
            if(change && ch >= 'a' && ch <= 'z') chs[idx] -= 32;
            
            change = false;
        }

        return String.valueOf(chs);
    }
}