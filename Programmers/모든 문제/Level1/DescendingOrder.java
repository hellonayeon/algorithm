import java.util.Arrays;

class DescendingOrder {
    public long solution(long n) {
        char[] chs = (n + "").toCharArray();
        
        Arrays.sort(chs);
        
        StringBuilder sb = new StringBuilder(new String(chs, 0, chs.length));
        
        return Long.parseLong(sb.reverse().toString());
    }
}
