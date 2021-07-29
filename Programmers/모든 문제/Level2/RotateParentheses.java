import java.util.Stack;

class RotateParentheses {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        StringBuilder sb = new StringBuilder(s);
        int ans = 0;
        int n = 0;
        while(n++ < s.length()) {
            boolean correct = true;
                        
            for(int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if(c == '(' || c == '{' || c == '[') stack.push(c);
                else {
                    if(stack.isEmpty()) {
                        correct = false;
                        break;
                    }
                    
                    int match = (int)stack.peek() - (int)c;
                    if(Math.abs(match) <= 2) stack.pop();
                }
            }
            
            ans += (correct && stack.isEmpty()) ? 1 : 0;
            
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
        }
        
        return ans;
    }
}
