class StringCompress {
    public int solution(String s) {
        int slen = s.length();
        int min = slen;
        
        for(int unit = 1; unit <= slen / 2; unit++) {
            
            int cnt = 1;
            int pos = unit;
            String pattern = s.substring(0, pos);
            String compress = "";
            
            while(pos < slen) {
                String next = "";
                if(pos + unit > slen) next = s.substring(pos);
                else next = s.substring(pos, pos + unit);
                
                if(next.equals(pattern)) cnt++;
                else {
                    compress += (cnt > 1) ? cnt + pattern : pattern;
                    cnt = 1;
                    pattern = next;
                }
                
                pos += unit;
            }
            compress += (cnt > 1) ? cnt + pattern : pattern;
            min = Math.min(min, compress.length());
        }
        return min;
    }
}