import java.util.Stack;

class ParenthesisConversion {
    
    Stack<Character> stack = new Stack<>();
    
    public String solution(String p) {
        return conversion(p);
    }
    
    public String conversion(String w) {
        if(w.length() == 0) return "";
        
        String u = "";
        String v = "";
        
        int idx = 0;
        char c = w.charAt(idx);
        stack.push(c);
        u += c;
        
        // 균형잡힌 괄호 문자열 단위 찾기
        while(!stack.isEmpty()) {
            char nc = w.charAt(++idx);
            if(nc == stack.peek()) stack.push(nc);
            else stack.pop();
            u += nc; 
        }
        v = w.substring(idx+1);
        
        // 'u'가 올바른 괄호 문자열인지 판별
        if(u.charAt(0) == '(') return u + solution(v);
        else return "(" + solution(v) + ")" + reverse(u);
    }
    
    // u의 앞뒤 문자 제거, 나머지 문자의 괄호 방향 뒤집기
    public String reverse(String u) {
        char[] chs = u.substring(1, u.length() - 1).toCharArray();
        for(int i = 0; i < chs.length; i++)
            chs[i] = (chs[i] == '(') ? ')' : '(';
        
        return new String(chs);
    }
}
